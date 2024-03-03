import java.util.*;

class Graph1 {
    @SuppressWarnings("Unchecked")
    protected int v;

    public int getV() {
        return this.v;
    }

    public void setV(int v) {
        this.v = v;
    }

    protected LinkedList<Integer> adj[];

    public Graph1(int v) {
        this.v = v;
        adj = new LinkedList[v];
        for (int i = 0; i < v; i++) {
            adj[i] = new LinkedList<>();
        }
    }

    // method to add edges for an undirected graph

    public void addEdge(int u, int v) {
        adj[u].add(v);
        adj[v].add(u);
    }

}

class CycleUndirected extends Graph1 {

    public CycleUndirected(int v) {
        super(v);
    }
    // helper method for cycle detection
    // recursive dfs method (or : Modified DFS)
    // uses visited[] and parent to detect
    // cycle in subgraph reachable
    // from vertex v.

    private boolean isCycleutil(int v, boolean visited[], int parent) {
        // makes the v node are visited

        visited[v] = true;
        int i;

        // Recur for all the vertices
        // adjacent to this vertex
        Iterator<Integer> it = adj[v].iterator();
        while (it.hasNext()) {
            i = it.next();

            // If an adjacent is not
            // visited, then recur for that
            // adjacent

            if (!visited[i]) {
                if (isCycleutil(i, visited, v))
                    return true;
            }

            else if (i != parent) {
                return true;
            }
        }
        return false;
    }

    // Returns true if the graph
    // contains a cycle, else false.
    public boolean isCyclic() {

        // Mark all the vertices as
        // not visited and not part of
        // recursion stack

        boolean visited[] = new boolean[v];

        for (int i = 0; i < visited.length; i++) {
            visited[i] = false;
        }

        for (int i = 0; i < v; i++) {
            // Don't recur for i if already visited
            if (!visited[i])
                if (isCycleutil(i, visited, -1))
                    return true;
        }
        return false;
    }

}

// Time Complexity:

// O(V+E), The program does a simple DFS Traversal of the graph which is
// represented using an adjacency list. So the time complexity

// is O(V+E).
// Auxiliary Space: O(V), To store the visited

// array O(V) space is required.

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class Graph {
    private int v;

    public static List<Integer> adj[];

    public Graph(int v) {
        this.v = v;
        adj = new LinkedList[v];

        for (int i = 0; i < v; i++) {
            adj[i] = new LinkedList<>();
        }
    }

    public void setVertex(int v) {
        this.v = v;
    }

    public int getVertex() {
        return v;
    }

    public void addEdge(int u, int v) {
        adj[u].add(v);
    }

    public void bfs(int s) {
        Queue<Integer> queue = new LinkedList<>();
        boolean[] visited = new boolean[v];
        visited[s] = true;
        queue.add(s);
        while (queue.size() != 0) {

            // Dequeue a vertex from queue and print it
            s = queue.poll();
            System.out.print(s + " ");

            // Get all adjacent vertices of the dequeued
            // vertex s.
            // If an adjacent has not been visited,
            // then mark it visited and enqueue it
            Iterator<Integer> i = adj[s].listIterator();
            while (i.hasNext()) {
                int n = i.next();
                if (!visited[n]) {
                    visited[n] = true;
                    queue.add(n);
                }
            }
        }
    }

}

public class BFS {
    public static void main(String[] args) {
        Graph g = new Graph(7);
        g.addEdge(0, 1);
        g.addEdge(0, 2);
        g.addEdge(1, 0);
        g.addEdge(1, 3);
        g.addEdge(2, 0);
        g.addEdge(2, 4);
        g.addEdge(3, 1);
        g.addEdge(3, 4);
        g.addEdge(3, 5);
        g.addEdge(4, 2);
        g.addEdge(4, 3);
        g.addEdge(4, 5);
        g.addEdge(5, 3);
        g.addEdge(5, 4);
        g.addEdge(5, 6);
        g.addEdge(6, 5);

        g.bfs(1);

    }
}

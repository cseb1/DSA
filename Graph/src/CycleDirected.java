
// A Java Program to detect cycle in a CycleUndirected
import java.util.ArrayList;

import java.util.Scanner;

// class CycleDirected {

//     private final int V;
//     private final List<List<Integer>> adj;

//     public CycleDirected(int V) {
//         this.V = V;
//         adj = new ArrayList<>(V);

//         for (int i = 0; i < V; i++)
//             adj.add(new LinkedList<>());
//     }

//     // Function to check if cycle exists
//     private boolean isCyclicUtil(int i, boolean[] visited,
//             boolean[] recStack) {

//         // Mark the current node as visited and
//         // part of recursion stack
//         if (recStack[i])
//             return true;

//         if (visited[i])
//             return false;

//         visited[i] = true;

//         recStack[i] = true;
//         List<Integer> children = adj.get(i);

//         for (Integer c : children)
//             if (isCyclicUtil(c, visited, recStack))
//                 return true;

//         recStack[i] = false;

//         return false;
//     }

//     public void addEdge(int source, int dest) {
//         adj.get(source).add(dest);
//     }

//     // Returns true if the CycleUndirected contains a
//     // cycle, else false.
//     public boolean isCyclic() {
//         // Mark all the vertices as not visited and
//         // not part of recursion stack
//         boolean[] visited = new boolean[V];
//         boolean[] recStack = new boolean[V];

//         // Call the recursive helper function to
//         // detect cycle in different DFS trees
//         for (int i = 0; i < V; i++)
//             if (isCyclicUtil(i, visited, recStack))
//                 return true;

//         return false;
//     }

// }

public class CycleDirected {
    static class Edge {
        private int src;
        private int dest;

        public int getSrc() {
            return this.src;
        }

        public void setSrc(int src) {
            this.src = src;
        }

        public int getDest() {
            return this.dest;
        }

        public void setDest(int dest) {
            this.dest = dest;
        }

        public Edge(int src, int dest) {
            this.src = src;
            this.dest = dest;
        }
    }

    public static void createGraph(ArrayList<Edge>[] graph, int v, Scanner scanner) {
        for (int i = 0; i < graph.length; i++) {
            graph[i] = new ArrayList<>();
        }
        for (int i = 0; i < v; i++) {
            System.out.println("Enter the no of edge of " + i + "th node:: ");
            int edge = scanner.nextInt();
            System.out.println("enter the dest of " + i + "th node::");
            for (int j = 0; j < edge; j++) {
                // System.out.println("enter the dest. ");
                int dest = scanner.nextInt();
                graph[i].add(new Edge(i, dest));
            }
        }
    }

    public static void printGraph(ArrayList<Edge>[] gr) {
        for (int i = 0; i < gr.length; i++) {
            System.out.print(i + "-->");
            for (int j = 0; j < gr[i].size(); j++) {
                Edge e = gr[i].get(j);
                System.out.print("  " + e.dest);
            }
            System.out.println();
        }
    }

    public static boolean cycledetect(ArrayList<Edge> graph[], boolean[] vis, int curr, boolean[] stack) {
        vis[curr] = true;
        stack[curr] = true;
        for (int i = 0; i < graph[curr].size(); i++) {
            Edge e = graph[curr].get(i);
            if (stack[e.dest] == true) {
                return true;
            } else if (!vis[e.dest] && cycledetect(graph, vis, e.dest, stack)) {
                return true;
            }
        }
        stack[curr] = false;
        return false;

    }

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.println("Enter the number of edges::");
            int v = scanner.nextInt();
            ArrayList<Edge> graph[] = new ArrayList[v];
            createGraph(graph, v, scanner);

            printGraph(graph);

            boolean vis[] = new boolean[v];
            boolean stack[] = new boolean[v];

            for (int i = 0; i < v; i++) {
                if (!vis[i]) {
                    boolean isCycle = cycledetect(graph, vis, i, stack);
                    if (isCycle) {
                        System.out.println("Yes! cycle is detected");
                        break;
                    }
                }
            }

        }
    }
}
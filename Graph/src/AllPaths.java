import java.util.ArrayList;
import java.util.Scanner;

public class AllPaths {
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

    public static void printAllPaths(ArrayList<Edge>[] graph, boolean[] visited, int src, String path, int target) {
        // base case

        if (src == target) {
            for (int i = 0; i < path.length(); i++) {
                System.out.print(path.charAt(i) + " ");
            }
            System.out.println();
            return;
        }

        for (int i = 0; i < graph[src].size(); i++) {
            Edge e = graph[src].get(i);
            if (!visited[e.dest]) {
                visited[src] = true;
                printAllPaths(graph, visited, e.dest, path + e.dest, target);
                visited[src] = false;
            }
        }
    }

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.println("Enter the number of edges::");
            int v = scanner.nextInt();
            ArrayList<Edge> graph[] = new ArrayList[v];
            createGraph(graph, v, scanner);

            printGraph(graph);

            System.out.println("enter the target node::");
            int target = scanner.nextInt();
            System.out.println("All possible path is==>\n");
            printAllPaths(graph, new boolean[v], 0, "0", target);

        }
    }
}

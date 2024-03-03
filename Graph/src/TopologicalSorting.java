import java.util.ArrayList;
import java.util.Scanner;
import java.util.Stack;

public class TopologicalSorting {
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

    private static void topSortingUtil(ArrayList<Edge>[] graph, int curr, boolean[] visited, Stack<Integer> stack) {
        visited[curr] = true;
        for (int i = 0; i < graph[curr].size(); i++) {
            Edge e = graph[curr].get(i);
            if (!visited[e.dest]) {
                topSortingUtil(graph, e.dest, visited, stack);
            }
        }
        stack.push(curr);
    }

    public static void topologySorting(ArrayList<Edge> graph[], int v) {
        Stack<Integer> stack = new Stack<>();
        boolean visited[] = new boolean[v];
        for (int i = 0; i < v; i++) {
            if (!visited[i]) {
                topSortingUtil(graph, i, visited, stack);
            }
        }

        while (!stack.isEmpty()) {
            System.out.println(stack.pop());
        }
    }

    /*
     * 0
     * / \
     * 1 2
     * | |
     * 3---4
     */
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.println("Enter the number of edges::");
            int v = scanner.nextInt();
            ArrayList<Edge> graph[] = new ArrayList[v];
            createGraph(graph, v, scanner);

            printGraph(graph);

            System.out.println("Topology sorting is below given::-->");

            topologySorting(graph, v);

        }
    }
}

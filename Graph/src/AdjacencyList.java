import java.util.ArrayList;
import java.util.Scanner;

public class AdjacencyList {
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

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.println("Enter the number of edges::");
            int v = scanner.nextInt();
            ArrayList<Edge> graph[] = new ArrayList[v];
            cretaeteGraph(graph, v, scanner);
            System.out.print("Neighbour is===");
            for (int i = 0; i < graph[2].size(); i++) {
                Edge e = graph[2].get(i);
                System.out.print(e.getDest() + " ");
            }

        }
    }

    private static void cretaeteGraph(ArrayList<Edge>[] graph, int v, Scanner scanner) {
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
}

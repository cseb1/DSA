import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.Queue;

public class PrimsAlgorithm {
    // gfg problem
    static class Pair { // priority queue contain pair of{distance , node};
        int distance;
        int node;

        public Pair(int distance, int node) {
            this.distance = distance;
            this.node = node;
        }
    }

    static int spanningTree(int V, int E, int edges[][]) {
        // Intiution
        // we take one priority queue and one visited array with size V
        Queue<Pair> q = new PriorityQueue<Pair>((x, y) -> x.distance - y.distance);
        // take an adjacency arraylist to store the graph
        ArrayList<ArrayList<Pair>> adj = new ArrayList<>();
        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<>());
        }
        for (int i = 0; i < edges.length; i++) {
            adj.get(edges[i][0]).add(new Pair(edges[i][2], edges[i][1]));
            adj.get(edges[i][1]).add(new Pair(edges[i][2], edges[i][0]));
        }
        int sum = 0;
        // take a visited array
        int[] visited = new int[V];
        for (int i = 0; i < V; i++) {
            visited[i] = 0;
        }
        q.add(new Pair(0, 0));
        while (!q.isEmpty()) {
            int wt = q.peek().distance;
            int node = q.peek().node;
            q.remove();

            if (visited[node] == 1)
                continue;

            visited[node] = 1;
            sum += wt;

            for (int i = 0; i < adj.get(node).size(); i++) {
                int edw = adj.get(node).get(i).distance;
                int adjNode = adj.get(node).get(i).node;
                if (visited[adjNode] == 0) {
                    q.add(new Pair(edw, adjNode));
                }
            }
        }
        return sum;
    }

    public static void main(String[] args) {
        System.out.println(spanningTree(3, 3, new int[][] { { 0, 1, 5 }, { 1, 2, 3 }, { 0, 2, 1 } }));
    }
}

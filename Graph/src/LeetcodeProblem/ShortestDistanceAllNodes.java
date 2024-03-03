package LeetcodeProblem;

//https://www.geeksforgeeks.org/problems/shortest-path-in-undirected-graph/1
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Stack;

public class ShortestDistanceAllNodes {
    static class Pair {
        int dest;
        int weight;

        public Pair(int dest, int weight) {
            this.dest = dest;
            this.weight = weight;
        }
    }

    public static int[] shortestPath(int N, int M, int[][] edges) {
        // first of all create a adjacency list of the graph
        // which contains the pair of destination node and weight
        ArrayList<ArrayList<Pair>> adj = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            adj.add(new ArrayList<>());
        }

        for (int i = 0; i < edges.length; i++) {
            int u = edges[i][0];
            int v = edges[i][1];
            int wt = edges[i][2];
            adj.get(u).add(new Pair(v, wt));
        }

        // find the toposort
        int[] visited = new int[N];
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < N; i++) {
            if (visited[i] == 0) {
                toposort(adj, i, visited, stack);
            }
        }

        // traverse the stack and find the shortest distance
        int[] dist = new int[N];
        Arrays.fill(dist, (int) 1e9);
        dist[0] = 0; // src to src is distance = zero.
        while (!stack.isEmpty()) {
            int node = stack.peek();
            stack.pop();

            for (Pair it : adj.get(node)) {
                int dest = it.dest;
                int wt = it.weight;
                if (dist[node] + wt < dist[dest]) {
                    dist[dest] = dist[node] + wt;
                }

            }
        }
        int[] ans = new int[N];
        for (int i = 0; i < N; i++) {
            if (dist[i] == (int) 1e9) {
                ans[i] = -1;
            } else {
                ans[i] = dist[i];
            }
        }
        return ans;
    }

    // toposort code nothing but copy paste code from previous day
    private static void toposort(ArrayList<ArrayList<Pair>> adj, int node, int[] visited, Stack<Integer> stack) {
        visited[node] = 1;
        for (Pair it : adj.get(node)) {
            int dest = it.dest;
            if (visited[dest] == 0) {
                toposort(adj, dest, visited, stack);
            }
        }
        stack.push(node);
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(shortestPath(4, 2, new int[][] { { 0, 1, 2 }, { 0, 2, 1 } })));
    }
}

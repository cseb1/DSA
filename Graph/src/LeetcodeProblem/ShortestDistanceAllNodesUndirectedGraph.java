package LeetcodeProblem;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class ShortestDistanceAllNodesUndirectedGraph {
    static class Pair {
        int dest;
        int weight;

        public Pair(int dest, int weight) {
            this.dest = dest;
            this.weight = weight;
        }
    }

    public static int[] shortestPath(int[][] edges, int n, int m, int src) {
        int ans[] = new int[n];
        // we solve this problem using BFS(simple),
        ArrayList<ArrayList<Pair>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }

        for (int i = 0; i < edges.length; i++) {
            int u = edges[i][0];
            int v = edges[i][1];
            adj.get(u).add(new Pair(v, 1));
            adj.get(v).add(new Pair(u, 1));
        }

        int visited[] = new int[n];
        Queue<Pair> queue = new LinkedList<>();
        int[] distance = new int[n];
        Arrays.fill(distance, (int) 1e9);
        distance[src] = 0;

        if (visited[src] == 0) {
            visited[src] = 1;
            queue.add(new Pair(src, 0));
        }

        while (!queue.isEmpty()) {
            int node = queue.peek().dest;
            queue.remove();
            for (Pair it : adj.get(node)) {
                int dest = it.dest;
                int weight = it.weight;
                if (distance[node] + weight < distance[dest]) {
                    distance[dest] = distance[node] + weight;
                }
                if (visited[dest] == 0) {
                    visited[dest] = 1;
                    queue.add(it);
                }
            }
        }
        for (int i = 0; i < n; i++) {
            if (distance[i] == (int) 1e9) {
                ans[i] = -1;
            } else {
                ans[i] = distance[i];
            }
        }
        return ans;

    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(shortestPath(new int[][] { { 0, 1 }, { 0, 3 }, { 3, 4 }, { 4, 5 }, { 5, 6 },
                { 1, 2 }, { 2, 6 }, { 6, 7 }, { 7, 8 }, { 6, 8 } }, 9, 10, 0)));
    }
}

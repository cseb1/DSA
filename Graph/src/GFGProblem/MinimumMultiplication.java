package GFGProblem;

//https://www.geeksforgeeks.org/problems/minimum-multiplications-to-reach-end/1
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class MinimumMultiplication {
    static class Graph {
        private int mod = 100000;

        public class Node {
            private int vertex;
            private int steps;

            public Node(int first, int steps) {
                this.vertex = first;
                this.steps = steps;
            }
        }

        public int dijkstra(int[] arr, int start, int end) {
            if (start == end) {
                return 0;
            }
            Queue<Node> queue = new LinkedList<>();
            queue.add(new Node(start, 0));
            int[] distance = new int[100000];
            Arrays.fill(distance, (int) 1e9);
            distance[start] = 0;
            while (!queue.isEmpty()) {
                Node node = queue.poll();
                int u = node.vertex;
                int steps = node.steps;
                for (int i = 0; i < arr.length; i++) {
                    int v = (arr[i] * u) % mod;
                    if (steps + 1 < distance[v]) {
                        distance[v] = steps + 1;
                        if (v == end) {
                            return steps + 1;
                        }
                        queue.add(new Node(v, steps + 1));
                    }
                }
            }
            return -1;
        }
    }

    static int minimumMultiplications(int[] arr, int start, int end) {
        Graph graph = new Graph();
        return graph.dijkstra(arr, start, end);
    }

    public static void main(String[] args) {
        System.out.println(minimumMultiplications(new int[] { 2, 5, 7 }, 3, 84));
    }
}

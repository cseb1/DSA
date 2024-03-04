package LeetcodeProblem;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;

public class NoWaysToReachDestination {
    static class Pair {
        int first; // first denotes distance
        int second;// second denotes nodes

        public Pair(int first, int second) {
            this.first = first;
            this.second = second;
        }
    }

    public static int countPaths(int n, int[][] roads) { // leetcode problem (leetcode-1976)
        // we take two array namely distance[] and ways[];
        int[] dist = new int[n];
        int[] ways = new int[n];
        int mod = (int) 1e9 + 7;
        // initilazation the array 0 and infinte respectfully
        for (int i = 0; i < n; i++) {
            ways[i] = 0;
            dist[i] = (int) (1e9);
        }

        // src and destination initialize
        int src = 0;
        int dest = n - 1;
        ways[src] = 1; // in reach to source the no of ways are 1
        dist[src] = 0;// in reach to src th cost will be 0;
        // create the graph in the Arraylist form
        // this graph can be bidirectional
        ArrayList<ArrayList<Pair>> adj = new ArrayList<>();
        // initialize the ArrayList
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }

        // create the graph representation
        for (int i = 0; i < roads.length; i++) {
            adj.get(roads[i][0]).add(new Pair(roads[i][2], roads[i][1]));
            adj.get(roads[i][1]).add(new Pair(roads[i][2], roads[i][0]));
        }
        // we need to take an priority queue with pair of{distance,node};
        Queue<Pair> q = new PriorityQueue<>((x, y) -> x.first - y.first);
        q.add(new Pair(0, src));
        while (!q.isEmpty()) {
            Pair it = q.poll();

            int distance = it.first;
            int node = it.second;

            for (Pair itr : adj.get(node)) {
                int edw = itr.first;
                int adjnode = itr.second;

                if (edw + distance < dist[adjnode]) {
                    dist[adjnode] = edw + distance;
                    q.add(new Pair(edw + distance, adjnode));
                    ways[adjnode] = ways[node];
                } else if (edw + distance == dist[adjnode]) {
                    // no need to add the queue
                    // just increament the no of ways
                    ways[adjnode] += ways[node] % mod;
                }
            }
        }
        return ways[dest] % mod;
    }

    // gfg code
    static class Graph {
        class Node {
            private int vertex;
            private long cost;

            public Node(int v, long cost) {
                this.vertex = v;
                this.cost = cost;
            }
        }

        private int V;
        private List<ArrayList<Node>> adj;

        private int mod = (int) (1e9 + 7);

        public Graph(int v) {
            this.V = v;
            this.adj = new ArrayList<ArrayList<Node>>(this.V);
            for (int i = 0; i < this.V; i++) {
                this.adj.add(new ArrayList<Node>());
            }
        }

        public void addEdge(int u, int v, int weight) {
            this.adj.get(u).add(new Node(v, weight));
            this.adj.get(v).add(new Node(u, weight));
        }

        public int dijkstra(int src, int dst, int n) {
            PriorityQueue<Node> pq = new PriorityQueue<Node>((o1, o2) -> Long.compare(o1.cost, o2.cost));
            long[] distance = new long[n];
            int[] ways = new int[n];
            Arrays.fill(distance, Integer.MAX_VALUE);
            Arrays.fill(ways, 0);
            distance[0] = 0;
            ways[0] = 1;
            pq.add(new Node(src, 0));
            while (pq.size() != 0) {
                Node node = pq.poll();
                int u = node.vertex;
                long dis = node.cost;
                for (Node neighbour : adj.get(u)) {
                    int v = neighbour.vertex;
                    long edW = neighbour.cost;
                    if (dis + edW < distance[v]) {
                        distance[v] = dis + edW;
                        pq.add(new Node(v, dis + edW));
                        ways[v] = ways[u];
                    } else if (dis + edW == distance[v]) {
                        ways[v] = (ways[v] + ways[u]) % mod;
                    }
                }
            }
            System.out.println("the minimum cost will be=" + distance[n - 1]);
            return (int) (ways[n - 1] % mod);
        }
    }

    static int countPaths(int n, List<List<Integer>> roads) {
        Graph graph = new Graph(n);
        int m = roads.size();
        for (int i = 0; i < m; i++) {
            graph.addEdge(roads.get(i).get(0), roads.get(i).get(1), roads.get(i).get(2));
        }
        return graph.dijkstra(0, n - 1, n);
    }

    public static void main(String[] args) {
        System.out.println(countPaths(7, new int[][] { { 0, 6, 7 }, { 0, 1, 2 }, { 1, 2, 3 }, { 1, 3, 3 }, { 6, 3, 3 },
                { 3, 5, 1 }, { 6, 5, 1 }, { 2, 5, 1 }, { 0, 4, 5 }, { 4, 6, 2 } }));

        try (Scanner scanner = new Scanner(System.in)) {
            System.out.println("Enter the no of nodes:");
            int n = scanner.nextInt();
            System.out.println("Enter the edges of the graph:");
            int m = scanner.nextInt();
            List<List<Integer>> list = new ArrayList<>(m);
            for (int i = 0; i < m; i++) {
                List<Integer> l = new ArrayList<>();
                System.out.println("enter the value in one line teo separated :");
                for (int j = 0; j < 3; j++) {
                    int v = scanner.nextInt();
                    l.add(v);
                }
                list.add(l);
            }
            System.out.println("Reach to destination no ways are = " + countPaths(n, list));
        }

    }
}

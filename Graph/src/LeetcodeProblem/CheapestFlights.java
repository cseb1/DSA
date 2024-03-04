package LeetcodeProblem;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

// this question also given from GFG
//https://leetcode.com/problems/cheapest-flights-within-k-stops/description/
public class CheapestFlights {
    static class Pair {
        int first;
        int second;

        public Pair(int first, int second) {
            this.first = first;
            this.second = second;
        }
    }

    static class Tuple {
        int stops;
        int node;
        int dist;

        public Tuple(int stops, int node, int dist) {
            this.stops = stops;
            this.node = node;
            this.dist = dist;
        }
    }

    public static int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        // we can first convert the given array to graph
        ArrayList<ArrayList<Pair>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }
        for (int i = 0; i < flights.length; i++) {
            adj.get(flights[i][0]).add(new Pair(flights[i][1], flights[i][2]));
        }
        // we can take an dist array to store the minimum distance to all node from src
        // node
        int[] dist = new int[n];
        // initialized all the cell is infinite distance from src node
        Arrays.fill(dist, (int) 1e9);
        // we can take a queue to store a pair of{stops,node,dist}.
        dist[src] = 0;
        Queue<Tuple> q = new LinkedList<>();
        // add into queue with pair of{0,src,0}
        q.add(new Tuple(0, src, 0));
        while (!q.isEmpty()) {
            Tuple it = q.peek();
            q.remove();

            int stops = it.stops;
            int currNode = it.node;
            int currDist = it.dist;

            if (stops > k) {
                continue;
            }
            for (Pair itr : adj.get(currNode)) {
                int adjNode = itr.first;
                int adjDist = itr.second;

                if (currDist + adjDist < dist[adjNode] && stops <= k) {
                    // update the distance
                    dist[adjNode] = currDist + adjDist;
                    q.add(new Tuple(stops + 1, adjNode, currDist + adjDist));

                }
            }
        }

        if (dist[dst] == (int) 1e9) {
            return -1;
        } else
            return dist[dst];
    }

    public static void main(String[] args) {
        System.out.println(findCheapestPrice(4,
                new int[][] { { 0, 1, 100 }, { 1, 2, 100 }, { 1, 3, 600 }, { 2, 0, 100 }, { 2, 3, 200 } }, 0, 3, 1));
    }
}

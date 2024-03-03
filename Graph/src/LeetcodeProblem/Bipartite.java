package LeetcodeProblem;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Bipartite {
    public static boolean isBipartite(int V, ArrayList<ArrayList<Integer>> adj) {
        // Code here
        int color[] = new int[V];
        for (int i = 0; i < color.length; i++) { // initiall all cell of colored is not yet colored
            color[i] = -1;
        }
        for (int j = 0; j < V; j++) {
            if (color[j] == -1) {
                if (check(j, V, adj, color) == false) {
                    return false;
                }
            }
        }
        return true;
    }

    private static boolean check(int start, int v, ArrayList<ArrayList<Integer>> adj, int[] color) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(start);
        color[start] = 0; // we can use two colors 0/1;
        while (!queue.isEmpty()) {
            int node = queue.peek();
            queue.remove();
            for (Integer it : adj.get(node)) {
                if (color[it] == -1) { /// yet not color
                    color[it] = 1 - color[node]; // if color of node is 0 then color of next node is 1
                    queue.add(it);

                } else if (color[it] == color[node]) {
                    return false;
                }
            }

        }
        return true;
    }

    public static void main(String[] args) {
        int V = 4;
        ArrayList<ArrayList<Integer>> adj = new ArrayList<ArrayList<Integer>>();

        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<Integer>());
        }

        adj.get(0).add(1);
        adj.get(0).add(3);

        adj.get(1).add(0);
        adj.get(1).add(2);

        adj.get(2).add(1);
        adj.get(2).add(3);

        adj.get(3).add(0);
        adj.get(3).add(2);

        boolean ans = isBipartite(V, adj);
        if (ans == true) {
            System.out.println("Yes! It is Bipartite graph👌");
        } else {
            System.out.println("No! It is not a Bipartite graph😒😒");
        }
    }
}

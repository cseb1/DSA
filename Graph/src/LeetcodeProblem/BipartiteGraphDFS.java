package LeetcodeProblem;

import java.util.ArrayList;

public class BipartiteGraphDFS {
    public static boolean isBipartite(int V, ArrayList<ArrayList<Integer>> adj) {
        // Code here
        int color[] = new int[V];
        for (int i = 0; i < color.length; i++) {
            color[i] = -1;
        }
        for (int j = 0; j < V; j++) {
            if (color[j] == -1) {
                if (dfs(j, 0, adj, color) == false) {
                    return false;
                }
            }
        }
        return true;
    }

    private static boolean dfs(int start, int col, ArrayList<ArrayList<Integer>> adj, int[] color) {
        color[start] = col;
        for (Integer it : adj.get(start)) {
            if (color[it] == -1) {
                if (dfs(it, 1 - col, adj, color) == false)
                    return false;
            } else if (color[it] == col) {
                return false;
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

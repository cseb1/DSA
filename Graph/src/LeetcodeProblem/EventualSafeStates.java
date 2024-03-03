package LeetcodeProblem;

import java.util.ArrayList;
import java.util.List;

public class EventualSafeStates {
    static List<Integer> eventualSafeNodes(int V, List<List<Integer>> adj) {
        List<Integer> list = new ArrayList<>(V);
        int vis[] = new int[V];
        int[] pathvis = new int[V];
        int check[] = new int[V];
        for (int i = 0; i < V; i++) {
            if (vis[i] == 0) {
                dfsCheck(i, adj, vis, pathvis, check);
            }
        }

        for (int i = 0; i < V; i++) {
            if (check[i] == 1) {
                list.add(i);
            }
        }
        return list;
    }

    private static boolean dfsCheck(int node, List<List<Integer>> adj, int[] vis, int[] pathvis, int[] check) {
        vis[node] = 1;
        pathvis[node] = 1;
        check[node] = 0;

        // traverse for adjacent nodes
        for (int it : adj.get(node)) {
            // when the node is not vidited
            if (vis[it] == 0) {
                if (dfsCheck(it, adj, vis, pathvis, check) == true)
                    return true;
            }
            // if the node has been previously visited
            // but it has to be visited on the same path
            else if (pathvis[it] == 1) {
                return true;
            }

        }
        check[node] = 1;
        pathvis[node] = 0;
        return false;
    }

    public static void main(String[] args) {

    }
}

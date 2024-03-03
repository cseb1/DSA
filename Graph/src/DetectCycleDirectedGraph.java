import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
// detect a cycle in a directed graph using kahns algorithm very popular algorithm
//https://www.youtube.com/watch?v=iTBaI90lpDQ&list=PLgUwDviBIf0oE3gA41TKO2H5bHpPd7fzn&index=23
// for pactice gfg detect cycle in a directed graph

public class DetectCycleDirectedGraph {
    public static boolean isCyclic(int V, ArrayList<ArrayList<Integer>> adj) {
        int[] indegree = new int[V];
        for (int i = 0; i < V; i++) {
            for (Integer it : adj.get(i))
                indegree[it]++;
        }

        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < indegree.length; i++) {
            if (indegree[i] == 0) {
                queue.add(i);
            }
        }
        int cnt = 0;
        while (!queue.isEmpty()) {
            int node = queue.peek();
            cnt++;
            queue.remove();
            // now it is a part of the toposort
            // so it removes it from the indegree
            for (Integer it : adj.get(node)) {
                indegree[it]--;
                if (indegree[it] == 0) {
                    queue.add(it);
                }
            }
        }
        if (cnt == V) {
            return false;
        } else {
            return true;
        }
    }

    public static void main(String[] args) {

    }
}

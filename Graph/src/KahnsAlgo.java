import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

//https://www.youtube.com/watch?v=73sneFXuTEg&list=PLgUwDviBIf0oE3gA41TKO2H5bHpPd7fzn&index=22
// practice gfg / leetcode topological sorting problem
public class KahnsAlgo {
    static int[] topoSort(int V, ArrayList<ArrayList<Integer>> adj) {
        // add your code here
        int[] indegree = new int[V];
        int[] ans = new int[V];

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
        int i = 0;
        while (!queue.isEmpty()) {
            int node = queue.peek();
            ans[i++] = node;
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
        return ans;

    }

    public static void main(String[] args) {
        ArrayList<ArrayList<Integer>> list = new ArrayList<>();
        int V = 6;
        for (int i = 0; i < V; i++) {
            list.add(new ArrayList<>());
        }
        list.get(2).add(3);
        list.get(3).add(1);
        list.get(4).add(0);
        list.get(4).add(1);
        list.get(5).add(0);
        list.get(5).add(2);

        System.out.println(Arrays.toString(topoSort(6, list)));

    }
}

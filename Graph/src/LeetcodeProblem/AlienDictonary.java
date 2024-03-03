package LeetcodeProblem;

//https://www.geeksforgeeks.org/problems/alien-dictionary/1
//https://leetcode.com/discuss/interview-question/248131/Microsoft-Interview-(round-1)-Alien-Dictionary
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class AlienDictonary {
    public static String findOrder(String[] dict, int N, int K) // N is number of elements
    {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < K; i++) {
            adj.add(new ArrayList<>());
        }
        for (int i = 0; i < N - 1; i++) {
            String s1 = dict[i];
            String s2 = dict[i + 1];
            int len = Math.min(s1.length(), s2.length());
            for (int j = 0; j < len; j++) {
                if (s1.charAt(j) != s2.charAt(j)) {
                    adj.get(s1.charAt(j) - 'a').add(s2.charAt(j) - 'a');
                    break;
                }
            }
        }
        List<Integer> topo = toposort(K, adj);
        String ans = "";
        for (int it : topo) {
            ans += (char) (it + (int) 'a');
        }
        return ans;

    }

    private static List<Integer> toposort(int V, ArrayList<ArrayList<Integer>> adj) {
        int[] indegree = new int[V];
        List<Integer> find = new ArrayList<>();
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < V; i++) {
            for (Integer it : adj.get(i))
                indegree[it]++;
        }

        for (int i = 0; i < indegree.length; i++) {
            if (indegree[i] == 0) {
                queue.add(i);
            }
        }
        while (!queue.isEmpty()) {
            int node = queue.peek();
            find.add(node);
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
        return find;
    }

    public static void main(String[] args) {
        System.out.println(findOrder(new String[] { "baa", "abcd", "abca", "cab", "cad" }, 5, 4));

    }
}

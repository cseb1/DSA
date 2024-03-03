package LeetcodeProblem;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

//https://leetcode.com/problems/find-eventual-safe-states/description/
//https://www.youtube.com/watch?v=2gtg3VsDGyc&list=PLgUwDviBIf0oE3gA41TKO2H5bHpPd7fzn&index=25
public class SafeStates {
    public static List<Integer> eventualSafeNodes(int[][] graph) {
        int V = graph.length;
        int[] indegree = new int[V];
        List<Integer> find = new ArrayList<>();
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<>());
        }
        // convert array to list of the graph
        for (int i = 0; i < graph.length; i++) {
            for (Integer it : graph[i]) {
                adj.get(it).add(i);
                indegree[i]++;
            }
        }
        System.out.println(adj);
        Queue<Integer> queue = new LinkedList<>();
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
        Collections.sort(find);
        return find;
    }

    public static void main(String[] args) {
        System.out.println(eventualSafeNodes(new int[][] { { 1, 2 }, { 2, 3 }, { 5 }, { 0 }, { 5 }, {}, {} }));
    }
}

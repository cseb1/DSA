package LeetcodeProblem;
//https://www.geeksforgeeks.org/problems/prerequisite-tasks/1

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

// using kahn's algorithm we can solve the problem easily
// just store all the prerequisite into a list;

public class PrerequisiteTask {
    public static boolean isPossible(int V, int P, int[][] prerequisites) {
        // Your Code goes here
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<>());
        }
        // convert array to list of the graph
        for (int i = 0; i < prerequisites.length; i++) {
            adj.get(prerequisites[i][0]).add(prerequisites[i][1]);
        }
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
        if (cnt == V) { // no cycle present i.e all task are completed succesfully
            return true;
        } else {
            return false;
        }
    }

    public static void main(String[] args) {
        System.out.println(isPossible(4, 3, new int[][] { { 1, 0 }, { 2, 1 }, { 3, 2 } }));
        System.out.println(isPossible(2, 2, new int[][] { { 1, 0 }, { 0, 1 } }));
    }
}

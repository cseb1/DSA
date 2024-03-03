package LeetcodeProblem;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

// https://leetcode.com/problems/course-schedule-ii/
// https://www.geeksforgeeks.org/problems/course-schedule/1
public class CourseSchedule {
    public static int[] findOrder(int numCourses, int[][] prerequisites) {
        int V = numCourses;
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<>());
        }
        // convert array to list of the graph
        for (int i = 0; i < prerequisites.length; i++) {
            adj.get(prerequisites[i][1]).add(prerequisites[i][0]);
        }
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
        if (i == V) { // DAG
            return ans;
        } else {
            int[] arr = {};
            return arr;
        }

    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(findOrder(2, new int[][] { { 1, 0 } })));
        System.out.println(Arrays.toString(findOrder(4, new int[][] { { 1, 0 }, { 2, 1 }, { 3, 2 } })));
        System.out.println(Arrays.toString(findOrder(2, new int[][] { { 1, 0 }, { 0, 1 } })));
    }
}

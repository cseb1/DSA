package LeetcodeProblem;

import java.util.ArrayList;

//https://leetcode.com/problems/number-of-provinces/
public class NumberOfProvinces {
    public static int findCircleNum(int[][] isConnected) {
        ArrayList<ArrayList<Integer>> list = new ArrayList<>();
        int v = isConnected.length;// no of vertices

        // create new list for all indices
        for (int i = 0; i < v; i++) {
            list.add(new ArrayList<>());
        }

        // change matrix to arraylist

        for (int i = 0; i < v; i++) {
            for (int j = 0; j < v; j++) {
                if (isConnected[i][j] == 1 && i != j) {
                    list.get(i).add(j);
                    list.get(j).add(i);
                }
            }
        }

        // take an integer visted array
        int visited[] = new int[v];
        int count = 0;
        for (int i = 0; i < v; i++) {
            if (visited[i] == 0) {
                count++;
                dfs(i, list, visited);
            }
        }

        return count;
    }

    private static void dfs(int i, ArrayList<ArrayList<Integer>> list, int[] visited) {
        visited[i] = 1;
        for (Integer it : list.get(i)) {
            if (visited[it] == 0) {
                dfs(it, list, visited);
            }
        }
    }

    public static void main(String[] args) {
        System.out.println(findCircleNum(new int[][] { { 1, 1, 0 }, { 1, 1, 0 }, { 0, 0, 1 } }));
        System.out.println(findCircleNum(new int[][] { { 1, 0 }, { 0, 1 } }));
    }
}

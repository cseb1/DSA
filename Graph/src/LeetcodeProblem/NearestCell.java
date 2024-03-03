package LeetcodeProblem;

import java.util.LinkedList;
import java.util.Queue;

// geeksforgeek== https://www.geeksforgeeks.org/problems/distance-of-nearest-cell-having-1-1587115620/1
//Leetcode ==https://leetcode.com/problems/01-matrix/description/
public class NearestCell {
    static class Node {
        private int first;
        private int second;
        private int third;

        public Node(int first, int second, int third) {
            this.first = first;
            this.second = second;
            this.third = third;
        }
    }

    public static int[][] nearest(int[][] grid) {
        // Code here
        int n = grid.length;
        int m = grid[0].length;

        int[][] visited = new int[n][m];
        int dist[][] = new int[n][m];
        Queue<Node> queue = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 1) { // starting cell having 1's (In case of leetcode grid[i][j]==0)
                    queue.add(new Node(i, j, 0));
                    visited[i][j] = 1;
                } else {
                    visited[i][j] = 0;
                }
            }
        }

        while (!queue.isEmpty()) {
            int row = queue.peek().first;
            int col = queue.peek().second;
            int steps = queue.peek().third;
            queue.remove();
            dist[row][col] = steps;
            int delx[] = { 1, -1, 0, 0 };
            int dely[] = { 0, 0, 1, -1 };
            for (int i = 0; i < 4; i++) {
                int nrow = row + delx[i];
                int ncol = col + dely[i];
                if (nrow >= 0 && nrow < n && ncol >= 0 && ncol < m && visited[nrow][ncol] == 0) {
                    visited[nrow][ncol] = 1;
                    queue.add(new Node(nrow, ncol, steps + 1));
                }
            }

        }
        return dist;

    }

    public static void main(String[] args) {
        int grid[][] = { { 0, 0, 0 }, { 0, 1, 0 }, { 1, 0, 1 } };
        int ans[][] = new int[grid.length][grid.length];
        ans = nearest(grid);
        for (int[] i : ans) {
            for (int it : i) {
                System.out.print(it + " ");
            }
            System.out.println();
        }
    }
}

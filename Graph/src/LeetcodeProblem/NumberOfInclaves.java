package LeetcodeProblem;

import java.util.LinkedList;
import java.util.Queue;

//https://www.geeksforgeeks.org/problems/number-of-enclaves/1
//https://leetcode.com/problems/number-of-enclaves/description/

public class NumberOfInclaves {
    static class Pair {
        private int row;
        private int col;

        public Pair(int row, int col) {
            this.row = row;
            this.col = col;
        }
    }

    public static int numEnclaves(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;

        int[][] visited = new int[n][m];
        Queue<Pair> queue = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (i == 0 || j == 0 || i == n - 1 || j == m - 1) {
                    if (grid[i][j] == 1) {
                        visited[i][j] = 1;
                        queue.add(new Pair(i, j));
                    } else {
                        visited[i][j] = 0;
                    }
                }
            }
        }

        while (!queue.isEmpty()) {
            int row = queue.peek().row;
            int col = queue.peek().col;
            queue.remove();
            int[] ax = { 1, -1, 0, 0 };
            int[] ay = { 0, 0, 1, -1 };

            for (int k = 0; k < 4; k++) {
                int nrow = ax[k] + row;
                int ncol = ay[k] + col;

                if (nrow >= 0 && nrow < n && ncol >= 0 && ncol < m && grid[nrow][ncol] == 1
                        && visited[nrow][ncol] == 0) {
                    visited[nrow][ncol] = 1;
                    queue.add(new Pair(nrow, ncol));
                }
            }
        }
        int ans = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 1 && visited[i][j] == 0)
                    ans++;
            }
        }

        return ans;

    }

    public static void main(String[] args) {
        System.out.println(numEnclaves(new int[][] { { 0, 0, 0, 0 },
                { 1, 0, 1, 0 },
                { 0, 1, 1, 0 },
                { 0, 0, 0, 0 } }));

        System.out.println(numEnclaves(new int[][] { { 0, 0, 0, 1 },
                { 0, 1, 1, 0 },
                { 0, 1, 1, 0 },
                { 0, 0, 0, 1 },
                { 0, 1, 1, 0 } }));
    }
}

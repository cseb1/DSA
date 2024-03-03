package LeetcodeProblem;

//https://www.geeksforgeeks.org/problems/find-the-number-of-islands/1
import java.util.LinkedList;
import java.util.Queue;

public class NoOfIsland {
    static class Pair {
        private int first;
        private int second;

        public Pair(int first, int second) {
            this.first = first;
            this.second = second;
        }
    }

    public static int numIslands(char[][] grid) {
        // Code here
        int n = grid.length;
        int m = grid[0].length;
        int[][] visited = new int[n][m];
        int count = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (visited[i][j] == 0 && grid[i][j] == '1') {
                    count++;
                    bfs(i, j, visited, grid);
                }
            }
        }
        return count;
    }

    private static void bfs(int i, int j, int[][] visited, char[][] grid) {
        visited[i][j] = 1;
        Queue<Pair> queue = new LinkedList<>();
        queue.add(new Pair(i, j));
        int n = grid.length;
        int m = grid[0].length;
        while (!queue.isEmpty()) {
            int row = queue.peek().first;
            int col = queue.peek().second;
            queue.remove();

            for (int delrow = -1; delrow <= +1; delrow++) {
                for (int delcol = -1; delcol <= +1; delcol++) {
                    int nrow = row + delrow;
                    int ncol = col + delcol;

                    if (nrow >= 0 && nrow < n && ncol >= 0 && ncol < m && grid[nrow][ncol] == '1'
                            && visited[nrow][ncol] == 0) {
                        visited[nrow][ncol] = 1;
                        queue.add(new Pair(nrow, ncol));
                    }
                }
            }
        }
    }

    public static void main(String[] args) {
        System.out.println(numIslands(
                new char[][] { { '0', '1', '1', '1', '0', '0', '0' }, { '0', '0', '1', '1', '0', '1', '0' } }));
    }
}

// leetcode problem --number of island
// https://leetcode.com/problems/number-of-islands/description/

// class Pair {
// private int first;
// private int second;

// public Pair(int first, int second) {
// this.first = first;
// this.second = second;
// }

// }

// public int numIslands(char[][] grid) {
// // Code here
// int n = grid.length;
// int m = grid[0].length;
// int[][] visited = new int[n][m];
// int count = 0;
// for (int i = 0; i < n; i++) {
// for (int j = 0; j < m; j++) {
// if (visited[i][j] == 0 && grid[i][j] == '1') {
// count++;
// bfs(i, j, visited, grid);
// }
// }
// }
// return count;
// }

// private void bfs(int i, int j, int[][] visited, char[][] grid) {
// visited[i][j] = 1;
// Queue<Pair> queue = new LinkedList<>();
// queue.add(new Pair(i, j));
// int n = grid.length;
// int m = grid[0].length;
// while (!queue.isEmpty()) {
// int row = queue.peek().first;
// int col = queue.peek().second;
// queue.remove();
// int[] ax = { 1, -1, 0, 0 };
// int[] ay = { 0, 0, 1, -1 };

// for (int k = 0; k < ax.length; k++) {
// int nrow = ax[k] + row;
// int ncol = ay[k] + col;

// if (nrow >= 0 && nrow < n && ncol >= 0 && ncol < m && grid[nrow][ncol] == '1'
// && visited[nrow][ncol] == 0) {
// visited[nrow][ncol] = 1;
// queue.add(new Pair(nrow, ncol));

// }
// }
// }
// }
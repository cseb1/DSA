package LeetcodeProblem;

import java.util.LinkedList;
import java.util.Queue;

//https://leetcode.com/problems/rotting-oranges/description/
public class RotatingOranges {
    static class Pair {
        private int i;
        private int j;

        public Pair(int i, int j) {
            this.i = i;
            this.j = j;
        }

    }

    public static boolean isValid(int i, int j, int n, int m, int[][] grid) {
        if (i >= 0 && i < n && j >= 0 && j < m && grid[i][j] == 1) {
            return true;
        }
        return false;
    }

    public static int orangesRotting(int[][] grid) {
        Queue<Pair> queue = new LinkedList<>();
        int n = grid.length;
        int m = grid[0].length;
        int fresh = 0;
        int time = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 2) {
                    // push into queue
                    queue.add(new Pair(i, j));
                } else if (grid[i][j] == 1) {
                    fresh++;
                }
            }
        }
        if (fresh == 0) // no one fresh orange present
            return 0;

        // start bfs traversal

        while (!queue.isEmpty()) {
            int size = queue.size();
            int temp = 0;
            while (size != 0) {
                Pair p = queue.poll();
                int x1 = p.i;
                int y1 = p.j;

                int[] ax = { 1, -1, 0, 0 };
                int[] ay = { 0, 0, 1, -1 };

                for (int i = 0; i < ax.length; i++) {
                    int x = ax[i] + x1;
                    int y = ay[i] + y1;

                    if (isValid(x, y, n, m, grid)) {
                        temp++;
                        grid[x][y] = 2; // now this cell correspondin orange are rotten.
                        queue.add(new Pair(x, y)); // push all neighbour fresh oranges.
                    }
                }
                size--;
            }
            if (temp != 0) {
                time++;
            }
        }

        // case 2::
        // after bfs if any cell contain 1 i.e all orange are not rotten
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 1) {
                    time = 0;
                }
            }
        }

        return (time == 0) ? -1 : time;
    }

    public static void main(String[] args) {
        System.out.println(orangesRotting(new int[][] { { 2, 1, 1 }, { 1, 1, 0 }, { 0, 1, 1 } }));
        System.out.println(orangesRotting(new int[][] { { 2, 1, 1 }, { 0, 1, 1 }, { 1, 0, 1 } }));
        System.out.println(orangesRotting(new int[][] { { 0, 2 }, { 2, 0 } }));
    }
}

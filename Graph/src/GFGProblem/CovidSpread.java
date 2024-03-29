package GFGProblem;

import java.util.LinkedList;
import java.util.Queue;

public class CovidSpread {
    static class Pair { // contain two things {row,col};
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

    public static int helpSreya(int[][] hospital) {
        Queue<Pair> queue = new LinkedList<>();
        int n = hospital.length;
        int m = hospital[0].length;
        int uninfected = 0;
        int time = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (hospital[i][j] == 2) {
                    // push into queue
                    queue.add(new Pair(i, j));
                } else if (hospital[i][j] == 1) {
                    uninfected++;
                }
            }
        }
        if (uninfected == 0) // no one uninfected all are infected either empty bed
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

                    if (isValid(x, y, n, m, hospital)) {
                        temp++;
                        hospital[x][y] = 2; // now this cell corresponding uninfected patients are infected.
                        queue.add(new Pair(x, y)); // push all neighbour infected patients.
                    }
                }
                size--;
            }
            if (temp != 0) {
                time++;
            }
        }

        // case 2::
        // after bfs if any cell contain 1 i.e all patients are not infected
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (hospital[i][j] == 1) {
                    time = 0;
                }
            }
        }

        return (time == 0) ? -1 : time;
    }

    public static void main(String[] args) {
        System.out.println(helpSreya(new int[][] { { 2, 1, 0, 2, 1 }, { 1, 0, 1, 2, 1 }, { 1, 0, 0, 2, 1 } }));
    }
}

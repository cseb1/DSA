package GFGProblem;

//https://leetcode.com/problems/path-with-minimum-effort/description/
//https://www.geeksforgeeks.org/problems/path-with-minimum-effort/1
import java.util.PriorityQueue;
import java.util.Queue;

public class PathWithMinEffort {
    // create a pair class consists 3 attributes
    // 1. distance between two consicutive heights
    // 2. each cell row
    // 3. each cell column
    static class Pair {
        private int distance;
        private int row;
        private int col;

        // create a parameterized constructor
        public Pair(int distance, int row, int col) {
            this.distance = distance;
            this.row = row;
            this.col = col;
        }
    }
    // we can use just simply dijkstra algorithm to solve this probelm
    // we can use a minimum priority queue and 2D distance array

    public static int minimumEffortPath(int[][] heights) {
        int n = heights.length; // length of the row
        int m = heights[0].length; // length of the column

        // declaration of 2D array

        int[][] distance = new int[n][m];
        // fill all the cell into infinite
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                distance[i][j] = (int) 1e9;
            }
        }

        // we can go the 4 direction of any cell

        int delRow[] = { -1, 0, 1, 0 };
        int delCol[] = { 0, 1, 0, -1 };
        // declare a min priority queue with respect to their distance

        Queue<Pair> queue = new PriorityQueue<>((x, y) -> x.distance - y.distance);

        // insert the source cell and distance is 0

        queue.add(new Pair(0, 0, 0));
        while (!queue.isEmpty()) {
            // dequeue the pair
            Pair it = queue.peek();
            queue.remove();// remove the front element in our queue

            // find the curr distance , row , col

            int currDis = it.distance;
            int currRow = it.row;
            int currCol = it.col;

            // check if curr row and col is same of the destination row & col
            // we return the curr Distance . because it is min pQueue
            // upcoming all next path destination is high

            if (currRow == n - 1 && currCol == m - 1) {
                return currDis;
            }

            for (int i = 0; i < 4; i++) {
                int nRow = currRow + delRow[i];
                int nCol = currCol + delCol[i];
                if (nRow >= 0 && nRow < n && nCol >= 0 && nCol < m) {
                    // find the new effort
                    int neweffort = Math.max(Math.abs(heights[currRow][currCol] - heights[nRow][nCol]), currDis);

                    // update the distance array

                    if (neweffort < distance[nRow][nCol]) {
                        distance[nRow][nCol] = neweffort;

                        // add the neweffort , nRow, nCol into the pQueue

                        queue.add(new Pair(neweffort, nRow, nCol));
                    }
                }
            }
        }
        return 0;

    }

    public static void main(String[] args) {
        System.out.println(minimumEffortPath(new int[][] { { 1, 2, 2 }, { 3, 8, 2 }, { 5, 3, 5 } }));
    }
}

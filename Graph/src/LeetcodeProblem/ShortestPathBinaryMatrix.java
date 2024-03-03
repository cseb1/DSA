package LeetcodeProblem;

//https://leetcode.com/problems/shortest-path-in-binary-matrix/description/
import java.util.LinkedList;
import java.util.Queue;

public class ShortestPathBinaryMatrix {
    static class Pair {
        private int dist;
        private int currRow;
        private int currCol;

        public Pair(int dist, int currRow, int currCol) {
            this.dist = dist;
            this.currRow = currRow;
            this.currCol = currCol;
        }
    }

    public static int shortestPathBinaryMatrix(int[][] grid) {
        int n = grid.length;
        int[][] distance = new int[n][n];
        if (grid.length == 1 && grid[0][0] == 0) { // base case
            return 1;
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                distance[i][j] = (int) 1e9;
            }
        }
        // make this source indes destiation is 0.
        int sRow = 0;
        int sCol = 0;
        distance[sRow][sCol] = 0;
        // now take an queue
        Queue<Pair> queue = new LinkedList<>();
        // add the src into the queue
        if (grid[sRow][sCol] == 0) {
            queue.add(new Pair(1, sRow, sCol));
        }

        // iterate over while queue is not empty

        while (!queue.isEmpty()) {
            int currDist = queue.peek().dist;
            int currRow = queue.peek().currRow;
            int currCol = queue.peek().currCol;
            queue.remove();
            for (int delrow = -1; delrow <= +1; delrow++) {
                for (int delCol = -1; delCol <= +1; delCol++) {

                    int nRow = currRow + delrow;
                    int nCol = currCol + delCol;

                    if (nRow >= 0 && nRow < n && nCol >= 0 && nCol < n && grid[nRow][nCol] == 0
                            && currDist + 1 < distance[nRow][nCol]) {
                        distance[nRow][nCol] = currDist + 1;
                        if (nRow == grid.length - 1 && nCol == grid.length - 1) {
                            return currDist + 1;
                        }
                        queue.add(new Pair(1 + currDist, nRow, nCol));
                    }
                }
            }
        }
        return -1;

    }

    public static void main(String[] args) {
        System.out.println(shortestPathBinaryMatrix(new int[][] { { 0, 1 }, { 1, 0 } }));
        System.out.println(shortestPathBinaryMatrix(new int[][] { { 0, 0, 1 }, { 1, 1, 0 }, { 1, 1, 0 } }));
    }
}

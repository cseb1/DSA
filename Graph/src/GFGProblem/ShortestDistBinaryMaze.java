package GFGProblem;

//https://www.geeksforgeeks.org/problems/shortest-path-in-a-binary-maze-1655453161/1
import java.util.LinkedList;
import java.util.Queue;

public class ShortestDistBinaryMaze {
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

    public static int shortestPath(int[][] grid, int[] source, int[] destination) {
        // declaration of distance array it is two dimensional

        int n = grid.length;
        int m = grid[0].length;
        int[][] distance = new int[n][m];
        if (source[0] == destination[0] && source[1] == destination[1]) {
            return 0;
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                distance[i][j] = (int) 1e9;
            }
        }
        // make this source indes destiation is 0.
        int sRow = source[0];
        int sCol = source[1];
        distance[sRow][sCol] = 0;
        // now take an queue
        Queue<Pair> queue = new LinkedList<>();
        // add the src into the queue
        queue.add(new Pair(0, sRow, sCol));
        int delRow[] = { -1, 0, 1, 0 };
        int delCol[] = { 0, 1, 0, -1 };

        // iterate over while queue is not empty

        while (!queue.isEmpty()) {
            int currDist = queue.peek().dist;
            int currRow = queue.peek().currRow;
            int currCol = queue.peek().currCol;
            queue.remove();
            for (int i = 0; i < 4; i++) {
                int nRow = currRow + delRow[i];
                int nCol = currCol + delCol[i];

                if (nRow >= 0 && nRow < n && nCol >= 0 && nCol < m && grid[nRow][nCol] == 1
                        && currDist + 1 < distance[nRow][nCol]) {
                    distance[nRow][nCol] = currDist + 1;
                    if (nRow == destination[0] && nCol == destination[1]) {
                        return currDist + 1;
                    }
                    queue.add(new Pair(1 + currDist, nRow, nCol));
                }

            }
        }
        return -1;
    }

    public static void main(String[] args) {
        System.out.println(shortestPath(
                new int[][] { { 1, 1, 1, 1 }, { 1, 1, 0, 1 }, { 1, 1, 1, 1 },
                        { 1, 1, 0, 0 }, { 1, 0, 0, 0 } },
                new int[] { 0, 1 }, new int[] { 2, 2 }));
    }
}

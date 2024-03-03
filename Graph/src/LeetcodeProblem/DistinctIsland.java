package LeetcodeProblem;

import java.util.ArrayList;
import java.util.HashSet;

//https://www.geeksforgeeks.org/problems/number-of-distinct-islands/1
public class DistinctIsland {
    private static String toString(int row, int col) {
        return Integer.toString(row) + " " + Integer.toString(col);
    }

    static int countDistinctIslands(int[][] grid) {
        // Your Code here
        int n = grid.length;
        int m = grid[0].length;
        int visited[][] = new int[n][m];
        HashSet<ArrayList<String>> st = new HashSet<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (visited[i][j] == 0 && grid[i][j] == 1) {
                    ArrayList<String> list = new ArrayList<>();
                    dfs(i, j, visited, grid, list, i, j);
                    st.add(list);
                }
            }
        }

        return st.size();
    }

    // row --> newrow, col-->newcol
    private static void dfs(int row, int col, int[][] visited, int[][] grid, ArrayList<String> list, int row0,
            int col0) { // (row0,col0) is the base row col
        visited[row][col] = 1;
        list.add(toString(row - row0, col - col0));
        int n = grid.length;
        int m = grid[0].length;
        int delx[] = { 1, -1, 0, 0 };
        int dely[] = { 0, 0, 1, -1 };
        for (int k = 0; k < 4; k++) {
            int nrow = delx[k] + row;
            int ncol = dely[k] + col;

            if (nrow >= 0 && nrow < n && ncol >= 0 && ncol < m && visited[nrow][ncol] == 0 && grid[nrow][ncol] == 1) {
                dfs(nrow, ncol, visited, grid, list, row0, col0);
            }
        }
    }

    public static void main(String[] args) {
        System.out.println(countDistinctIslands(new int[][] { { 1, 1, 0, 0, 0 },
                { 1, 1, 0, 0, 0 },
                { 0, 0, 0, 1, 1 },
                { 0, 0, 0, 1, 1 } }));

        System.out.println(countDistinctIslands(new int[][] { { 1, 1, 0, 1, 1 },
                { 1, 0, 0, 0, 0 },
                { 0, 0, 0, 0, 1 },
                { 1, 1, 0, 1, 1 } }));
    }
}

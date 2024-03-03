package LeetcodeProblem;

//https://www.geeksforgeeks.org/problems/replace-os-with-xs0052/1
public class ReplaceOwithX {
    static char[][] fill(int n, int m, char a[][]) {
        // code here
        char[][] ans = new char[n][m];
        int[][] visited = new int[n][m];
        int[] ax = { 1, -1, 0, 0 };
        int[] ay = { 0, 0, 1, -1 };

        // // row
        // for (int j = 0; j < m; j++) {
        // if (a[0][j] == 'O' && visited[0][j] == 0) { // first row
        // bfs(0, j, visited, a, ax, ay);
        // }
        // // last row
        // if (a[n - 1][j] == 'O' && visited[n - 1][j] == 0) { // last row
        // bfs(n - 1, j, visited, a, ax, ay);
        // }
        // }

        // // col wise

        // for (int i = 0; i < n; i++) {
        // if (a[i][0] == 'O' && visited[i][0] == 0) { // first col
        // bfs(i, 0, visited, a, ax, ay);
        // }
        // if (a[i][m - 1] == 'O' && visited[i][m - 1] == 0) { // last col
        // bfs(i, m - 1, visited, a, ax, ay);
        // }
        // }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (i == 0 || j == 0 || i == n - 1 || j == m - 1) {
                    if (a[i][j] == 'O' && visited[i][j] == 0) {
                        bfs(i, j, visited, a, ax, ay);

                    } else {
                        visited[i][j] = 0;
                    }
                }
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (a[i][j] == 'O' && visited[i][j] == 0) {
                    ans[i][j] = 'X';
                } else {
                    ans[i][j] = a[i][j];
                }
            }
        }
        return ans;
    }

    private static void bfs(int i, int j, int[][] visited, char[][] a, int[] ax, int[] ay) {
        int n = visited.length;
        int m = visited[0].length;
        visited[i][j] = 1;
        for (int k = 0; k < ax.length; k++) {
            int nrow = ax[k] + i;
            int ncol = ay[k] + j;

            if (nrow >= 0 && nrow < n && ncol >= 0 && ncol < m && a[nrow][ncol] == 'O'
                    && visited[nrow][ncol] == 0) {
                bfs(nrow, ncol, visited, a, ax, ay);
            }
        }
    }

    public static void main(String[] args) {
        char ans[][] = fill(5, 4, new char[][] { { 'X', 'X', 'X', 'X' },
                { 'X', 'O', 'X', 'X' },
                { 'X', 'O', 'O', 'X' },
                { 'X', 'O', 'X', 'X' },
                { 'X', 'X', 'O', 'O' } });

        for (char[] i : ans) {
            for (char it : i) {
                System.out.print(it + " ");
            }
            System.out.println();
        }
    }
}

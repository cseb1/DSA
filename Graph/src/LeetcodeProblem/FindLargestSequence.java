package LeetcodeProblem;

//https://www.codingninjas.com/studio/problem-of-the-day?difficulty=MODERATE
public class FindLargestSequence {

    public static int findLongestOverAll(int[][] mat, int n) {
        // Write your code here.
        int memo[][] = new int[n][n];
        int maxpath = 0;
        int delx[] = { 1, -1, 0, 0 };
        int dely[] = { 0, 0, 1, -1 };
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                maxpath = Math.max(maxpath, dfs(i, j, memo, mat, delx, dely));
            }
        }

        return maxpath + 1;

    }

    private static int dfs(int i, int j, int[][] memo, int[][] mat, int[] delx, int[] dely) {
        int n = mat.length;
        if (memo[i][j] != 0) {
            return memo[i][j];
        }
        int sum = 0;
        for (int k = 0; k < 4; k++) {
            int nrow = i + delx[k];
            int ncol = j + dely[k];
            if (nrow >= 0 && nrow < n && ncol >= 0 && ncol < n && mat[nrow][ncol] - mat[i][j] == 1) {
                sum = Math.max(sum, 1 + dfs(nrow, ncol, memo, mat, delx, dely));
            }

        }
        memo[i][j] = sum;
        return sum;

    }

    public static void main(String[] args) {
        System.out.println(findLongestOverAll(new int[][] { { 9, 1, 3 }, { 7, 4, 2 }, { 6, 5, 8 } }, 3));
        System.out.println(findLongestOverAll(
                new int[][] { { 1, 15, 13, 14 }, { 2, 8, 9, 10 }, { 3, 11, 16, 12 }, { 4, 5,
                        6, 7 } },
                4));
        System.out.println(findLongestOverAll(new int[][] { { 1, 2 }, { 3, 4 } },
                2));
        System.out.println(findLongestOverAll(new int[][] { { 7, 9, 1 },
                { 6, 3, 5 }, { 4, 8, 2 } }, 3));
    }
}

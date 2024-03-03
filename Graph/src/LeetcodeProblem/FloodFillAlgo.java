package LeetcodeProblem;

public class FloodFillAlgo {
    public static int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int[][] ans = image;
        int initialColor = image[sr][sc];
        bfs(image, sr, sc, color, initialColor, ans);
        return ans;
    }

    private static void bfs(int[][] image, int sr, int sc, int color, int initialColor, int[][] ans) {
        int n = image.length;
        int m = image[0].length;
        ans[sr][sc] = color;
        int[] ax = { 1, -1, 0, 0 };
        int[] ay = { 0, 0, 1, -1 };

        for (int k = 0; k < ax.length; k++) {
            int nrow = ax[k] + sr;
            int ncol = ay[k] + sc;

            if (nrow >= 0 && nrow < n && ncol >= 0 && ncol < m && image[nrow][ncol] == initialColor
                    && ans[nrow][ncol] != color) {
                bfs(image, nrow, ncol, color, initialColor, ans);
            }
        }
    }

    public static void main(String[] args) {
        int[][] image = { { 1, 1, 1 }, { 1, 1, 0 }, { 1, 0, 1 } };
        int ans[][] = new int[image.length][image.length];
        ans = floodFill(image, 1, 1, 2);
        for (int i = 0; i < ans.length; i++) {
            for (int j = 0; j < ans[0].length; j++) {
                System.out.print(ans[i][j] + " ");
            }
            System.out.println();
        }
    }
}

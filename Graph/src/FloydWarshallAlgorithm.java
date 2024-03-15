
public class FloydWarshallAlgorithm {
    public static void shortest_distance(int[][] matrix) {
        // first we put the infinite of -1 contain cell
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix.length; j++) {
                if (matrix[i][j] == -1) {
                    matrix[i][j] = (int) (1e9);
                }
                if (i == j) {
                    matrix[i][j] = 0;
                }
            }
        }
        int n = matrix.length;

        for (int via = 0; via < n; via++) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    matrix[i][j] = Math.min(matrix[i][j], matrix[i][via] + matrix[via][j]);
                }
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == (int) (1e9)) {
                    matrix[i][j] = -1;
                }
            }
        }

    }

    public static void main(String[] args) {
        int matrix[][] = { { 0, 1, 43 }, { 1, 0, 6 }, { -1, -1, 0 } };
        shortest_distance(matrix);
        for (int[] itr : matrix) {
            for (int it : itr) {
                System.out.print(it + " ");
            }
            System.out.println();
        }
    }
}

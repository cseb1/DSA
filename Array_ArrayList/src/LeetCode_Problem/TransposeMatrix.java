package LeetCode_Problem;

import java.util.Arrays;

//import java.util.Arrays;

public class TransposeMatrix {
    public static int[][] transpose(int[][] matrix) {
        int[][] z = new int[matrix[0].length][matrix.length];
        for(int i=0; i<matrix[0].length; i++){
            for(int j=0; j<matrix.length; j++){
                z[i][j]=matrix[j][i];
            }
        }
        return z;
    }
    public static void main(String[] args) {
        int mat[][]={{2,4,-1},{-10,5,11},{18,-7,6}};
        int ans[][]=transpose(mat);
        for(int[]element:ans)
        {
            System.out.println(Arrays.toString(element));
        }
    }
}

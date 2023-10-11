package LeetCode_Problem.MediumTypeQuestion;
/*
 * Given a positive integer n, 
 generate an n x n matrix filled with elements from 1 to n2 in spiral order.

 

Example 1:


Input: n = 3
Output: [[1,2,3],[8,9,4],[7,6,5]]
Example 2:

Input: n = 1
Output: [[1]]
 

Constraints:

1 <= n <= 20
 */
import java.util.Arrays;

public class SpiralMatrixII {
    public static int[][] generateMatrix(int n) {
        int arr[][] = new int[n][n];

        int count = 1;
        int k = 0;
        int l = 0;
        int t = 0;
        for (int i = k; i < n; i++) {
            for(int j=l;j<n;j++){
                arr[t][j] = count++;
            }
            t++;
            for(int j=t;j<n;j++){
                arr[j][n-1] = count++;
            }
            t--;
            for(int j=n-2;j>=t;j--){
                arr[n-1][j] = count++;
            }
            t++;
            for(int j=n-2;j>=t;j--){
                arr[j][t-1] = count++;
            }
            n--;
            l++;
        }

        return arr;

    }
    public static void main(String[] args) {
        int result[][]=generateMatrix(5);
        for(int[] element:result)
        {
            System.out.println(Arrays.toString(element));
        }
    }
}

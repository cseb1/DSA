package BinarySearch;
/*Given a m x n matrix grid which is sorted in non-increasing order both row-wise and column-wise, return the number of negative numbers in grid.

 

Example 1:

Input: grid = [[4,3,2,-1],[3,2,1,-1],[1,1,-1,-2],[-1,-1,-2,-3]]
Output: 8
Explanation: There are 8 negatives number in the matrix.
Example 2:

Input: grid = [[3,2],[1,0]]
Output: 0
  */
public class Matrix_Search {
    public static int countNegatives(int[][] grid) {
       int ans=0; 
       int  m = grid.length;
       for(int i=0;i<m;i++)
       {
         int n = grid[i].length;
         for(int j=0;j<n;j++)
         {
            if(grid[i][j]<0)
                ans++;
         }
       }
       return ans;
    }
    public static void main(String[] args) {
        int grid[][]={{4,6,2,-1},{3,2,1,-1},{1,1,-1,-2},{-1,-1,-2,-3}};
        System.out.println(countNegatives(grid));
    }
}

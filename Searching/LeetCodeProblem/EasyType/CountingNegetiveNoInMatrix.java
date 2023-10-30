package Searching.LeetCodeProblem.EasyType;
//https://leetcode.com/problems/count-negative-numbers-in-a-sorted-matrix/nn


public class CountingNegetiveNoInMatrix {
    public static int countNegatives(int[][] grid) {
        int count=0;
        int r=0;
        int c=grid.length-1;
        while(r<grid.length && c>=0)
        {
            if(grid[r][c]<0)
            {
                count++;
                c--;
            }
            else
                {
                    r++;
                    c=grid.length-1;
                }
        }
        return count;
    }
    public static void main(String[] args) {
        int grid[][]={
            {4, 3, 2, -1},
            {3, 2, 1, -1},
            {1, 1, -1,-2},
            {-1,-1,-2,-3}
        };
        System.out.println(countNegatives(grid));
    }
}

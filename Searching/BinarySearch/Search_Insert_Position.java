package Searching.BinarySearch;
/*Given a sorted array of distinct integers and a target value, return the index if the target is found. If not, return the index where it would be if it were inserted in order.

You must write an algorithm with O(log n) runtime complexity.

 

Example 1:

Input: nums = [1,3,5,6], target = 5
Output: 2
Example 2:

Input: nums = [1,3,5,6], target = 2
Output: 1
Example 3:

Input: nums = [1,3,5,6], target = 7
Output: 4
 */

 class Solution1{
    public int searchInsert(int[] nums, int target) {
        int lb=0;
        int up=nums.length-1;
        while(lb<=up)
        {
            int mid=(lb+up)/2;

            if(nums[mid]==target)
            {
               return mid;
            }
            else if(nums[mid]>target)
            {
                up=mid-1;
            }
            else
            {
                lb=mid+1;
            } 
        }
         return lb;
    }
 }
public class Search_Insert_Position {
    
    public static void main(String[] args) {
        Solution1 s1=new Solution1();
        int nums[]={1,3,5,6};
        int target =7;
        System.out.println(s1.searchInsert(nums,target));
    }
}

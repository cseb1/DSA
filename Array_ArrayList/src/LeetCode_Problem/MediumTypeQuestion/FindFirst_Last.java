package LeetCode_Problem.MediumTypeQuestion;

import java.util.Arrays;

/*
 * Given an array of integers nums sorted in non-decreasing order,
 *  find the starting and ending position of a given target value.

If target is not found in the array, return [-1, -1].

You must write an algorithm with O(log n) runtime complexity.

 

Example 1:

Input: nums = [5,7,7,8,8,10], target = 8
Output: [3,4]


Example 2:

Input: nums = [5,7,7,8,8,10], target = 6
Output: [-1,-1]


Example 3:

Input: nums = [], target = 0
Output: [-1,-1]
 

Constraints:

0 <= nums.length <= 105
-109 <= nums[i] <= 109
nums is a non-decreasing array.
-109 <= target <= 109
 */
public class FindFirst_Last {
    public static int[] searchRange(int[] nums, int target) {
       int first=-1;
       int last=-1;
       for(int i=0;i<nums.length;i++)
       {
        if(nums[i]==target)
        {
            if(first==-1)
                first=i;
            else
                last=i;
        }
       }
       return new int[]{first,last};

    }
    public static void main(String[] args) {
        int nums[]={5,7,7,8,8,10};
        int target=8;
        System.out.println(Arrays.toString(searchRange(nums,target)));

        System.out.println(Arrays.toString(searchRange(nums,6)));
    }
}

package LeetCode_Problem.MediumTypeQuestion;
/*
 * You are a professional robber planning to rob houses along a street. Each house has a certain amount of money stashed, the only constraint stopping you from robbing each of them is that adjacent houses have security systems connected and it will automatically contact the police if two adjacent houses were broken into on the same night.

Given an integer array nums representing the amount of money of each house, return the maximum amount of money you can rob tonight without alerting the police.

 

Example 1:

Input: nums = [1,2,3,1]
Output: 4
Explanation: Rob house 1 (money = 1) and then rob house 3 (money = 3).
Total amount you can rob = 1 + 3 = 4.
Example 2:

Input: nums = [2,7,9,3,1]
Output: 12
Explanation: Rob house 1 (money = 2), rob house 3 (money = 9) and rob house 5 (money = 1).
Total amount you can rob = 2 + 9 + 1 = 12.
 

Constraints:

1 <= nums.length <= 100
0 <= nums[i] <= 400
 */
public class HouseRobbering {
    public static int rob(int[] nums) {
        
        int n=nums.length;
        int[] max_val=new int[n];

        max_val[0]=nums[0];
        max_val[1]=Math.max(nums[0],nums[1]);

        for(int i=2;i<n;i++)
        {
            max_val[i]=Math.max(max_val[i-1],max_val[i-2]+nums[i]);
        }
        return max_val[n-1];
     
       
    }
    public static void main(String[] args) {
        System.out.println(rob(new int[]{1,2,3,1}));
        System.out.println(rob(new int[]{2,7,9,3,1}));
    }
}

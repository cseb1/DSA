package LeetCode_Problem.MediumTypeQuestion;
/*
 * Given an integer array nums, return an array answer such that
 *  answer[i] is equal to the product of all the elements of nums 
 * except nums[i].

The product of any prefix or suffix of nums is guaranteed to fit in a 32-bit integer.

You must write an algorithm that runs in O(n) time and without using the division operation.

 

Example 1:

Input: nums = [1,2,3,4]
Output: [24,12,8,6]


Example 2:

Input: nums = [-1,1,0,-3,3]
Output: [0,0,9,0,0]
 

Constraints:

2 <= nums.length <= 105
-30 <= nums[i] <= 30
The product of any prefix or suffix of nums is guaranteed to fit in a 32-bit integer.
 
 */
import java.util.Arrays;

public class ProductOfArray {
    public static int[] productExceptSelf(int[] nums) {
        int[]answer=new int[nums.length];
        for(int i=0;i<nums.length;i++)
        {
            int sum=1;
            for(int j=0;j<nums.length;j++)
            {
                if(i!=j)
                {
                    sum=sum*nums[j];
                }
            }
            answer[i]=sum;
        }
        return answer;
    }
    public static void main(String[] args) {
        int nums[]={1,2,3,4};
        System.out.println(Arrays.toString(productExceptSelf(nums)));

        int num[]={-1,1,0,-3,3};
        System.out.println(Arrays.toString(productExceptSelf(num)));
    }
}

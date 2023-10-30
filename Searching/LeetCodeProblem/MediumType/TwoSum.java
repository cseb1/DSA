package Searching.LeetCodeProblem.MediumType;

import java.util.Arrays;

//https://leetcode.com/problems/two-sum-ii-input-array-is-sorted/
public class TwoSum {
    public static  int[] twoSum(int[] numbers, int target) {
        int left=0;
        int right=numbers.length-1;
        while(left<=right)
        {
            if(numbers[left]+numbers[right]==target)
            {
                return new int[]{left+1,right+1};
            }

             if(numbers[left]+numbers[right]>target)
                right--;

                else
                    left++;
        }
        return new int[]{left+1,right+1};

    }
    public static void main(String[] args) {
        int[]arr={2,7,11,15};
        System.out.println(Arrays.toString(twoSum(arr,9)));

        int arr1[]={-1,0};
        System.out.println(Arrays.toString(twoSum(arr1,-1)));

        int arr2[]={2,3,4};
        System.out.println(Arrays.toString(twoSum(arr2,6)));
    }
}

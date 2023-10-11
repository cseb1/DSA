package LeetCode_Problem;

import java.util.Arrays;

public class RunningSum {
    public static void main(String[] args) {
        int num[]={1,1,1,1,1,1};
        System.out.println(Arrays.toString(runningSum(num)));
    }
    static int[] runningSum(int[] nums) {
        
        for(int i=1;i<nums.length;i++)
        {
               
                nums[i]=nums[i-1]+nums[i];
            
        }
        return nums;
    }


}

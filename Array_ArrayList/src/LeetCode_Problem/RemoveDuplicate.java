package LeetCode_Problem;

//import java.util.Arrays;
import java.util.HashSet;

public class RemoveDuplicate {
    /*public static int[] removeDuplicate(int[]nums)
    {
        int j=1;
        for(int i=1;i<nums.length;i++)
        {
            if(nums[i]!=nums[i-1])
            {
                nums[j]=nums[i];
                j++;
            }
        }
        return j;
    }*/

    public static HashSet<Integer> removeDuplicate(int[] nums)
    {
        HashSet<Integer>set=new HashSet<>(nums.length);
        for(int i=0;i<nums.length;i++)
        {
            set.add(nums[i]);
        }
        return set;
    }
    public static void main(String[] args) {
        int nums[]={1,1,2};
       // System.out.println(removeDuplicate(nums));
       System.out.println(removeDuplicate(nums));
    }
}

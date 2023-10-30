package Searching.LeetCodeProblem.MediumType;

import java.util.Arrays;

//https://leetcode.com/problems/find-first-and-last-position-of-element-in-sorted-array/description/
public class FindPosition {
    public static int[] searchRange(int[] nums, int target) {
        int[]ans={-1,-1};
        ans[0]=first(nums,target);
        ans[1]=last(nums,target);
        return ans;

    }

    static int first(int[]arr,int target)
    {
        int lb=0;
        int up=arr.length;
        int ans=-1;
        while(lb<=up)
        {
            int mid=lb+(up-lb)/2;
            if(arr[mid]>=target) // target will be left side of the mid position
            {
                if(arr[mid]==target)
                    ans=mid;

                up=mid-1;
            }
            else
                lb=mid+1;
        }
        return ans;

    }

    static int last(int[]arr,int target)
    {
        int lb=0;
        int up=arr.length;
        int ans=-1;
        while(lb<=up)
        {
            int mid=lb+(up-lb)/2;
            if(arr[mid]<=target) // target will be right side of the mid position
            {
                if(arr[mid]==target)
                    ans=mid;

                lb=mid+1;
            }
            else
                up=mid-1;
        }
        return ans;
    }
    public static void main(String[] args) {
        int[]nums={5,7,7,8,8,10};
        System.out.println(Arrays.toString(searchRange(nums,8)));
    }
}

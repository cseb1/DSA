package Searching.BinarySearch;
class Solution{
     public  int search(int[] nums, int target) {
        int lb=0;
        int up=nums.length-1;
        while(lb<=up)
        {
            int mid=lb+(up-lb)/2;

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
         return -1;
      
        
    }
}
public class BinarySearch {
   
    public static void main(String[] args) {
        Solution s1=new Solution();
        int nums[]= {-1,0,3,5,9,12};
        int target=9;
        System.out.println(s1.search(nums,target));
    }
}

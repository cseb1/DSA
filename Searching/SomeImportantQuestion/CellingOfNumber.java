package Searching.SomeImportantQuestion;

public class CellingOfNumber {
     static  int cellingNumber(int[] nums, int target) {
        int lb=0;
        int up=nums.length-1;

        if(target>nums[nums.length-1]) // which are the gretest number of the array last number
        {
            return -1;
            
        }
        while(lb<=up)
        {
            int mid=lb+(up-lb)/2;

            if(nums[mid]==target)
            {
               return nums[mid];
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
         return nums[lb];
      
        
    }
    public static void main(String[] args) {
        int arr[]={2,3,5,9,14,16,18};
        int target=4;
        System.out.println(cellingNumber(arr,target));

        System.out.println(cellingNumber(arr,14));

        System.out.println(cellingNumber(arr,15));

        System.out.println(cellingNumber(arr,19));
    }
}

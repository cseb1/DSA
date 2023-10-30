package Searching.SomeImportantQuestion;

public class FloorNumber {
    static int floorName(int []nums,int target)
    {
        int lb=0;
        int up=nums.length-1;
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
         return nums[up];
      
    }
    public static void main(String[] args) {
        int arr[]={2,3,5,9,14,16,18};
        int target=4;
        System.out.println(floorName(arr,target));

        System.out.println(floorName(arr,7));

        System.out.println(floorName(arr,15));
    }
}

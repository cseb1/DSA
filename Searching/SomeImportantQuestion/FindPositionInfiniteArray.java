package Searching.SomeImportantQuestion;

public class FindPositionInfiniteArray {
        static int findRange(int arr[],int target)
        {
            int start=0;
            int end=1;

            while(target>arr[end])
            {
                int newStart=end+1;
                // formula previous end+sizeofthebox*2
                    // size of the box= previous end-start+1
                end=end+(end-start+1)*2;
                start=newStart;
            }
            return Binarysearch(arr,target,start,end);
        }

    static int Binarysearch(int[] nums, int target,int lb,int up) {
        
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
    public static void main(String[] args) {
        int[]arr={2,3,5,9,10,12,13,15,17,19,23,30,33,35};
        int target=15;
        System.out.println(findRange(arr,target));

        System.out.println(findRange(arr,987));
    }
}

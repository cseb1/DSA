package Searching.BinarySearch;

public class OrderOugmentedBinarySearch {
    public static void main(String[] args) {
        int[] arr={-1,-2,0,4,5,8,9,12,25,28,29,49};
        System.out.println(orderAugmentedBS(arr,4));

        int arr1[]={34,32,23,12,10,4,2,1,0,-1,-8,-10};
        System.out.println(orderAugmentedBS(arr1,-1));
    }
    static int orderAugmentedBS(int []arr,int target)
    {
        int start=0;
        int end=arr.length-1;


        if(arr.length==0)
        {
            return -1;
        }

        while(start<=end)
        {
            int mid=start+(end-start)/2;
            // best case
            if(arr[mid]==target)
            {
                return mid;
            }

            // check whether the given array are ascending or descending

            boolean isAsc=arr[start]<arr[end];

            if(isAsc)  // ascending Order
            {
                if(arr[mid]>target)
            {
                end=mid-1;
            }
            else
            {
                start=mid+1;
            } 
            }

            else // descending order solution
            {
                if(arr[mid]<target)
            {
                end=mid-1;
            }
            else
            {
                start=mid+1;
            } 
            }
        }
        return -1;
    }
}

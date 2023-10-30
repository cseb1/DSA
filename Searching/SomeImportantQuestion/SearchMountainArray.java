package Searching.SomeImportantQuestion;

public class SearchMountainArray {

    static int search(int[]arr,int target){
        int peek=peekElement(arr);
        int firstTry=orderAugmentedBS(arr,target,0,peek);
        if(firstTry!=-1)
        {
            return firstTry;
        }
        else
            return orderAugmentedBS(arr,target,peek+1,arr.length-1);
    }

    static int peekElement(int arr[])
    {
        int start=0;
        int end=arr.length-1;

        while(start<end)
        {
            int mid=start+(end-start)/2;

            if(arr[mid]>arr[mid+1])
            {
                // descending part
                end=mid;
            }
            else
                // ascending part
                start=mid+1;
        }
        return end;
    }

    static int orderAugmentedBS(int []arr,int target,int start,int end)
    {
        
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
    public static void main(String[] args) {
        int arr[]={1,2,3,5,6,4,3,2};
        int target=4;
        System.out.println(search(arr,target));
    }
}

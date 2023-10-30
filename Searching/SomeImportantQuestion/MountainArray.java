package Searching.SomeImportantQuestion;

public class MountainArray {

    // actually here we find the maximum element in the jumble order process
    // peek the top element in the mountain top
    static int peekElement(int arr[])
    {
        int start=0;
        int end=arr.length-1;

        while(start!=end)
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
        return arr[end];
    }
    public static void main(String[] args) {
        int[] arr={1,2,3,5,6,4,3,2};
        System.out.println(peekElement(arr));


        System.out.println(peekElement(new int[]{0,1,0}));

        System.out.println(peekElement(new int[]{0,2,1,0}));

    }
}

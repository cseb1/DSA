package Searching.LinearSearch;

public class SearchInRange {
    public static void main(String[] args) {
        int arr[]={1,23,21,45,34,43,67,54,20,97};
        int target=20;
        System.out.println(seachRange(arr,0,3,target));
    }

    static boolean seachRange(int arr[],int first,int last,int target)
    {
        if(arr.length==0)
        {
            return false;
        }


        if(first<last)
        {
            for(int i=first;i<=last;i++)
            {
                if(arr[i]==target)
                {
                    return true;
                }
            }
        }
        return false;
    }
}

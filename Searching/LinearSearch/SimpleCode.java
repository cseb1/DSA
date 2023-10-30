package Searching.LinearSearch;

public class SimpleCode
{   public static int search(int arr[],int k)
    {

        // edge cases

        if(arr.length==0)
        {
            return -1;
        }
        for(int i=0;i<arr.length;i++)
        {
            if(arr[i]==k)
                return i;
        }
        return -1;
    }
    public static void main(String[] args) {
        int [] arr={-12,1,9,76,-98,65};
        System.out.println(search(arr,65));
    }
}
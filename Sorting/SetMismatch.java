package Sorting;

import java.util.Arrays;

public class SetMismatch {
    public static void main(String[] args) {
        int[]arr={1,1};
        System.out.println(Arrays.toString(findErrorNumber(arr)));
    }
    static int[] findErrorNumber(int[] arr)
    {
        int i=0;
        while(i<arr.length){
            int current=arr[i]-1;
            if(arr[i]!=arr[current])
            {
                swap(arr,i,current);
            }
            else
                i++;
        }

       
        for(int j=0;j<arr.length;j++)
        {
            if(j!=arr[j]-1)
            {
                return new int[]{arr[j],j+1};
            }
        }
        return new int[]{-1,-1};
    }
    
    static void swap(int[] arr, int first, int second) {
        int temp = arr[first];
        arr[first] = arr[second];
        arr[second] = temp;
    }
    
}

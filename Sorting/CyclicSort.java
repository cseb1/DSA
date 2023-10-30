package Sorting;

import java.util.Arrays;

public class CyclicSort {
    public static void main(String[] args) 
    {
        int[] arr = {5, 3, 4, 1, 2};
        cyclic_Sort(arr);
        System.out.println(Arrays.toString(arr));
    }

    static void cyclic_Sort(int[] arr)
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
    }
    
    static void swap(int[] arr, int first, int second) {
        int temp = arr[first];
        arr[first] = arr[second];
        arr[second] = temp;
    }
}

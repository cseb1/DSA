package Sorting;

import java.util.ArrayList;
import java.util.List;

public class FindAllDuplicate {
    public static void main(String[] args) {
        int[]arr={1, 3, 2, 7, 8, 2, 3, 1};
        System.out.println(allDuplicate(arr));
    }
    static List<Integer> allDuplicate(int[] arr)
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
        List<Integer>ans=new ArrayList<>();
         for(int j=0;j<arr.length;j++)
         {
            if(j!=arr[j]-1)
                ans.add(arr[j]);

         }
         return ans;
    }
    
    static void swap(int[] arr, int first, int second) {
        int temp = arr[first];
        arr[first] = arr[second];
        arr[second] = temp;
    }
}

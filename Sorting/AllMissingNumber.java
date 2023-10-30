package Sorting;
// https://leetcode.com/problems/find-all-numbers-disappeared-in-an-array/
// Asked in Google
import java.util.ArrayList;
import java.util.List;

public class AllMissingNumber {
    public static void main(String[] args) {
        int[]arr={4, 3, 2, 7, 8, 2, 3, 1};
        System.out.println(allmissingNumber(arr));
    }
    static List<Integer> allmissingNumber(int[] arr)
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

        // single for loop to check the element-1=index 
        List<Integer>ans=new ArrayList<Integer>();
        for(int j=0;j<arr.length;j++)
        {
            if(j+1 !=arr[j])
                ans.add(j+1);
        }
        return ans;
    }
    
    static void swap(int[] arr, int first, int second) {
        int temp = arr[first];
        arr[first] = arr[second];
        arr[second] = temp;
    }
}

package Sorting;
// https://leetcode.com/problems/missing-number/
// Amazon Question
public class MissingNumber {
    public static void main(String[] args) {
        int[] arr={3,0,1};
        System.out.println(missingNumber(arr));

        int[]arr1={3,0,1,2}; // here, n=4 but the array will not contain 4,
        //that's why its return 4.

        System.out.println(missingNumber(arr1));
    }
    static int missingNumber(int[] arr)
    {
        int i=0;
        while(i<arr.length){
            int current=arr[i];
            if(arr[i] <arr.length && arr[i]!=arr[current])
            {
                swap(arr,i,current);
            }
            else
                i++;
        }

        // single for loop to check the element=index 

        for(int j=0;j<arr.length;j++)
        {
            if(j!=arr[j])
             return j;
        }
        return arr.length;
    }
    
    static void swap(int[] arr, int first, int second) {
        int temp = arr[first];
        arr[first] = arr[second];
        arr[second] = temp;
    }
}

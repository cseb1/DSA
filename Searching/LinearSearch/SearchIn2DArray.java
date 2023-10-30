package Searching.LinearSearch;

import java.util.ArrayList;
import java.util.List;

public class SearchIn2DArray {
    public static void main(String[] args) {
        int [][] arr={
            {24,12,10},
            {3,8,7,13},
            {25,36,56,45},
            {11,70}
        };
        int target=7;
        System.out.println(search(arr,target));
        System.out.println(search(new int[][]{},9));
    }

    static List<Integer> search(int arr[][],int target)
    {
        List<Integer>list=new ArrayList<Integer>();

        // edge case
        if(arr.length==0)
        {
            list.add(-1);
        }
        for(int i=0;i<arr.length;i++)
        {
            for(int j=0;j<arr[i].length;j++)
            {
                if(arr[i][j]==target)
                {
                    list.add(0,i);
                    list.add(1,j);
                }
            }
        }
        return list;
    }
}

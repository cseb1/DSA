package Searching.LeetCodeProblem.MediumType;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

//https://leetcode.com/problems/find-right-interval/description/
public class FindRightInterval {
    
    
    public static int[] bs(int[][] intervals,int k){
        int ans[]=null;
        int i=0,j=intervals.length-1;
        while(i<=j){
            
            int mid=(i+j)/2;
            if(intervals[mid][0]>=k){
                ans=intervals[mid];
                j=mid-1;
            }else 
                i=mid+1;
            
        }
        return ans;
        
    }   
    public static int[] findRightInterval(int[][] intervals) {
     if(intervals.length==1)
         return new int[]{-1};
        Map<Integer,Integer> map=new HashMap<>();
        int i=0;
        for(int[] a:intervals){
            map.put(a[0],i++);
        }
        
        Arrays.sort(intervals,Comparator.comparingInt(a->a[0]));
        
        int n=intervals.length;
        int ans[]=new int[n];
        
        for( i=0;i<n;i++){
            int i_index=map.get(intervals[i][0]);
            int req[]=bs(intervals,intervals[i][1]);
            if(req!=null){
             int index=map.get(req[0]);
            ans[i_index]=index;  
            }else
                ans[i_index]=-1;         
        }    
        return ans;
    }

    public static void main(String[] args) {
        int[][]arr={{1,2}};
        System.out.println(Arrays.toString(findRightInterval(arr)));
        

        System.out.println(Arrays.toString(findRightInterval(new int[][]{{3,4},{2,3},{1,2}})));
    }
}

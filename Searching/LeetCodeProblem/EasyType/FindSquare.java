package Searching.LeetCodeProblem.EasyType;
//https://leetcode.com/problems/sqrtx/description/
public class FindSquare {
    public static int mySqrt(int x) {
        int start=1;
        int end=x;
        int mid=-1;
        while(start<=end)
        {
            mid=start+(end-start)/2;
            if(mid*mid==x)
                return mid;

                if(mid*mid>x)
                {
                    end=mid-1;
                }
                else
                start=mid+1;
        }
        return round(end);
    }
    private static int round(int end) {
        return Math.round(end);
    }
    public static void main(String[] args) {
        System.out.println(mySqrt(4));
        System.out.println(mySqrt(8));
    }
}

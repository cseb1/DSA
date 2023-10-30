package Searching.LeetCodeProblem.EasyType;
//https://leetcode.com/problems/valid-perfect-square/
public class ValidPerfectSquare {
    public static boolean isPerfectSquare(int num) {
        double n=mySqrt(num);
        int x=(int)n;
        if(x*x==num)
        {
            return true;
        }
        else
        return false;
    }
    public static double mySqrt(int x) {
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
        return end;
    }
    
    public static void main(String[] args) {
        System.out.println(isPerfectSquare(4));
        System.out.println(isPerfectSquare(14));
    }
}

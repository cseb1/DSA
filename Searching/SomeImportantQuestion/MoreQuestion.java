package Searching.SomeImportantQuestion;
//https://leetcode.com/problems/maximum-value-at-a-given-index-in-a-bounded-array/description/


public class MoreQuestion {
    public static int maxValue(int n, int index, int maxSum) {
        int left = 0, right = maxSum - n;

        while (left < right) {
            int middle = (left + right + 1) / 2;
            if (isPossible(n, index, maxSum - n, middle))
                left = middle;
            else
                right = middle - 1;
        }
        return left + 1;
    }

    static boolean isPossible(int n, int index, int maxSum, int value) {
        int leftValue = Math.max(value - index, 0);
        int rightValue = Math.max(value - ((n - 1) - index), 0);

        long sumBefore = (long) (value + leftValue) * (value - leftValue + 1) / 2;
        long sumAfter = (long) (value + rightValue) * (value - rightValue + 1) / 2;

        return sumBefore + sumAfter - value <= maxSum;
    }
    public static void main(String[] args) {
        int n=4,index=2,maxSum=6;
        System.out.println(maxValue(n,index,maxSum));
    }
}

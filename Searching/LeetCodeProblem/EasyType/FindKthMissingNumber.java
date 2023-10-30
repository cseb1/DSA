package Searching.LeetCodeProblem.EasyType;
//https://leetcode.com/problems/kth-missing-positive-number/description/
public class FindKthMissingNumber {
    public static int findKthPositive(int[] arr, int k) {
        int left = 0, right = arr.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (arr[mid] - mid - 1 < k) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return left + k;
    }
    public static void main(String[] args) {
        System.out.println(findKthPositive(new int[]{2,3,4,7,11},5));
    }
}

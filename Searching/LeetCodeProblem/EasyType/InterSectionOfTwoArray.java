package Searching.LeetCodeProblem.EasyType;

import java.util.Arrays;

public class InterSectionOfTwoArray {
    public static int[] intersect(int[] nums1, int[] nums2) {
        int l1 = nums1.length;
        int l2 = nums2.length;
        int i = 0, j = 0, k = 0;
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        while( i < l1 && j < l2)
        {
            if(nums1[i] < nums2[j])
            {
                i++;
            }
            else if(nums1[i] > nums2[j])
            {
                j++;
            }
            else
            {
                nums1[k++] = nums1[i++];
                j++;
            }
        }
        return Arrays.copyOfRange(nums1,0,k);
    }
      
    public static void main(String[] args) {
        int nums1[]={1,2,2,1};
        int []nums2={2,2};
        System.out.println(Arrays.toString(intersect(nums1,nums2)));

        int arr1[]={4,9,5};
        int arr2[]={9,4,9,8,4};
        System.out.println(Arrays.toString(intersect(arr1,arr2)));
    }
}

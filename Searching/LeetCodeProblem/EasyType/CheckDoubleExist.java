package Searching.LeetCodeProblem.EasyType;
//https://leetcode.com/problems/check-if-n-and-its-double-exist/description/
public class CheckDoubleExist {
    public static boolean checkIfExist(int[] arr) {
        for(int i=0;i<arr.length;i++)
        {
            for(int j=0;j<arr.length;j++)
            {
                if(i!=j)
                {
                    if(arr[i]==2*arr[j])
                        return true;
                }
            }
        }
        return false;
    }
    public static void main(String[] args) {
        int []arr={10,2,3,5};
        System.out.println(checkIfExist(arr));
    }
}

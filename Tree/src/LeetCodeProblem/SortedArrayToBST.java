package LeetCodeProblem;

import AllTreeCode.BinarySearchTree;
//import AllTreeCode.BinarySearchTree.Node;

public class SortedArrayToBST extends BinarySearchTree {
    // Basically we create a Height balanced tree from Sorted Array
    // [Convert Sorted Array to Binary Search
    // Tree](https://leetcode.com/problems/convert-sorted-array-to-binary-search-tree/)
    // `leetcode`
    public Node sortedArrayToBST(int[] nums) {
        return helper(nums, 0, nums.length - 1);

    }

    private Node helper(int[] nums, int l, int r) {
        if (l > r) // Base condition
        {
            return null;
        }
        // find mid element
        int mid = l + (r - l) / 2;
        int middle = nums[mid];
        Node root = new Node(middle);
        // do recursion
        root.left = helper(nums, l, mid - 1);
        root.right = helper(nums, mid + 1, r);

        return root;
    }
}

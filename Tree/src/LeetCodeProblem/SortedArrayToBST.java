package LeetCodeProblem;

import java.util.ArrayList;
import java.util.List;

import AllTreeCode.BinarySearchTree;
//import AllTreeCode.BinarySearchTree.Node;

class SortedArrayToBST extends BinarySearchTree {
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

    public static void main(String[] args) {
        // Solution s1 = new Solution();
        ListNode l1 = new ListNode(-10);
        ListNode l2 = new ListNode(-3);
        ListNode l3 = new ListNode(0);
        ListNode l4 = new ListNode(5);
        ListNode l5 = new ListNode(9);
        l1.next = l2;
        l2.next = l3;
        l3.next = l4;
        l4.next = l5;
        // TreeNode r = s1.sortedListToBST(l1);

    }

}

class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }

}

// * Definition for a binary tree node.
class TreeNode {
    int val;

    public int getVal() {
        return this.val;
    }

    public void setVal(int val) {
        this.val = val;
    }

    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

class Solution {
    public TreeNode sortedListToBST(ListNode head) {
        List<Integer> list = new ArrayList<>();
        ListNode ptr = head;
        while (ptr != null) {
            list.add(ptr.val);
            ptr = ptr.next;
        }
        return helper(list);
    }

    private TreeNode helper(List<Integer> list) {
        return buildTree(list, 0, list.size() - 1);
    }

    private TreeNode buildTree(List<Integer> list, int i, int j) {
        if (i > j) {
            return null;
        }
        int mid = (i + j) / 2;
        System.out.println(mid);
        int middle = list.get(mid);
        TreeNode root = new TreeNode(middle);
        TreeNode leftSub = buildTree(list, 0, mid - 1);
        TreeNode rightSub = buildTree(list, mid + 1, j);
        root.left = leftSub;
        root.right = rightSub;
        return root;
    }
}

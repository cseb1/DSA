package LeetCodeProblem;

import AllTreeCode.BinarySearchTree;

public class MinDifferenceBwTwoNodes extends BinarySearchTree {

    private Integer prev;
    private int minDiff;

    public int getMinimumDifference(Node root) {
        minDiff = Integer.MAX_VALUE;
        prev = null;
        inorder(root);
        return minDiff;
    }

    private void inorder(Node node) {
        if (node == null) {
            return;
        }
        inorder(node.left);
        if (prev != null) {
            minDiff = Math.min(minDiff, node.val - prev);
        }
        prev = node.val;
        inorder(node.right);
    }
}

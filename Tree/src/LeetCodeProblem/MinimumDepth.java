package LeetCodeProblem;

import AllTreeCode.BinaryTree;

public class MinimumDepth extends BinaryTree {
    public int minDepth(Node root) {
        // Base condition
        if (root == null) {
            return 0;
        }

        int left = minDepth(root.left);
        int right = minDepth(root.right);
        if (root.left == null && root.right == null) // if both subtree are null
        {
            return 1;
        }

        if (root.left == null) // if left subtree are null
        {
            return 1 + right;
        }
        if (root.right == null) // If right subtree are null
        {
            return 1 + left;
        }

        return Math.min(left, right) + 1;

    }
}

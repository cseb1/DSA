package LeetCodeProblem;

import AllTreeCode.BinaryTree;

public class SumOfLeftLeaves extends BinaryTree {
    // https://leetcode.com/problems/sum-of-left-leaves/
    public int sumOfLeftLeaves(Node root) {

        int sum = 0;
        if (root == null)
            return 0;

        if (root.left != null &&
                root.left.left == null &&
                root.left.right == null)
            sum += root.left.value;

        sum += sumOfLeftLeaves(root.left);
        sum += sumOfLeftLeaves(root.right);
        return sum;
    }
}

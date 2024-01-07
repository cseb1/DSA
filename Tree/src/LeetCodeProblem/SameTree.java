package LeetCodeProblem;

import TreeQuestion.BinaryTree;

public class SameTree extends BinaryTree {
    // [Same Tree](https://leetcode.com/problems/same-tree/) `leetcode`
    public boolean isSameTree(Node p, Node q) {
        if (p == null && q == null) {
            return true;
        }
        if (p == null || q == null) {
            return false;
        }
        return p.value == q.value && isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }
}

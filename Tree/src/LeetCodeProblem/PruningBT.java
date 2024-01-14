package LeetCodeProblem;

// import java.util.*;
// import java.io.*;

//https://www.codingninjas.com/studio/problems/binary-tree-pruning_699987?topList=top-trees-interview-questions&problemListRedirection=true
class BinaryTreeNode<T extends Comparable<T>> {
    public T val;
    public BinaryTreeNode<T> left;
    public BinaryTreeNode<T> right;

    BinaryTreeNode(T val) {
        this.val = val;
        left = right = null;
    }

};

public class PruningBT {
    public static BinaryTreeNode<Integer> binaryTreePruning(BinaryTreeNode<Integer> root) {
        return hasOne(root) == true ? root : null;
    }

    private static boolean hasOne(BinaryTreeNode<Integer> root) {
        if (root == null) {
            return false;
        }
        boolean left = hasOne(root.left);
        boolean right = hasOne(root.right);

        if (left == false) {
            root.left = null;
        }
        if (right == false) {
            root.right = null;
        }

        if (root.val == 1 || left || right) {
            return true;
        }
        return false;
    }
}
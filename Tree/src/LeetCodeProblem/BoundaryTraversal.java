package LeetCodeProblem;

import java.util.ArrayList;
import java.util.List;

//https://www.codingninjas.com/studio/problems/boundary-traversal_790725?interviewProblemRedirection=true&leftPanelTabValue=PROBLEM
class TreeNode {
    int data;
    TreeNode left;
    TreeNode right;

    TreeNode(int data) {
        this.data = data;
        this.left = null;
        this.right = null;
    }
}

public class BoundaryTraversal {
    public static List<Integer> traverseBoundary(TreeNode root) {
        // Write your code here.
        ArrayList<Integer> list = new ArrayList<>();
        if (root == null) {
            return list;
        }

        list.add(root.data);

        printLeftBoundary(root.left, list);

        printLeaves(root.left, list);
        printLeaves(root.right, list);

        printRightBoundary(root.right, list);
        return list;

    }

    private static void printLeaves(TreeNode node, ArrayList<Integer> list) {
        if (node == null)
            return;

        printLeaves(node.left, list);
        // Print it if it is a leaf node
        if (node.left == null && node.right == null)
            list.add(node.data);
        printLeaves(node.right, list);
    }

    private static void printRightBoundary(TreeNode node, ArrayList<Integer> list) {
        if (node == null)
            return;

        if (node.right != null) {
            // to ensure bottom up order, first call for right
            // subtree, then print this node
            printRightBoundary(node.right, list);
            list.add(node.data);
        } else if (node.left != null) {
            printRightBoundary(node.left, list);
            list.add(node.data);
        }
        // do nothing if it is a leaf node, this way we avoid
        // duplicates in output
    }

    private static void printLeftBoundary(TreeNode node, ArrayList<Integer> list) {
        if (node == null)
            return;

        if (node.left != null) {
            // to ensure top down order, print the node
            // before calling itself for left subtree
            list.add(node.data);
            printLeftBoundary(node.left, list);
        } else if (node.right != null) {
            list.add(node.data);
            printLeftBoundary(node.right, list);
        }

        // do nothing if it is a leaf node, this way we avoid
        // duplicates in output
    }

    public static void main(String[] args) {
        TreeNode r10 = new TreeNode(10);
        TreeNode r5 = new TreeNode(5);
        TreeNode r20 = new TreeNode(20);
        TreeNode r3 = new TreeNode(3);
        TreeNode r8 = new TreeNode(8);
        TreeNode r18 = new TreeNode(18);
        TreeNode r25 = new TreeNode(25);
        TreeNode r7 = new TreeNode(7);

        r10.left = r5;
        r10.right = r20;
        r5.left = r3;
        r5.right = r8;
        r8.left = r7;
        r20.left = r18;
        r20.right = r25;

        System.out.println(traverseBoundary(r10));
    }
}

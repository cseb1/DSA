package LeetCodeProblem;
//https://leetcode.com/problems/recover-binary-search-tree/description/
import java.util.ArrayList;
import java.util.Collections;

class Node {

    public int val;
    public Node left;
    public Node right;

    public Node(int val) {
        this.val = val;
        this.left = null;
        this.right = null;
    }
}

public class recover {

    public static void storeInVector(Node root,
            ArrayList<Integer> vec) {
        if (root == null)
            return;
        storeInVector(root.left, vec);
        vec.add(root.val);
        storeInVector(root.right, vec);
    }

    public static void correctBSTUtil(Node root, ArrayList<Integer> vec,
            int[] index) {
        if (root == null)
            return;
        correctBSTUtil(root.left, vec, index);
        root.val = vec.get(index[0]);
        index[0]++;
        correctBSTUtil(root.right, vec, index);
    }

    public static void correctBST(Node root) {
        // ArrayList to store the inorder traversal of
        // given tree
        ArrayList<Integer> vec = new ArrayList<Integer>();
        storeInVector(root, vec);
        Collections.sort(vec);
        int[] index = { 0 };
        correctBSTUtil(root, vec, index);
    }

    public static void printInorder(Node root) {
        if (root == null)
            return;
        printInorder(root.left);
        System.out.print(root.val + " ");
        printInorder(root.right);
    }

    public static void main(String[] args) {

        Node root = new Node(6);
        root.left = new Node(10);
        root.right = new Node(2);
        root.left.left = new Node(1);
        root.left.right = new Node(3);
        root.right.right = new Node(12);
        root.right.left = new Node(7);

        // Inorder traversal of the Original Tree
        System.out.println(
                "Inorder Traversal of the original tree");
        printInorder(root);

        correctBST(root);

        // inorder traversal of the fixed tree
        System.out.println(
                "\nInorder Traversal of the fixed tree");
        printInorder(root);
    }
}

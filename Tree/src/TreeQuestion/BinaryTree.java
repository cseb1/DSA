package TreeQuestion;

import java.util.List;
import java.util.Scanner;

public class BinaryTree {
    public static class Node {
        Node left;
        Node right;
        int value;
        Node next;

        public Node(int value) {
            this.value = value;
        }
    }

    public Node root;

    public void populate(Scanner scanner) {
        System.out.println("Enter the root nodes");

        int value = scanner.nextInt();
        root = new Node(value);
        populate(scanner, root);
    }

    private void populate(Scanner scanner, Node node) {
        System.out.println("Do you want to add a left child to " + node.value + "?");
        boolean left = scanner.nextBoolean();
        if (left) {
            System.out.println("Enter the left child of " + node.value);
            int value = scanner.nextInt();
            node.left = new Node(value);
            populate(scanner, node.left);
        }
        System.out.println("Do you want to add a right child to " + node.value + "?");
        boolean right = scanner.nextBoolean();
        if (right) {
            System.out.println("Enter the right child of " + node.value);
            int value = scanner.nextInt();
            node.right = new Node(value);
            populate(scanner, node.right);
        }
    }

    public void display() {
        display(this.root, "");
    }

    private void display(Node node, String prefix) {
        if (node == null) {
            return;
        }
        System.out.println(prefix + node.value);
        display(node.left, prefix + "L");
        display(node.right, prefix + "R");
    }

    public void printdisplay() {
        printPretty(this.root, "", true);
    }

    private void printPretty(Node node, String prefix, boolean isTail) {
        if (node.right != null) {
            printPretty(node.right, prefix + (isTail ? "│   " : "    "), false);
        }
        System.out.println(prefix + (isTail ? "└── " : "┌── ") + node.value);
        if (node.left != null) {
            printPretty(node.left, prefix + (isTail ? "    " : "│   "), true);
        }
    }

    public void preOrder() {
        preOrder(root);
    }

    private void preOrder(Node node) {
        if (node == null) {
            return;
        }
        System.out.print("PreOrder Traversal->" + node.value + " ");
        preOrder(node.left);
        preOrder(node.right);
    }

    public void inOrder() {
        inOrder(root);
    }

    private void inOrder(Node node) {
        if (node == null) {
            return;
        }
        inOrder(node.left);
        System.out.print("InOrder Traversal->" + node.value + " ");
        inOrder(node.right);
    }

    public void postOrder() {
        postOrder(root);
    }

    private void postOrder(Node node) {

        if (node == null) {
            return;
        }
        postOrder(node.left);
        postOrder(node.right);
        System.out.print("PostOrder Traversal->" + node.value + " ");
    }

    public List<List<Integer>> levelWise() {
        return null;
    }

    public List<Double> LevelWiseAverage() {
        return null;
    }

    public Node levelOrderSuccessor(int key) {
        return null;
    }

    public List<List<Integer>> zigzag_Order() {
        return null;
    }
}

package AllTreeCode;

public class BinarySearchTree {
    public class Node {
        public int val;
        public Node left;
        public Node right;
        public int height;

        public Node(int val) {
            this.val = val;
        }

        // getter method
        public int getValue() {
            return val;
        }
    }

    public Node root;

    public BinarySearchTree() {

    }

    public int height() {
        return height(root);
    }

    private int height(Node node) { // calculate height of the tree

        if (node == null) {
            return -1;
        }

        return node.height;
    }

    public boolean isEmpty() {
        return root == null;
    }

    public void insert(int val) {
        root = insert(root, val);
    }

    private Node insert(Node node, int val) {
        if (node == null) {
            node = new Node(val);
            return node;
        }
        if (val < node.val) {
            node.left = insert(node.left, val);
        }
        if (val > node.val) {
            node.right = insert(node.right, val);
        }
        node.height = Math.max(height(node.left), height(node.right)) + 1;
        return node;
    }

    public void populate(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            this.insert(nums[i]);
        }
    }

    public void populatedSorted(int[] nums) {
        populatedSorted(nums, 0, nums.length);
    }

    private void populatedSorted(int[] nums, int start, int end) {
        if (start >= end) {
            return;
        }

        int mid = (start + end) / 2;
        this.insert(nums[mid]);
        populatedSorted(nums, start, mid);
        populatedSorted(nums, mid + 1, end);
    }

    public boolean balanced() {
        return balanced(root);
    }

    private boolean balanced(Node node) {
        if (node == null)
            return true;
        int diff = height(node.left) - height(node.right);
        if (Math.abs(diff) >= 1)
            return false;
        return balanced(node.left) && balanced(node.right);
    }

    public void printdisplay() {
        printPretty(this.root, "", true);
    }

    private void printPretty(Node node, String prefix, boolean isTail) {
        if (node.right != null) {
            printPretty(node.right, prefix + (isTail ? "│   " : "    "), false);
        }
        System.out.println(prefix + (isTail ? "└── " : "┌── ") + node.getValue());
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
        System.out.print(node.getValue() + " ");
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
        System.out.print(node.getValue() + " ");
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
        System.out.print(node.getValue() + " ");
    }

}
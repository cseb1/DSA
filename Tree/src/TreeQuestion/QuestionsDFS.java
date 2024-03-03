package TreeQuestion;

import java.util.Arrays;
import java.util.HashMap;

import AllTreeCode.BinarySearchTree;

public class QuestionsDFS extends BinarySearchTree {

    // https://leetcode.com/problems/diameter-of-binary-tree/description/
    int diameter = 0;

    // calculating the Binary Tree Diameter

    public int getDiameter() {
        return getDiameter(root);
    }

    private int getDiameter(Node root) {
        height(root);
        return diameter - 1;
    }

    private int height(Node root) {
        if (root == null) {
            return 0;
        }
        int leftHeight = height(root.left);
        int rightHeight = height(root.right);
        int dia = leftHeight + rightHeight + 1;
        diameter = Math.max(dia, diameter);

        return Math.max(leftHeight, rightHeight) + 1;
    }

    // https://leetcode.com/problems/invert-binary-tree/submissions/1139315096/
    public Node invert(Node root) {
        if (root == null) {
            return root;
        }

        Node leftinvert = invert(root.left);
        Node rightInvert = invert(root.right);
        root.left = rightInvert;
        root.right = leftinvert;
        return root;
    }

    public int maxDepth(Node root) {
        if (root == null) {
            return 0;
        }

        int left = maxDepth(root.left);
        int right = maxDepth(root.right);

        return Math.max(left, right) + 1;
    }

    int count = 0;

    public int kthSmallest(Node root, int key) {
        return helper(root, key).val;
    }

    private Node helper(Node root, int key) {
        if (root == null) {
            return null;
        }
        Node left = helper(root.left, key);
        if (left != null) {
            return left;
        }
        count++;
        if (count == key) {
            return root;
        }
        return helper(root.right, key);
    }
}

class DFS extends BinaryTree {
    // https://leetcode.com/problems/flatten-binary-tree-to-linked-list/
    public void flatten(Node root) {
        Node current = root;
        while (current != null) {
            if (current.left != null) {
                Node temp = current.left;
                while (temp.right != null) {
                    temp = temp.right;
                }
                temp.right = current.right;
                current.right = current.left;
                current.left = null;
            }

            current = current.right;
        }
    }

    // https://leetcode.com/problems/validate-binary-search-tree/submissions/1141372458/
    public boolean isValidBST(Node root) {
        return helper(root, null, null);
    }

    private boolean helper(Node root, Integer low, Integer high) {

        if (root == null) {
            return true;
        }
        if (low != null && low >= root.value) {
            return false;
        }
        if (high != null && high <= root.value) {
            return false;
        }
        boolean leftTree = helper(root.left, low, root.value);
        boolean rightTree = helper(root.right, root.value, high);
        return leftTree && rightTree;
    }

    public Node findAncestor(Node root, Node p, Node q) {

        if (root == null) {
            return null;
        }

        if (root == p || root == q) {
            return root;
        }

        Node left = findAncestor(root.left, p, q);
        Node right = findAncestor(root.right, p, q);

        if (left != null && right != null) {
            return root;
        }

        return (left == null) ? right : left;

    }

    public Node biuldTree(int[] preOrder, int[] inOrder) {
        if (preOrder.length == 0) {
            return null;
        }

        int r = preOrder[0];
        int index = 0;

        for (int i = 0; i < inOrder.length; i++) {
            if (r == inOrder[i]) {
                index = i;
            }
        }
        Node node = new Node(r);
        node.left = biuldTree(Arrays.copyOfRange(preOrder, 1, index + 1), Arrays.copyOfRange(inOrder, 0, index));
        node.right = biuldTree(Arrays.copyOfRange(preOrder, index + 1, preOrder.length),
                Arrays.copyOfRange(inOrder, index + 1, inOrder.length));
        return node;
    }

    public Node inPre(int[] preOrder, int[] inOrder) {
        HashMap<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < inOrder.length; i++) {
            map.put(inOrder[i], i);
        }

        int[] index = { 0 };

        return helper(preOrder, inOrder, 0, preOrder.length - 1, map, index);
    }

    public Node helper(int[] preOrder, int[] inOrder, int left, int right, HashMap<Integer, Integer> map, int[] index) {
        if (left > right) {
            return null;
        }

        int current = preOrder[index[0]];
        index[0]++;

        Node node = new Node(current);

        if (left == right) {
            return node;
        }
        int currentIndex = map.get(current);
        node.left = helper(preOrder, inOrder, left, currentIndex - 1, map, index);
        node.right = helper(preOrder, inOrder, currentIndex + 1, right, map, index);

        return node;
    }

    public Node inPost(int[] postorder, int[] inorder) {
        if (inorder == null || postorder == null || inorder.length != postorder.length)
            return null;
        HashMap<Integer, Integer> hm = new HashMap<Integer, Integer>();
        for (int i = 0; i < inorder.length; ++i)
            hm.put(inorder[i], i);
        return buildTreePostIn(inorder, 0, inorder.length - 1, postorder, 0,
                postorder.length - 1, hm);
    }

    private Node buildTreePostIn(int[] inorder, int is, int ie, int[] postorder,
            int ps, int pe, HashMap<Integer, Integer> hm) {
        if (ps > pe || is > ie)
            return null;
        Node root = new Node(postorder[pe]);
        int ri = hm.get(postorder[pe]);
        Node leftchild = buildTreePostIn(inorder, is, ri - 1, postorder, ps,
                ps + ri - is - 1, hm);
        Node rightchild = buildTreePostIn(inorder, ri + 1, ie, postorder,
                ps + ri - is, pe - 1, hm);
        root.left = leftchild;
        root.right = rightchild;
        return root;
    }
}

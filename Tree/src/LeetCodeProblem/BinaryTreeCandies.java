package LeetCodeProblem;

//https://www.geeksforgeeks.org/problems/distribute-candies-in-a-binary-tree/1
public class BinaryTreeCandies {
    static class Node {
        int data;
        Node left;
        Node right;

        public Node(int data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }

    static int ans = 0;

    public static int distributeCandy(Node root) {
        // code here
        helper(root);
        return ans;

    }

    private static int helper(Node root) {

        if (root == null) {
            return 0;
        }

        int l = helper(root.left);
        int r = helper(root.right);

        ans += Math.abs(l) + Math.abs(r);

        return root.data + l + r - 1;
    }

    public static void main(String[] args) {
        Node r1 = new Node(0);
        Node r2 = new Node(3);
        Node r3 = new Node(0);
        r1.left = r2;
        r1.right = r3;

        System.out.println(distributeCandy(r1));

    }
}

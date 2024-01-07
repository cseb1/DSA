package TreeQuestion;

public class PathSum extends BinaryTree {
    // [Path Sum](https://leetcode.com/problems/path-sum/) `leetcode`
    public boolean hasPathSum(Node root, int sum) {
        if (root == null) {
            return false;
        }
        if (root.left == null && root.right == null) {
            return sum == root.value;
        }
        return hasPathSum(root.left, sum - root.value) || hasPathSum(root.right, sum - root.value);
    }

    public int sumOfPath(Node root) {
        return helper(root, 0);
    }

    private int helper(Node root, int sum) {
        if (root == null) {
            return 0;
        }
        sum = sum * 10 + root.value;
        if (root.left == null && root.right == null) {
            return sum;
        }

        return helper(root.left, sum) + helper(root.right, sum);
    }

    int ans = Integer.MIN_VALUE;

    public int maxPathSum(Node root) {
        pathSum(root);
        return ans;
    }

    private int pathSum(Node root) {
        if (root == null) {
            return 0;
        }
        int left = pathSum(root.left);
        int right = pathSum(root.right);

        left = Math.max(0, left);
        right = Math.max(0, right);

        int temp = left + right + root.value;

        ans = Math.max(ans, temp);

        return Math.max(left, right) + root.value;
    }
}
package LeetCodeProblem;

import java.util.List;

import java.util.ArrayList;

public class TripletsInBT {

    static class TreeNode<T> {
        T data;
        TreeNode<T> left;
        TreeNode<T> right;

        public TreeNode(T data) {
            this.data = data;
        }
    }

    static int count = -1;

    public static List<List<Integer>> findTriplets(TreeNode<Integer> root, int x) {
        // Write your code here.
        List<List<Integer>> list = new ArrayList<>();
        find(null, null, root, x, list);
        return list;
    }

    private static void find(TreeNode<Integer> grandParent, TreeNode<Integer> parent,
            TreeNode<Integer> child, int sum, List<List<Integer>> list) {
        if (grandParent != null && parent != null && child != null
                && (grandParent.data + parent.data + child.data) > sum) {
            List<Integer> list1 = new ArrayList<>();
            list1.add(grandParent.data);
            list1.add(parent.data);
            list1.add(child.data);
            list.add(list1);
        }
        if (child == null)
            return;
        find(parent, child, child.left, sum, list);
        find(parent, child, child.right, sum, list);
    }

    public static void main(String[] args) {
        TreeNode<Integer> r10 = new TreeNode<>(10);
        TreeNode<Integer> r1 = new TreeNode<Integer>(1);
        TreeNode<Integer> r22 = new TreeNode<Integer>(22);
        TreeNode<Integer> r35 = new TreeNode<Integer>(35);
        TreeNode<Integer> r4 = new TreeNode<Integer>(4);
        TreeNode<Integer> r15 = new TreeNode<Integer>(15);
        TreeNode<Integer> r67 = new TreeNode<Integer>(67);
        TreeNode<Integer> r57 = new TreeNode<Integer>(57);
        TreeNode<Integer> r38 = new TreeNode<Integer>(38);
        TreeNode<Integer> r9 = new TreeNode<Integer>(9);
        TreeNode<Integer> r10_2 = new TreeNode<Integer>(10);
        TreeNode<Integer> r110 = new TreeNode<Integer>(110);
        TreeNode<Integer> r312 = new TreeNode<Integer>(312);
        TreeNode<Integer> r131 = new TreeNode<Integer>(131);
        TreeNode<Integer> r414 = new TreeNode<Integer>(414);
        TreeNode<Integer> r8 = new TreeNode<Integer>(8);
        TreeNode<Integer> r39 = new TreeNode<Integer>(39);

        r10.left = r1;
        r10.right = r22;
        r1.left = r35;
        r1.right = r4;
        r22.left = r15;
        r22.right = r67;
        r35.left = r57;
        r35.right = r38;
        r4.left = r9;
        r4.right = r10_2;
        r15.left = r110;
        r15.right = r312;
        r67.left = r131;
        r67.right = r414;
        r312.left = r8;
        r414.right = r39;

        System.out.println(findTriplets(r10, 100));
    }
}
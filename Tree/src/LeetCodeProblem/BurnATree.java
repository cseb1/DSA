package LeetCodeProblem;

import java.util.Queue;
import java.util.HashMap;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Stack;

//https://www.codingninjas.com/studio/problems/time-to-burn-tree_630563?interviewProblemRedirection=true&leftPanelTabValue=PROBLEM
class BinaryTreeNode<T> {
    T data;
    BinaryTreeNode<T> left;
    BinaryTreeNode<T> right;

    public BinaryTreeNode(T data) {
        this.data = data;
    }
}

public class BurnATree {
    public static void inorder(BinaryTreeNode<Integer> root, HashMap<Integer, ArrayList<Integer>> m) {
        if (root == null)
            return;

        Stack<BinaryTreeNode<Integer>> s = new Stack<BinaryTreeNode<Integer>>();
        BinaryTreeNode<Integer> curr = root;

        // Traverse the tree
        while (curr != null || s.size() > 0) {

            // Push all the nodes left to 'cur' in stack.
            while (curr != null) {
                s.push(curr);

                // Insert key if not present
                if (m.get(curr.data) == null) {
                    m.put(curr.data, new ArrayList<Integer>());
                }

                // If left child is present
                if (curr.left != null) {
                    // Add an edge
                    m.get(curr.data).add(curr.left.data);

                    // Insert key if not present.
                    if (m.get(curr.left.data) == null) {
                        m.put(curr.left.data, new ArrayList<Integer>());
                    }

                    m.get(curr.left.data).add(curr.data);
                }

                curr = curr.left;
            }

            // Pop the top node from stack.
            curr = s.pop();

            // If right child is present
            if (curr.right != null) {
                // Add an edge.
                m.get(curr.data).add(curr.right.data);

                if (m.get(curr.right.data) == null) {
                    m.put(curr.right.data, new ArrayList<Integer>());
                }

                m.get(curr.right.data).add(curr.data);
            }

            curr = curr.right;
        }
    }

    public static int timeToBurnTree(BinaryTreeNode<Integer> root, int start) {
        // Initialize map to store edges and vertices.
        HashMap<Integer, ArrayList<Integer>> m = new HashMap<>();

        // Store edges by doing inorder traversal.
        inorder(root, m);

        // Initialize queue for bfs traversal.
        Queue<Integer> q = new LinkedList<>();

        q.add(start);

        // Variable to keep count of number of levels from start node.
        int count = 0;
        HashMap<Integer, Boolean> visited = new HashMap<>();
        visited.put(start, true);

        // Iterate while queue is not empty.
        while (q.isEmpty() == false) {
            count++;
            int n = q.size();
            for (int i = 0; i < n; i++) {
                int node = q.peek();
                q.poll();

                for (int num : m.get(node)) {
                    if (visited.get(num) == null) {
                        q.add(num);
                        visited.put(num, true);
                    }
                }
            }
        }

        return count - 1;
    }

    public static void main(String[] args) {
        BinaryTreeNode<Integer> r1 = new BinaryTreeNode<Integer>(1);
        BinaryTreeNode<Integer> r2 = new BinaryTreeNode<Integer>(2);
        BinaryTreeNode<Integer> r3 = new BinaryTreeNode<Integer>(3);
        BinaryTreeNode<Integer> r4 = new BinaryTreeNode<Integer>(4);
        BinaryTreeNode<Integer> r5 = new BinaryTreeNode<Integer>(5);
        BinaryTreeNode<Integer> r6 = new BinaryTreeNode<Integer>(6);
        BinaryTreeNode<Integer> r7 = new BinaryTreeNode<Integer>(7);
        BinaryTreeNode<Integer> r8 = new BinaryTreeNode<Integer>(8);
        BinaryTreeNode<Integer> r9 = new BinaryTreeNode<Integer>(9);
        BinaryTreeNode<Integer> r10 = new BinaryTreeNode<Integer>(10);

        r1.left = r2;
        r1.right = r3;
        r2.left = r4;
        r2.right = r5;
        r5.left = r7;
        r5.right = r8;
        r3.right = r6;
        r6.right = r9;
        r9.right = r10;

        System.out.println("time required for burn the whole tree is " + timeToBurnTree(r1, 8) + " minutes.");
    }
}
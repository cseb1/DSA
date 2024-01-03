package TreeQuestion;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class ImportantQuestion extends BinaryTree {
    // Method override to BinaryTree class method
    // levelwise traversal or breadth first Search
    public List<List<Integer>> levelWise() {
        return bfs(root);
    }

    private List<List<Integer>> bfs(Node root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            int levelsize = queue.size();
            List<Integer> currentLevel = new ArrayList<Integer>(levelsize);
            for (int i = 0; i < levelsize; i++) {
                Node currentNode = queue.poll();
                currentLevel.add(currentNode.value);

                if (currentNode.left != null) {
                    queue.offer(currentNode.left);
                }

                if (currentNode.right != null) {
                    queue.offer(currentNode.right);
                }
            }
            result.add(currentLevel);
        }
        return result;
    }

    // Levelwise all node value average
    @Override
    public List<Double> LevelWiseAverage() {
        return average(root);
    }

    private List<Double> average(Node root) {
        List<Double> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            int levelsize = queue.size();
            Double average = 0.0;
            for (int i = 0; i < levelsize; i++) {
                Node currentNode = queue.poll();
                average += currentNode.value;

                if (currentNode.left != null) {
                    queue.offer(currentNode.left);
                }

                if (currentNode.right != null) {
                    queue.offer(currentNode.right);
                }
            }
            average = average / levelsize;
            result.add(average);
        }
        return result;
    }

    // find the next node of given node
    @Override
    public Node levelOrderSuccessor(int key) {

        return findSuccessor(root, key);
    }

    private Node findSuccessor(Node root, int key) {
        if (root == null) {
            return null;
        }
        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {

            Node currentNode = queue.poll();

            if (currentNode.left != null) {
                queue.offer(currentNode.left);
            }

            if (currentNode.right != null) {
                queue.offer(currentNode.right);
            }

            if (key == currentNode.value) {
                break;
            }
        }

        return queue.peek();
    }

    // Printing the tree in zig zag order
    @Override
    public List<List<Integer>> zigzag_Order() {
        return zigzag_Order(root);
    }

    private List<List<Integer>> zigzag_Order(Node root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        Deque<Node> queue = new LinkedList<>();
        queue.offer(root);
        boolean reverse = false;

        while (!queue.isEmpty()) {
            int levelsize = queue.size();
            List<Integer> currentLevel = new ArrayList<Integer>(levelsize);
            for (int i = 0; i < levelsize; i++) {
                if (!reverse) {
                    Node currentNode = queue.pollFirst();
                    currentLevel.add(currentNode.value);

                    if (currentNode.left != null) {
                        queue.addLast(currentNode.left);
                    }

                    if (currentNode.right != null) {
                        queue.addLast(currentNode.right);
                    }
                } else {
                    Node currentNode = queue.pollLast();
                    currentLevel.add(currentNode.value);
                    if (currentNode.right != null) {
                        queue.addFirst(currentNode.right);
                    }
                    if (currentNode.left != null) {
                        queue.addFirst(currentNode.left);
                    }
                }

            }
            reverse = !reverse;
            result.add(currentLevel);
        }
        return result;

    }

    // Connect the all node to her next node
    public Node connect() {
        return connect(root);
    }

    private Node connect(Node root) {
        if (root == null) {
            return null;
        }

        Node leftMost = root;

        while (leftMost.left != null) {
            Node current = leftMost;
            while (current != null) {
                current.left.next = current.right;
                if (current.next != null) {
                    current.right.next = current.next.left;
                }
                current = current.next;
            }
            leftMost = leftMost.left;
        }
        return root;
    }

    // Right-Side view
    public List<Integer> rightSideView() {
        return rightView(root);
    }

    private List<Integer> rightView(Node root) {

        List<Integer> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            int levelsize = queue.size();
            for (int i = 0; i < levelsize; i++) {
                Node currentNode = queue.poll();
                if (i == levelsize - 1) {
                    result.add(currentNode.value);
                }
                if (currentNode.left != null) {
                    queue.offer(currentNode.left);
                }

                if (currentNode.right != null) {
                    queue.offer(currentNode.right);
                }
            }
        }
        return result;
    }

    // Cousins in Binary Tree
    public boolean isCousins(int x, int y) {
        return isCousins(root, x, y);
    }

    private boolean isCousins(Node root, int x, int y) {

        Node xx = findNode(root, x);
        Node yy = findNode(root, y);

        return ((level(root, xx, 0) == level(root, yy, 0)) && (!isSibling(root, xx, yy)));
    }

    private Node findNode(Node root, int x) {
        if (root == null) {
            return null;
        }
        if (root.value == x) {
            return root;
        }

        Node n = findNode(root.left, x);
        if (n != null) {
            return n;
        }

        return findNode(root.right, x);
    }

    private boolean isSibling(Node root, Node xx, Node yy) {
        if (root == null) {
            return false;
        }
        return ((root.left == xx && root.right == yy) || (root.left == yy && root.right == xx)
                || isSibling(root.left, xx, yy) || isSibling(root.right, xx, yy));
    }

    private int level(Node root, Node xx, int i) {
        if (root == null) {
            return 0;
        }
        if (root == xx) {
            return i;
        }

        int l = level(root.left, xx, i + 1);
        if (l != 0) {
            return l;
        }

        return level(root.right, xx, i + 1);
    }

    // check if the tree is symmatric or not
    public boolean isSymetric() {
        return isSymetric(root);
    }

    private boolean isSymetric(Node root) {
        Queue<Node> queue = new LinkedList<>();

        queue.add(root.left);
        queue.add(root.right);

        while (!queue.isEmpty()) {
            Node left = queue.poll();
            Node right = queue.poll();

            if (left == null && right == null) {
                continue;
            }

            if (left == null || right == null) {
                return false;
            }

            if (left.value != right.value) {
                return false;
            }

            queue.add(left.left);
            queue.add(right.right);
            queue.add(left.right);
            queue.add(right.left);
        }
        return true;
    }

}

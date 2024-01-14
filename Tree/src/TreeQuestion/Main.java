package TreeQuestion;

//import java.util.Arrays;
//import java.util.Scanner;

import TreeQuestion.BinaryTree.Node;
//import AllTreeCode.BinarySearchTree;

public class Main {
    public static void main(String[] args) {

        // Scanner scanner = new Scanner(System.in);
        /*
         * ImportantQuestion tree = new ImportantQuestion();
         * tree.populate(scanner);
         * System.out.println("Level_Wise traversal/ BFS ==>  " + tree.levelWise());
         * System.out.println("Level wise node value Average==> " +
         * tree.LevelWiseAverage());
         * // System.out.println("Enter the key value:");
         * /*
         * int key = scanner.nextInt();
         * Node val = tree.levelOrderSuccessor(key);
         * System.out.println(val.value);
         */
        /*
         * System.out.println("Zig-Zag order==>   " + tree.zigzag_Order());
         * 
         * // tree.connect();
         * 
         * System.out.println("Right side view===>>  " + tree.rightSideView());
         * 
         * System.out.println(tree.isCousins(4, 5));
         * System.out.println(tree.isSymetric());
         */

        /*
         * QuestionsDFS tree = new QuestionsDFS();
         * tree.populate(new int[] { 4, 2, 1, 5, 3 });
         * tree.printdisplay();
         * System.out.println("Diameter of the Tree is " + tree.getDiameter());
         */

        /*
         * QuestionsDFS tree = new QuestionsDFS();
         * tree.populate(new int[] { 4, 2, 7, 1, 3, 6, 9 });
         * 
         * System.out.println("Root of the tree is " + tree.root.val);
         * System.out.println("Actual tree is ==> ");
         * tree.printdisplay();
         * 
         * tree.invert(tree.root);
         * System.out.println("Inverted Tree is===>");
         * tree.printdisplay();
         * 
         * System.out.println("maximum depth is ==" + tree.maxDepth(tree.root));
         */
        /*
         * DFS t = new DFS();
         * t.populate(scanner);
         * t.printdisplay();
         * 
         * t.flatten(t.root);
         * t.printdisplay();
         */

        /*
         * DFS t = new DFS();
         * t.populate(scanner);
         * t.printdisplay();
         * 
         * System.out.println("Is Valid BST?=>  " + t.isValidBST(t.root));
         */

        // QuestionsDFS t = new QuestionsDFS();

        // t.populate(new int[] { 5, 3, 6, 2, 4, 1 });
        // t.printdisplay();
        // System.out.println(t.kthSmallest(t.root, 6));

        // DFS tree = new DFS();

        // Node t = tree.biuldTree(new int[] { 3, 9, 20, 15, 7 }, new int[] { 9, 3, 15,
        // 20, 7 });

        DFS tree = new DFS();
        Node t = tree.inPost(new int[] { 8, 9, 4, 5, 2, 6, 7, 3, 1 }, new int[] { 8, 4, 9, 2, 5, 1, 6, 3, 7 });
        System.out.println("Tree root element is" + t.value);
        System.out.println(t.left.right.value);

    }
}

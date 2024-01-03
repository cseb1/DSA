package AllTreeCode;
//import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception {
        // Scanner scanner = new Scanner(System.in);
        /*
         * BinaryTree tree = new BinaryTree();
         * tree.populate(scanner);
         * tree.printdisplay();
         * tree.preOrder();
         * tree.inOrder();
         * tree.postOrder();
         */

        BinarySearchTree tree = new BinarySearchTree();
        /*
         * tree.populate(new int[] { 15, 10, 12, 5, 20 });
         * tree.printdisplay();
         * System.out.println("======Inorder Traversal is====");
         * tree.inOrder();
         * System.out.println("\n======Preorder Traversal is====");
         * tree.preOrder();
         * System.out.println("\n======Postorder Traversal is====");
         * tree.postOrder();
         * 
         * System.out.println();
         * System.out.println(tree.balanced());
         */

        for (int i = 0; i <= 10; i++) { // right Skewed Tree
            tree.insert(i);
        }

        // print the binary search tree height value

        System.out.println("Binary Search Tree Height of 1000 nodes Ascending order:: " + tree.height());

        // check it is balanced or not

        System.out.println("Is It balanced ? =>" + tree.balanced());

        tree.printdisplay();

    }
}

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
        tree.populate(new int[] { 15, 10, 12, 5, 20 });
        tree.printdisplay();
        System.out.println("======Inorder Traversal is====");
        tree.inOrder();
        System.out.println("\n======Preorder Traversal is====");
        tree.preOrder();
        System.out.println("\n======Postorder Traversal is====");
        tree.postOrder();

        System.out.println();
        System.out.println(tree.balanced());

    }
}

package AllTreeCode;

public class AVLMain {
    public static void main(String[] args) {
        AVLTree tree = new AVLTree();
        // insert 1000 nodes in ascending order

        for (int i = 0; i < 10; i++) { // In BST it is right skewed Tree
            tree.insert(i);
        }

        // print the height of AVL tree

        System.out.println(tree.height());

        // check it is balanced or not

        System.out.println("Is It Balanced?=> " + tree.balanced());

        tree.printdisplay();
    }
}

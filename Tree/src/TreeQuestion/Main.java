package TreeQuestion;

//import java.util.Arrays;
import java.util.Scanner;

//import TreeQuestion.BinaryTree.Node;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        ImportantQuestion tree = new ImportantQuestion();
        tree.populate(scanner);
        System.out.println("Level_Wise traversal/ BFS ==>  " + tree.levelWise());
        System.out.println("Level wise node value Average==> " + tree.LevelWiseAverage());
        // System.out.println("Enter the key value:");
        /*
         * int key = scanner.nextInt();
         * Node val = tree.levelOrderSuccessor(key);
         * System.out.println(val.value);
         */

        System.out.println("Zig-Zag order==>   " + tree.zigzag_Order());

        // tree.connect();

        System.out.println("Right side view===>>  " + tree.rightSideView());

        System.out.println(tree.isCousins(4, 5));
        System.out.println(tree.isSymetric());
    }
}

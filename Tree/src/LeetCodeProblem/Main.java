package LeetCodeProblem;

//import java.util.*;

public class Main {
    public static void main(String[] args) {
        // SameTree t1 = new SameTree();
        // SameTree t2 = new SameTree();
        // Scanner scanner = new Scanner(System.in);

        // t1.populate(scanner);
        // t2.populate(scanner);

        // System.out.println(t1.isSameTree(t1.root, t2.root));
        MinDifferenceBwTwoNodes t = new MinDifferenceBwTwoNodes();

        t.populate(new int[] { 4, 2, 6, 1, 3 });
        System.out.println(t.getMinimumDifference(t.root));
    }
}

package AllTreeCode;

public class SegmentTreeMain {
    public static void main(String[] args) {
        SegmentTree tree = new SegmentTree(new int[] { 3, 8, 7, 6, -2, -8, 4, 9 });
        tree.display();

        System.out.println(tree.quary(2, 6));

    }
}

package LeetcodeProblem.EasyType;

public class Tester {
    public static void main(String[] args) {
        BinaryToDecimal b1=new BinaryToDecimal();
        b1.addFirst(1);
        b1.addFirst(0);
        b1.addFirst(1);
        b1.showList();
        System.out.println(b1.getSize());

        System.out.println(b1.getDecimal(b1));
    }
}

package abstractDemo;

public class Son extends Parent {

    public Son(int age) {
        super(age);
    }

    @Override
    public void career() {

        System.out.println("I am going to be a coder");
    }

    @Override
    public void partner() {

        System.out.println("I love Sreya");
    }

    @Override
    public void normal() {
        super.normal();
    }
}

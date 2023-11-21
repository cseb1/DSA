package abstractDemo;

public class Daughter extends Parent {

    public Daughter(int age) {
        super(age);
    }

    @Override
    public void career() {

        System.out.println("I am going to be a Developer");
    }

    @Override
    public void partner() {

        System.out.println("I love Susanta");
    }
}

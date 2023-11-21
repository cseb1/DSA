package abstractDemo;

public abstract class Parent {

    int age;

    final int value;

    // create a constructor of abstract type ? we can't do this
    Parent(int age) {
        this.age = age;
        this.value = 7687;
    }

    public abstract void career();

    public abstract void partner();

    static void hellow() {
        System.out.println("Hey I am static method");
    }

    public void normal() {
        System.out.println("Hey I am a normal method");
    }
}

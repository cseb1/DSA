package abstractDemo;

public class Main {
    public static void main(String[] args) {
        // Parent mom=new Parent(); -> we cannot create any object of abstrat class

        // create a child classes->

        Son son = new Son(30);
        son.career();
        son.partner();
        son.normal();

        Daughter daughter = new Daughter(25);
        daughter.career();
        daughter.partner();

        Parent.hellow();

    }
}

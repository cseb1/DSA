package staticExample;

public class StaticBlock {

    static int a=4;
    static int b;  // declare a static member.
    // to initialize a static member we can use one block i.e. static block
    // will only run once, when the first obj is create i.e. 
    //when the class is loaded for the first time
    static{
        System.out.println("I am an static block");
        b=a*5;
    }

    public static void main(String[] args) {
       // StaticBlock obj1 = new StaticBlock();
        System.out.println(StaticBlock.a + " " + StaticBlock.b);

        StaticBlock.b += 3;

        System.out.println(StaticBlock.a + " " + StaticBlock.b);

        //StaticBlock obj2 = new StaticBlock();
        System.out.println(StaticBlock.a + " " + StaticBlock.b);
    }
}

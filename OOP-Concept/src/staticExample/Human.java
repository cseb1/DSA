package staticExample;

public class Human {
    int age;
    String name;
    int salary;
    boolean married;
    static long population; // static mamber does not depends upon the object
    // those are common things in all objects that entity are declaring static
    // It depends on class 

    public Human(int age,String name, int salary,boolean married)
    {
        this.age=age;
        this.name=name;
        this.salary=salary;
        this.married=married;
        Human.population+=1;

    }

    // static method example

    static void message()
    {
        System.out.println("It is a static method!");
        //System.out.println(this.age);
        //non static member cannot access by static method
    }

    @Override
    public String toString()
    {
        return "Name:"+ name+", age:"+age+",Salary:"+salary+",Married:"+married;
        
    }
}

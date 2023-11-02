package access;

public class Subclass extends A {
    public Subclass(int num,String name)
    {
        super(num,name);
    }
    public static void main(String[] args) {
        Subclass obj=new Subclass(21,"Sayan Maity");
        int n=obj.num;
        // num variable of A class is protected .Hence, we easily access in subclass 
        System.out.println(n);
    }
}

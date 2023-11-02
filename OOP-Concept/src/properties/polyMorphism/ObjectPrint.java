package properties.polyMorphism;

public class ObjectPrint extends Object {
    int num;
    public ObjectPrint(int n)
    {
        this.num=n;
    }

    @Override
    public String toString() // toString method also override in Object class
    {
        return "ObjectPrinting "+num;
    }

    public static void main(String[] args) {
        ObjectPrint obj=new ObjectPrint(32);
       System.out.println(obj.toString());
    }
}

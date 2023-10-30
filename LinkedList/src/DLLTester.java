public class DLLTester {
    public static void main(String[] args) {
        Doubly_Linked_List list=new Doubly_Linked_List();
        list.addFirst(2);
        list.addFirst(5);
        list.addFirst(4);
        list.addFirst(3);
        System.out.println("List traversal Forward:");
        list.displayForward();
        System.out.println("List tarversal Backward:");
        list.displayBackward();
        System.out.println("Size of the list is= "+list.getSize()  );
        System.out.println("\n\n\n");

        list.addLast(13);
        list.addLast(14);
        System.out.println("List traversal Forward:");
        list.displayForward();
        System.out.println("List tarversal Backward:");
        list.displayBackward();
        System.out.println("Size of the list is= "+list.getSize()  );
        System.out.println("\n\n\n");

        list.insert(30,3);
        list.insert(87,5);
        System.out.println("List traversal Forward:");
        list.displayForward();
        System.out.println("List tarversal Backward:");
        list.displayBackward();
        System.out.println("Size of the list is= "+list.getSize()  );
        System.out.println("\n\n\n");

        System.out.println("removed element is="+list.removeFirst());
        list.displayForward();
        System.out.println("Size of the list is= "+list.getSize()  );

        System.out.println("removed element is="+list.removeLast());
        list.displayForward();
        System.out.println("Size of the list is= "+list.getSize()  );


        System.out.println("removed element is="+list.remove(3));
        list.displayForward();
        System.out.println("Size of the list is= "+list.getSize()  );







    }
}

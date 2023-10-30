public class SLLTester {
    public static void main(String[] args) {
        Singly_Linked_List list=new Singly_Linked_List();
        /*list.addFirst(2);
        list.addFirst(1);
        list.addFirst(5);
        list.addFirst(4);
        list.addFirst(3);
        list.addFirst(6);
        list.addFirst(7);
        list.showList();

        
        list.addLast(15);
        list.addLast(14);
        list.addLast(23);
        list.showList();


        list.insert(13,3);
        list.showList();
        System.out.println("list size is= "+list.getSize());


        System.out.println("removed element is= "+list.removeFirst());
        list.showList();
        System.out.println("list size is= "+list.getSize());

        System.out.println("removed element is= "+list.removeLast());
        list.showList();
        System.out.println("list size is= "+list.getSize());



        System.out.println("removed element is= "+list.remove(2));
        list.showList();
        System.out.println("list size is= "+list.getSize());
        */

        /*list.addLast(1);
        list.addLast(1);
        list.addLast(1);
        list.addLast(2);
        list.addLast(4);
        list.addLast(4);
        list.showList();
        System.out.println("Size of the list is="+list.getSize());



        list.removeDuplicates();
        list.showList();
        System.out.println("Size of the list is="+list.getSize());*/


/* 
        Singly_Linked_List first=new Singly_Linked_List();
        Singly_Linked_List second=new Singly_Linked_List();



        first.addLast(1);
        first.addLast(2);
        first.addLast(4);
        first.showList();


        second.addLast(1);
        second.addLast(3);
        second.addLast(4);
        second.addLast(14);
        second.addLast(23);
        second.showList();



        Singly_Linked_List mergelist;

        mergelist=Singly_Linked_List.merge(first,second);
        mergelist.showList();
        */

       /* list.addFirst(2);
        list.addFirst(1);
        list.addFirst(5);
        list.addFirst(4);
        list.addFirst(3);
        list.addFirst(6);
        list.addFirst(7);
        list.showList();*/

        //System.out.println(list.hasCycle(list));

    /*   Singly_Linked_List.Node middle = list.fidMiddle(list);
         System.out.println(middle.val);*/
        list.addLast(1);
        list.addLast(2);
        list.addLast(3);
        list.addLast(4);
        list.addLast(5);
       
        list.showList();

        list.rotate(2);
        list.showList();



    }
}

package LeetcodeProblem.MediumType;

class MyLinkedList{
    private Node head;
    private Node tail;
     public MyLinkedList() {
        
    }
    
    public int get(int index) {
        if(index==0)
        {
            return head.val;
        }

        Node temp=head;
        for (int i = 0; i < index; i++) {
            temp=temp.next;
        }
        return temp.val;
    }
    public void addHead(int val)
    {
        Node newNode=new Node(val);
        if(head==null)
        {
            head=newNode;
            tail=newNode;
        }
        else
        {
            newNode.next=head;
            head=newNode;
        }
    }

    public void addTail(int val)
    {
         Node newNode = new Node(val);
        // check list is empty?
        if (head == null) {
           addHead(val);
        } else {
            tail.next = newNode;
            tail=newNode;
        }
    }

     public void addAtIndex(int index, int val) {

        int size=0;
        Node node=head;
        while(node!=null)
        {
            size++;
            node=node.next;
        }
        if(index>size)
        {
            return;
        }
          if(index==0)
        {
            addHead(val);
            return;
        }
        
        if(index==size)
        {
            addTail(val);
            return;
        }
        Node temp=head;

        for(int i=1;i<index;i++)
        {
            temp=temp.next;
        }
        Node newNode=new Node(val,temp.next);
        temp.next=newNode;
    }
    
    public void deleteAtIndex(int index) {
        int size=0;
        Node node=head;
        while(node!=null)
        {
            size++;
            node=node.next;
        }

        if(index>size)
            return;
        if(head==null)
            return;

            Node temp=head;
            Node prev=null;
        for(int i=0;i<index;i++)
        {   prev=temp;
            temp=temp.next;
        }
        prev.next=temp.next;
    }

   
    public void showList() {
        Node ptr = head;
        while (ptr != null) {
            System.out.print(ptr.val + "->");
            ptr = ptr.next;
        }
        System.out.println("END");
    }

    private class Node {
        private int val;
        private Node next;

        public Node(int val)
        {
            this.val=val;
        }

        public Node (int val,Node next)
        {
            this.val=val;
            this.next=next;
        }
    }
}

public class DesignLinkedList {

    public static void main(String[] args) {
        MyLinkedList obj=new MyLinkedList();
       /*  obj.addHead(1);
        obj.addTail(3);
        obj.addAtIndex(1,2);
        obj.showList();

        System.out.println(obj.get(1));
        obj.deleteAtIndex(1);
        obj.showList();

        System.out.println(obj.get(1));
        */

        obj.addHead(7);
        obj.addHead(2); 
        obj.addHead(1);
        obj.addAtIndex(2,0);
        obj.deleteAtIndex(2);
        obj.addHead(6);
        obj.addTail(4);
        System.out.println(obj.get(4));
        obj.showList();



    }
}

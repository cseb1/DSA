public class Doubly_Linked_List {
    private Node head;
    private int size;

    public Doubly_Linked_List()
    {
        this.size=0;
    }

    // insert at first position of the list

    public void addFirst(int val)
    {
        Node node=new Node(val);
        node.next=head;
        node.prev=null;
        if(head!=null)
        {
            head.prev=node;
        }
        head=node;
        size++;
        
    }

    public void addLast(int val)
    {
        Node node=new Node(val);
        if(head==null) // list is empty or not?
        {
            addFirst(val);
            return;
        }
        else{
            Node ptr=head;
            while(ptr.next!=null)
                {
                    ptr=ptr.next; // traverse the list until the last element not coming
                }
            node.prev=ptr;
            ptr.next=node;
            node.next=null;    
            size++;
        }
    }

    public void insert(int val, int index)
    {
        if(index==0)
        {
            addFirst(val);
            return ;
        }
        if(index==size)
        {
            addFirst(val);
            return;
        }

        Node temp=head;

        for(int i=1;i<index;i++)
        {
            temp=temp.next;
        }

        Node node=new Node(val,temp.next,temp);
        temp.next.prev=node;
        temp.next=node;
        size++;
    }

    public int removeFirst()
    {   
        int val=head.val;
        head.next.prev=null;
        head=head.next;
        size--;
        return val;
       
    }

    public int removeLast()
    {
        if(size<=1)
        {
            removeFirst();
        }

       
            Node ptr=head;
            Node secondLast=null;
            while(ptr.next!=null)
            {   
                secondLast=ptr;
                ptr=ptr.next;
            }
            int val=ptr.val;
            secondLast.next=null;
            size--;
            return val;
        
    }
    public int remove(int index)
    {
        if(index==0)
        {
            removeFirst();
        }
        if(index==size-1)
        {
            removeLast();
        }
        Node ptr=head;
        Node secondLast=null;
            for(int i=0;i<index;i++)
            {   
                secondLast=ptr;
                ptr=ptr.next;
            }

            secondLast.next=ptr.next;
            int val=ptr.val;
            ptr.next.prev=secondLast;
            size--;
            return val;
        
    }

    // print the list

    public void displayForward()
    {
        Node ptr=head;
        while(ptr!=null)
        {
            System.out.print(ptr.val+"-->");
            ptr=ptr.next;
        }
        System.out.println("END");
    }


    public void displayBackward()
    {
        // find the last node
        Node last=head;
        while(last.next!=null)
        {
            last=last.next;
        }
        while(last!=null)
        {
            System.out.print(last.val+"-->");
            last=last.prev;
        }
        System.out.println("START");
    }


    private class Node{
        private int val;
        private Node next;
        private Node prev;

        public Node(int val)
        {
            this.val=val;
        }

        public Node(int val,Node next,Node prev)
        {
            this.val=val;
            this.next=next;
            this.prev=prev;
        }
    }

    public int getSize()
    {
        return size;
    }
}

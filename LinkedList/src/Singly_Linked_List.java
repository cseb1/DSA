public class Singly_Linked_List {
    private Node head;
    private Node tail;
    private int size;

    public Singly_Linked_List() {
        this.size = 0;
    }

    public void addFirst(int val) {
        // create a new Node
        Node newNode = new Node(val);
        // check list is empty?
        if (head == null) {
            head = newNode;
            tail = newNode;
            size++;
        } else {
            newNode.next = head;
            head = newNode;
            size++;
        }
    }

    public void addLast(int val) {
        Node newNode = new Node(val);
        // check list is empty?
        if (head == null) {
           addFirst(val);
        } else {
            tail.next = newNode;
            tail=newNode;
            size++;
        }
    }


    //insert at any position of the list
    public void insert(int val,int index)
    {
        if(index==0)
        {
            addFirst(val);
            return;
        }
        if(index==size)
        {
            addLast(val);
            return;
        }

        Node temp=head;

        for(int i=1;i<index;i++)
        {
            temp=temp.next;
        }
        Node newNode=new Node(val,temp.next);
        temp.next=newNode;
        size++;
    }
    // remove first element in the list
    public int removeFirst()
    {
        int val=head.val;
        head=head.next;
        if(head==null)
        {
            tail=null;
        }
        size--;
        return val;
    }

    // remove last element in the list
    public int removeLast()
    {
        if(size<=1)
        {
            removeFirst();
        }

        Node secondLast=get(size-2);
        int val=tail.val;
        tail=secondLast;
        tail.next=null;
        size--;
        return val;

    }
    // remove at the index of linkedlist
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

        Node prev=get(index-1);
        int element=prev.next.val;
        prev.next=prev.next.next;
        size--;
        return element;
    }

    public Node get(int index)
    {
        Node temp=head;
        for(int i=0;i<index;i++)
        {
            temp=temp.next;
        }
        return temp;
    }
    // print the list

    public void showList() {
        Node ptr = head;
        while (ptr != null) {
            System.out.print(ptr.val + "->");
            ptr = ptr.next;
        }
        System.out.println("END");
    }

    class Node {
        private int val;
        private Node next;

        public Node(int val) {
            this.val = val;
        }

         public Node(int val, Node next) {
            this.val = val;
            this.next = next;
        }
    }

    public int getSize() {
        return size;
    }


    // remove duplicates in the list

    public void removeDuplicates()
    {
        Node node=head;
        while(node.next!=null)
        {
            if(node.val==node.next.val)
            {
                node.next=node.next.next;
                size--;
            }
            else
                {
                    node=node.next;
                }
        }
        tail=node;
        tail.next=null;
    }


    // merge two sorted list

    public static  Singly_Linked_List merge(Singly_Linked_List list1,Singly_Linked_List list2)
    {
        Node h=list1.head;
        Node s=list2.head;
        Singly_Linked_List ans=new Singly_Linked_List();

        while(h!=null && s!=null)
        {
            if(h.val<s.val)
            {
                ans.addLast(h.val);
                h=h.next;
            }
            else
            {
                ans.addLast(s.val);
                s=s.next;
            }
        }
        while(h!=null)
        {
            ans.addLast(h.val);
            h=h.next;
        }

        while(s!=null)
        {
            ans.addLast(s.val);
            s=s.next;
        }

        return ans;

    }



    // question : cycle present or not in the list

    public boolean hasCycle(Singly_Linked_List list){
        Node fast=list.head;
        Node slow=list.head;
        while(fast.next!=null && fast.next.next!=null)
        {
            fast=fast.next.next;
            slow=slow.next;
            if(fast==slow)
            {
                return true;
            }
        }
        return false;
    }

    // middle of the linked list

    public Node fidMiddle(Singly_Linked_List list)
    {
        Node f=list.head;
        Node s=list.head;

        while (f!=null && f.next!=null) {
            s=s.next;
            f=f.next.next;
        }

        return s;

    }


    // Bubble Sort
    //Recursive way bubble sort
    public void bubbleSort() {
        bubbleSort(size - 1, 0);
    }

    private void bubbleSort(int row, int col) {
        if (row == 0) {
            return;
        }

        if (col < row) {
            Node first = get(col);
            Node second = get(col + 1);

            if (first.val > second.val) {
                // swap
                if (first == head) {
                    head = second;
                    first.next = second.next;
                    second.next = first;
                } else if (second == tail) {
                    Node prev = get(col - 1);
                    prev.next = second;
                    tail = first;
                    first.next = null;
                    second.next = tail;
                } else {
                    Node prev = get(col - 1);
                    prev.next = second;
                    first.next = second.next;
                    second.next = first;
                }
            }
            bubbleSort(row, col + 1);
        } else {
            bubbleSort(row - 1, 0);
        }
    }
    // Reverse a linked list in place
     // recursion reverse
    /*  private void reverseRecursive(Node node) {
        if (node == tail) {
            head = tail;
            return;
        }
        reverseRecursive(node.next);
        tail.next = node;
        tail = node;
        tail.next = null;
    }
*/
    // in place reversal of linked list
    // google, microsoft, apple, amazon: https://leetcode.com/problems/reverse-linked-list/
    public void reverse()
    {

        if(head==null)
        {
            return;
        }
        if(size<2)
        {
            return;
        }
        Node prev=null;
        Node pres=head;
        Node next=pres.next;

        while(pres!=null)
        {
            pres.next=prev;
            prev=pres;
            pres=next;
            if(next!=null)
            {
                next=next.next;
            }
        }
        head=prev;
    }

    // rotate K times

    public void rotate(int k)
    {
        if(head==null || head.next==null)
        {
            return;
        }
        if(k<2)
        {
            return;
        }
        for(int i=0;i<k;i++)
        {
            Node end=head;
            Node prevend=null;

            while(end.next!=null)
            {
                prevend=end;
                end=end.next;
            }
            end.next=head;
            head=end;
            prevend.next=null;
        }
    }


}
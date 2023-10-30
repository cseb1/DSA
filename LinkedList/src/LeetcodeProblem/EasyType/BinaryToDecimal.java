package LeetcodeProblem.EasyType;



public class BinaryToDecimal {
    private Node head;
    private int size;

    public BinaryToDecimal() {

        this.size = -1;
    }

    public void addFirst(int val) {
        // create a new Node
        Node newNode = new Node(val);
        // check list is empty?
        if (head == null) {
            head = newNode;
            size++;
        } else {
            newNode.next = head;
            head = newNode;
            size++;
        }
    }
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

    public int getSize()
        {
            return size;
        }


    public int getDecimal(BinaryToDecimal list)
    {
        int size = -1;
        int sum = 0;
        for(Node temp = head; temp != null; temp = temp.next){
            size++;
        }
        Node node = head;
        while(node != null){
            sum += node.val * (Math.pow(2,size--));
            node = node.next;
        }
        return sum;
    }


}

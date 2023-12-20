public class QueueMain {
    public static void main(String[] args) throws Exception {
        CustomQueue queue = new CustomQueue(5);

        // insert the element

        queue.insert(12);
        queue.insert(23);
        queue.insert(34);
        queue.insert(89);

        // display the Queue

        queue.display();
        System.out.println();
        // display the front element

        System.out.println("Queue front element-->" + queue.front());
        System.out.println();

        queue.remove();
        queue.remove();

        // after the deleted the element queue display

        queue.display();
    }
}

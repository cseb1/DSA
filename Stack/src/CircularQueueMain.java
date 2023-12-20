public class CircularQueueMain {
    public static void main(String[] args) throws Exception {
        CircularQueue queue = new DynamicQueue();
        queue.insert(13);
        queue.insert(6);
        queue.insert(5);
        queue.insert(19);
        queue.insert(1);
        queue.insert(17);
        queue.insert(98);
        queue.insert(200);
        queue.insert(195);
        queue.insert(112);

        // display the queue

        queue.display();
        System.out.println(queue.toString());
        // delete one element

        System.out.println("Deleted element -->" + queue.remove());

        // After deleted operation I am insert one element

        queue.insert(133);

        // Display the Queue

        queue.display();

        // internally Queue will be like that

        System.out.println(queue.toString());
    }
}

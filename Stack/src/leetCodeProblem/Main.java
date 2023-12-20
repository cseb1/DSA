package leetCodeProblem;

public class Main {
    public static void main(String[] args) throws Exception {
        QueueUsingStacksEfficient queue = new QueueUsingStacksEfficient();

        queue.add(1);
        queue.add(2);
        queue.add(3);
        queue.add(4);

        queue.display();

        queue.add(5);

        queue.display();

        System.out.println(queue.removed());

        queue.display();

        System.out.println(queue.peek());

    }
}

package leetCodeProblem;

import java.util.Stack;

public class QueueUsingStacksEfficient {
    Stack<Integer> first;
    Stack<Integer> second;

    public QueueUsingStacksEfficient() {
        first = new Stack<>();
        second = new Stack<>();
    }

    public void add(int item) {
        while (!first.isEmpty()) {
            second.push(first.pop());
        }

        first.push(item);

        while (!second.isEmpty()) {
            first.push(second.pop());
        }
    }

    public int removed() throws Exception // this remove function is efficient
    {
        return first.pop();
    }

    public boolean isEmpty() {
        return first.isEmpty();
    }

    public int peek() {
        return first.peek();
    }

    public void display() {
        System.out.println(first);
    }
}

package leetCodeProblem;

import java.util.Stack;

public class QueueUsingStacks {
    Stack<Integer> first;
    Stack<Integer> second;

    public QueueUsingStacks() {
        first = new Stack<>();
        second = new Stack<>();
    }

    public void add(int item) {
        first.push(item);
    }

    public int removed() throws Exception // this remove func is not efficient
    {
        while (!first.isEmpty()) {
            second.push(first.pop());
        }

        int removed = second.pop();

        while (!second.isEmpty()) {
            first.push(second.pop());
        }

        return removed;
    }

    public boolean isEmpty() {
        return first.isEmpty();
    }

    public int peek() {
        while (!first.isEmpty()) {
            second.push(first.pop());
        }

        int peeked = second.peek();

        while (!second.isEmpty()) {
            first.push(second.pop());
        }

        return peeked;
    }

}

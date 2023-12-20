public class StackMain {
    public static void main(String[] args) throws Exception {
        CustomStack stack = new DynamicStack();
        stack.push(12);
        stack.push(14);
        stack.push(16);
        stack.push(20);
        stack.push(56);
        stack.push(67);
        stack.push(67);
        stack.push(67);
        stack.push(67);
        stack.push(67);
        stack.push(67);
        stack.push(67);

        // peek the top element

        System.out.println("Stack Top element is=" + stack.peek());
        System.out.println(stack.toString());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());

    }
}
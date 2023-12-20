package leetCodeProblem;

import java.util.Stack;

public class ValidParenthesis {
    public static void main(String[] args) {
        System.out.println(checkedValid("(()("));
        System.out.println(checkedValid("({}"));
        System.out.println(checkedValid("{(["));
    }

    static int checkedValid(String s) {
        Stack<Character> stack = new Stack<>();
        int size = 0;
        for (Character ch : s.toCharArray()) {
            if (ch == '(' || ch == '{' || ch == '[') {
                size += 1;
                stack.push(ch);
            } else {
                if (ch == ')') {
                    if (stack.isEmpty() || stack.pop() == '(')
                        size--;
                } else if (ch == '}') {
                    if (stack.isEmpty() || stack.pop() == '{')
                        size--;
                } else if (ch == ']') {

                    if (stack.isEmpty() || stack.pop() == '[')
                        size--;
                }
            }
        }
        return size;
    }
}

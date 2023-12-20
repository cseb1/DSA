package leetCodeProblem;

import java.util.Stack;

public class ParenthesisChecking {
    public static void main(String[] args) {
        System.out.println(checkedParenthesis("({[]})"));
        System.out.println(checkedParenthesis("{[(])}"));
    }

    static boolean checkedParenthesis(String s) {
        Stack<Character> stack = new Stack<>();

        for (Character ch : s.toCharArray()) {
            if (ch == '(' || ch == '{' || ch == '[') {
                stack.push(ch);
            } else {
                if (ch == ')') {
                    if (stack.isEmpty() || stack.pop() != '(')
                        return false;
                } else if (ch == '}') {
                    if (stack.isEmpty() || stack.pop() != '{')
                        return false;
                } else if (ch == ']') {

                    if (stack.isEmpty() || stack.pop() != '[')
                        return false;
                }
            }
        }
        return stack.isEmpty();
    }
}

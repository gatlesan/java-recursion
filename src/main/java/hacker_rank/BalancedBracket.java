package hacker_rank;

import java.util.Stack;

public class BalancedBracket {

    public static void main(String[] args) {

        String s = "()[{}()]([[][]()[[]]]{()})([]()){[]{}}{{}}{}(){([[{}([]{})]])}";
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(' || c == '{' || c == '[') {
                stack.push(c);
            } else {
                if(stack.isEmpty()) {
                    System.out.println("NO");
                    return;
                }
                char peek = stack.peek();
                if (peek == '(' && c != ')') {
                    System.out.println("NO");
                    return;
                }
                if (peek == '{' && c != '}') {
                    System.out.println("NO");
                    return;
                }
                if (peek == '[' && c != ']') {
                    System.out.println("NO");
                    return;
                }
                stack.pop();
            }
        }
        System.out.println("YES");
    }

}

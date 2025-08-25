package com.org.onStack;

import java.util.Stack;

public class ConvertInfixExpToPostFix {
    public static void main(String[] args) {
        String str = "(A+B)*(C/D)";
        System.out.println(convertToPostfix(str));
    }

    private static String convertToPostfix(String str) {
        String postFix = "";
        Stack<Character> stack = new Stack<>();
        for (Character ch: str.toCharArray()) {
           if (Character.isLetter(ch)) {
               postFix += ch;
           } else if (isOperator(ch)) {
               stack.push(ch);
           } else if (ch == ')') {
               while (!stack.isEmpty() && stack.peek() != '(') {
                   postFix += stack.pop();
               }
               if (stack.peek() == '(') {
                   stack.pop();
               }
           } else if (ch == '(') {
               stack.push(ch);
           }
        }
        while (!stack.isEmpty()) {
            postFix+=stack.pop();
        }
        return postFix;
    }
    public static boolean isOperator(Character ch) {
        if (ch == '*' || ch == '+' || ch == '-' || ch == '/') {
            return true;
        }
        return false;
    }
}

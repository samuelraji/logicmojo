package com.org.onStack;

import java.util.Stack;

public class MaximumDepthofParentheses {

    public static void main(String[] args) {
        String str = "(1+(2*3)+((8)/4))+1";
        int maxLength = 0;
        Stack<Character> stack = new Stack<>();
        for (Character ch: str.toCharArray()) {
            if (ch == '(') {
                stack.push(ch);
                maxLength = Integer.max(maxLength, stack.size());
            } else if (ch == ')') {
                stack.pop();
            }
        }
        System.out.println(maxLength);
    }
}

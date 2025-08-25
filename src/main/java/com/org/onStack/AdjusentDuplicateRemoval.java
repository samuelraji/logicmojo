package com.org.onStack;

import java.util.Stack;

public class AdjusentDuplicateRemoval {
    public static void main(String[] args) {
        String str = "abbaca";
        System.out.println(duplicateRemoval(str));
    }

    private static String duplicateRemoval(String str) {
        Stack<Character> stack = new Stack<>();
        for (Character ch: str.toCharArray()) {
            if (!stack.isEmpty() && stack.peek() == ch) {
                stack.pop();
            } else {
                stack.push(ch);
            }
        }
        char[] result = new char[stack.size()];
        for (int i=stack.size()-1; i>=0; i--) result[i] = stack.pop();
        return new String(result);
    }
}

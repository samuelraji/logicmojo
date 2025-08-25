package com.org.onStack;

import java.util.Stack;

/*
* 1.	Given a string s containing just the characters '(', ')', '{', '}', '[' and ']',
* determine if the input string is valid.
*
Input: s = "()[]{}"
Output: true
*
Input: s = "(]"
Output: false
*/
public class StringCharsValidation {
    private static boolean isItvalidBracketString(String str) {
        if (str == null || str.length() ==0) return false;
        Stack<Character> stack = new Stack<>();
        for (Character ch: str.toCharArray()) {
            if (!stack.isEmpty()) {
                if ((stack.peek() == '(' && ch == ')')
                    || (stack.peek() == '{' && ch == '}')
                        || (stack.peek() == '[' && ch == ']')) {
                    stack.pop();
                } else {
                    stack.push(ch);
                }
            } else {
                stack.push(ch);
            }
        }
        return stack.isEmpty();
    }
    public static void main(String[] args) {
        String str = "(]";
        System.out.println(isItvalidBracketString(str));
    }
}

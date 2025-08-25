package com.org.onStrings;

import java.util.Stack;

public class BracketsSwaptoCorrect {
    public static void main(String[] args) {
        String input = "][][";
        System.out.println(helper(input));
    }

    private static int helper(String input) {
        Stack<String> st = new Stack<>();
        int n = input.length();
        for (int i=0;i<n;i++) {
            if (!st.isEmpty() && st.peek().equals("[") && input.charAt(i) == ']') {
                st.pop();
            } else {
                st.push(String.valueOf(input.charAt(i)));
            }
        }
        System.out.println(st);
        return st.size()/2;
    }
}

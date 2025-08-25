package com.org.onStrings;

import java.util.Stack;

public class ReverseWordsofString {
    public static void main(String[] args) {
        String input = " hello world  ";
        System.out.println(helper(input));
    }

    private static String helper(String input) {
        int n = input.length();
        int i = 0;
        Stack<String> st = new Stack<>();
        StringBuilder result=new StringBuilder("");
        while (i < n) {
            StringBuilder sb=new StringBuilder("");
            if (input.charAt(i) == ' ') {
                i++;
            } else {
                while (input.charAt(i) != ' ') {
                    sb.append(input.charAt(i));
                    i++;
                }
                st.add(sb.toString());
            }
        }
        while (!st.empty()) {
            result.append(st.pop() + " ");
        }
        return result.toString().trim();
    }
}

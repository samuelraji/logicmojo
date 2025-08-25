package com.org.onStrings;

import java.util.Stack;

public class ReverseWordsofStringWithoutStack {
    public static void main(String[] args) {
        String input = " hello world  ";
        System.out.println(helper(input));
    }

    private static String helper(String input) {
        int n = input.length();
        int i = 0;
        StringBuilder result = new StringBuilder("");
        while (i < n) {
            StringBuilder sb=new StringBuilder("");
            if (input.charAt(i) == ' ') {
                i++;
            } else {
                while (input.charAt(i) != ' ') {
                    sb.append(input.charAt(i));
                    i++;
                }
                if (result.length() == 0) result.append(sb);
                else result.insert(0, sb+ " ");
            }
        }
        return result.toString();
    }
}

package com.org.onStrings;

import java.util.HashSet;
import java.util.Set;

public class FindNoofPalindromesInaString {
    public static void main(String[] args) {
        String input = "madam";
        System.out.println(helper(input));
    }

    private static int helper(String input) {
        Set<String> set = new HashSet<>();
        int n = input.length();
        for (int i=0;i<n;i++) {
            expand(input, i, i, set);
            expand(input, i, i+1, set);
        }
        System.out.println(set);
        return set.size();
    }

    private static void expand(String input, int l, int h, Set<String> set) {
        while (l>=0 && h<input.length() && input.charAt(l) == input.charAt(h)) {
            set.add(input.substring(l, h+1));
            l--;
            h++;
        }
    }
}

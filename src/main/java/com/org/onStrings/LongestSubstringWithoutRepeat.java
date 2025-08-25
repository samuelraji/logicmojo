package com.org.onStrings;

import java.util.HashSet;
import java.util.Set;

public class LongestSubstringWithoutRepeat {
    public static void main(String[] args) {
        String s = "pwwkew";
        System.out.println(longestSustringWithoutRepeat(s));
    }

    private static int longestSustringWithoutRepeat(String s) {
        int i=0, j=0;
        int maxLen = 0;
        Set<Character> set = new HashSet<>();
        while (i<s.length()) {
            char ch = s.charAt(i);
            if (!set.contains(ch)) {
                set.add(ch);
                maxLen = Integer.max(i-j+1, maxLen);
                i++;
            } else {
                set.remove(s.charAt(j));
                j++;
            }
        }
        return maxLen;
    }
}

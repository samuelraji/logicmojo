package com.org.practice;

import java.util.HashSet;

public class StringReverse {
        public static void main(String[] args) {
            String s = "pwwkew";
            int length = lengthOfLongestSubstring(s);
            System.out.println("Length: " + length); // Output: 3
        }
        public static int lengthOfLongestSubstring(String s) {
            int maxLength = 0, left = 0;
            HashSet<Character> set = new HashSet<>();
            for (int right = 0; right < s.length(); right++) {
                while (set.contains(s.charAt(right))) {
                    set.remove(s.charAt(left));
                    left++;
                }
                set.add(s.charAt(right));
                maxLength = Math.max(maxLength, right - left + 1);
            }
            return maxLength;
        }
}

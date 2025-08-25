package com.org.onStrings;

public class StringsAnagrams {
    public static void main(String[] args) {
        String s = "anagram", t = "nagaram";
        System.out.println(areAnagrams(s, t));
    }

    private static boolean areAnagrams(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        int[] alphabet = new int[26];
        for (int i=0; i<s.length(); i++) alphabet[s.charAt(i)-'a']++;
        for (int j=0; j<t.length(); j++) alphabet[t.charAt(j)-'a']--;
        for (int k=0;k<alphabet.length;k++) if (alphabet[k] != 0) return false;
        return true;
    }

}

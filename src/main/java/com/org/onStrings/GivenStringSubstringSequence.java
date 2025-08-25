package com.org.onStrings;

public class GivenStringSubstringSequence {
    public static void main(String[] args) {
        String s = "abc", t = "ahbgdc";
        System.out.println(givenStrisSubStringSeq(s, t));
    }

    private static boolean givenStrisSubStringSeq(String s, String t) {
        int i=0,j=0;
        for (;i<t.length();i++) {
            if (t.charAt(i) == s.charAt(j)) {
                j++;
            }
        }
        return s.length() == j;
    }
}

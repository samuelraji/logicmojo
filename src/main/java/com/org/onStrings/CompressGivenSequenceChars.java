package com.org.onStrings;

public class CompressGivenSequenceChars {
    public static void main(String[] args) {
        char[] chars = {'a','a','b','b','c','c','c','c','c','c','c','c','c','c','c','c'};
        int index = compress(chars);
        for (int i=0; i<index;i++) {
            System.out.print(chars[i]);
        }
    }

    private static int compress(char[] chars) {
        int ans=0, i=0;
        int n = chars.length;
        while (i<n) {
            int count = 0;
            char ch = chars[i];
            while (i<n && ch == chars[i]) {
                count++;
                i++;
            }
            chars[ans++] = ch;
            if (count > 1) {
                for (char countChar:Integer.toString(count).toCharArray()) {
                    chars[ans++] = countChar;
                }
            }
        }
        return ans;
    }


}

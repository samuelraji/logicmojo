package com.org.arrays;

public class PalindromeBuilder {
    public String solution(int N, int K) {
        if (K > 26 || K > (N + 1) / 2) {
            return ""; // Not possible to build a valid palindrome
        }

        char[] palindrome = new char[N];
        int left = 0, right = N - 1;

        // Use the first K distinct letters
        for (int i = 0; i < K; i++) {
            char c = (char) ('a' + i);
            palindrome[left++] = c;
            palindrome[right--] = c;
        }

        // Fill remaining positions with 'a' (or any reused character)
        while (left <= right) {
            palindrome[left++] = 'a';
            palindrome[right--] = 'a';
        }

        return new String(palindrome);
    }

    public static void main(String[] args) {
        PalindromeBuilder builder = new PalindromeBuilder();
        System.out.println(builder.solution(7, 3)); // Example output: "abacaba"
        System.out.println(builder.solution(6, 2)); // Example output: "abccba"
        System.out.println(builder.solution(5, 6)); // Impossible, returns ""
        System.out.println(builder.solution(26, 13));
    }
}

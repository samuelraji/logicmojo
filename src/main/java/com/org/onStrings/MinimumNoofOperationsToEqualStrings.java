package com.org.onStrings;

public class MinimumNoofOperationsToEqualStrings {
    public static void main(String[] args) {
        String str1 = "zwcmqpow", str2 = "zwtcmqpow";
        int n = str1.length();
        int m = str2.length();
        int[][] dp = new int[n + 1][m + 1];

        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= m; j++) {
                dp[i][j] = -1;
            }
        }
        System.out.println(minDis(str1, str2, n, m, dp));
    }

    public static int minDis(String s1, String s2, int n, int m, int[][] dp) {

        // If any String is empty,
        // return the remaining characters of other String
        if(n == 0)
            return m;
        if(m == 0)
            return n;
        // To check if the recursive tree
        // for given n & m has already been executed
        if(dp[n][m] != -1)
            return dp[n][m];
        // If characters are equal, execute
        // recursive function for n-1, m-1
        if(s1.charAt(n - 1) == s2.charAt(m - 1)) {
            return dp[n][m] = minDis(s1, s2, n - 1, m - 1, dp);
        }
        // If characters are not equal, we need to
        // find the minimum cost out of all 3 operations.
        else{
            int insert, del, replace; // temp variables
            insert = minDis(s1, s2, n, m - 1, dp);
            del = minDis(s1, s2, n - 1, m, dp);
            replace = minDis(s1, s2, n - 1, m - 1, dp);
            return dp[n][m] = 1+ Math.min(insert, Math.min(del, replace));
        }
    }
}

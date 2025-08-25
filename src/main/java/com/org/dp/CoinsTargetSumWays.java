package com.org.dp;

import java.util.Arrays;

public class CoinsTargetSumWays {
    public static void main(String[] args) {
        int sum = 4;
        int[] coins = {1,2,3};
        int[][] memo = new int[coins.length + 1][sum + 1];
        for (int[] row : memo) {
            Arrays.fill(row, -1);
        }
        int ways = findWays(coins, sum, coins.length, memo);
        System.out.println(ways);
    }

    private static int findWays(int[] a, int sum, int n, int[][] dp) {
        if(sum == 0)
            return dp[n][sum] = 1;
        if(n == 0)
            return 0;
        if(dp[n][sum] != -1)
            return dp[n][sum];
        if(a[n - 1] <= sum) { // Either Pick this coin or not
            return dp[n][sum]
                    = findWays(a, sum - a[n - 1], n, dp)
                    + findWays(a, sum, n - 1, dp);
        } else// We have no option but to leave this coin
            return dp[n][sum] = findWays(a, sum, n - 1, dp);
    }
}

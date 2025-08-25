package com.org.dp;

import java.util.Arrays;

public class LongestIncreasingSubsequence {
    public static void main(String[] args) {
        int[] arr = {3, 10, 2, 1, 20};
        int n = arr.length;
        int[][] dp = new int[n+1][n+1];
        for(int row[] : dp)
            Arrays.fill(row, -1);
        System.out.println(func(0, -1, n, arr, dp));
    }

    private static int func(int idx, int prev_idx, int n, int[] arr, int[][] dp) {
        if(idx == n) {
            return 0;
        }

        if(dp[idx][prev_idx + 1] != -1) {
            return dp[idx][prev_idx + 1];
        }

        int notTake = 0+ func(idx + 1, prev_idx, n, arr, dp);
        int take = Integer.MIN_VALUE;
        if(prev_idx == -1|| arr[idx] > arr[prev_idx]) {
            take = 1+ func(idx + 1, idx, n, arr, dp);
        }

        return dp[idx][prev_idx + 1]
                = Math.max(take, notTake);
    }
}

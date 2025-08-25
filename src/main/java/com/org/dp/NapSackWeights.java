package com.org.dp;

import java.util.Arrays;

public class NapSackWeights {

    public static void main(String args[]) {
        int N = 3, W = 4;
        int values[] = {1,2,3};
        int weight[] = {4,5,1};
        int dp[][] = new int[N + 1][W + 1];
        for (int[] row:dp) Arrays.fill(row, -1);

        System.out.println(knapSackRec(W, weight, values, N, dp));
    }

    static int knapSackRec(int W, int wt[], int val[],
                         int n, int[][] dp) {
        // Base condition
        if(n == 0 || W == 0)
            return 0;

        if(dp[n][W] != -1)
            return dp[n][W];

        if(wt[n - 1] > W)
            // Store the value of function call
            // stack in table before return
            return dp[n][W]
                    = knapSackRec(W, wt, val, n - 1, dp);
        else
            // Return value of table after storing
            return dp[n][W]
                    = Math.max((val[n - 1]
                            + knapSackRec(W - wt[n - 1], wt, val,
                            n - 1, dp)),
                    knapSackRec(W, wt, val, n - 1, dp));
    }


}

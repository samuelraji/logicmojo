package com.org.dp;

import java.util.Arrays;

public class StepsRunningPossibilities {
    public static void main(String[] args) {
        int steps = 3;
        int[] dp = new int[steps+1];
        Arrays.fill(dp, -1);
        int result = findStepHelper(steps, dp);
        System.out.println(result);
    }

    private static int findStepHelper(int n, int[] dp) {
        if(n == 0) return 1;
        else if(n < 0) return 0;
        // If subproblems are already calculated
        //then return it
        if(dp[n] != -1) {
            return dp[n];
        }
        // store the subproblems in the vector
        return dp[n] = findStepHelper(n - 3, dp)
                + findStepHelper(n - 2, dp)
                + findStepHelper(n - 1, dp);
    }
}

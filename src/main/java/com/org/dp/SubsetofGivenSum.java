package com.org.dp;

public class SubsetofGivenSum {
    public static void main(String[] args) {
        int[] a = {3, 34, 4, 12, 5, 2};
        int sum = 9;
        int n = a.length;
        // Storing the value -1 to the matrix
        int tab[][] = new int[n + 1][sum + 1];
        for(int i = 1; i<= n; i++) {
            for(int j = 1; j <= sum; j++) {
                tab[i][j] = -1;
            }
        }
        System.out.println(subsetSum(a, n, sum, tab));
    }
    static int subsetSum(int a[], int n, int sum, int[][] tab) {
        // If the sum is zero it means
        // we got our expected sum
        if(sum == 0) return 1;

        if(n <= 0) return 0;

        // If the value is not -1 it means it
        // already call the function
        // with the same value.
        // it will save our from the repetition.
        if(tab[n - 1][sum] != -1)
            return tab[n - 1][sum];
        // if the value of a[n-1] is
        // greater than the sum.
        // we call for the next value
        if(a[n - 1] > sum)
            return tab[n - 1][sum]
                    = subsetSum(a, n - 1, sum, tab);
        else {
            // Here we do two calls because we
            // don't know which value is
            // full-fill our criteria
            // that's why we doing two calls
            if(subsetSum(a, n - 1, sum, tab) != 0
                    || subsetSum(a, n - 1, sum - a[n - 1], tab)
                    !=0) {
                return tab[n - 1][sum] = 1;
            }
            else return tab[n - 1][sum] = 0;
        }
    }
}

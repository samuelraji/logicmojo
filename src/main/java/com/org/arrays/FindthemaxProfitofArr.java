package com.org.arrays;

public class FindthemaxProfitofArr {

    public static int findtheValue(int[] arr) {
        int buy = arr[0];
        int profit = 0;
        for (int i=1; i<arr.length;i++) {
            if (arr[i]<buy) {
                buy=arr[i];
            } else if (arr[i]-buy > profit) {
                profit = arr[i]-buy;
            }
        }
        return profit;
    }

    public static void main(String[] args) {
        int arr[] = {7, 1, 5, 4, 6, 3, 8};
        int profit = findtheValue(arr);
        System.out.println("PROFIT :: " + profit);
    }
}

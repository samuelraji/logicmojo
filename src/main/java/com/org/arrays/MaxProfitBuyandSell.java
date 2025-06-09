package com.org.arrays;

public class MaxProfitBuyandSell {

    public static int maxProfit(int arr[]) {
        int profit = 0;
        if (arr.length > 1) {
            int buy = arr[0];
            for (int i=1; i<arr.length; i++) {
                if (arr[i] < buy) {
                    buy = arr[i];
                }
                if (arr[i] - buy > profit) {
                    profit = arr[i] - buy;
                }
            }
        }
        return profit;
    }

    public static void main(String[] args) {
        int prices[] = { 7, 1, 5, 3, 6, 4 };
        System.out.println(" MaxProfit :: " +maxProfit(prices));
    }
}

package com.org.arrays;

import java.util.List;

public class MaxProfitBuyandSellMultiple {
    public static int findMaxProfit(int price[]) {
        int profit = 0;
        if (price.length > 1) {
            int j = 0;
            for (int i=1; i<price.length; i++) {
                if (price[i] < price[i-1])
                    j = i;
                //sell shares if the current element is the peak,
                //i.e., (`previous <= current > next`)
                if (price[i-1] <= price[i] && (i+1 == price.length || price[i] > price[i+1])) {
                    profit += (price[i] - price[j]);
                    System.out.println("Buy on day " +(j + 1)+ " and sell on day "+(i + 1)+"\n");
                }
            }
        }
        return profit;
    }

    public static void main(String[] args) {
        //int stockPrices[] = {1, 5, 2, 3, 7, 6, 4, 5};
        //System.out.println("MaxProfit :: " + findMaxProfit(stockPrices));

        List<Integer> arr = List.of(2, 2, 1, 1, 1, 2, 2);
        System.out.println(arr.size()/2);
    }
}

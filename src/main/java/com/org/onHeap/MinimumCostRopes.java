package com.org.onHeap;

import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

public class MinimumCostRopes {

    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(5, 4, 2, 8);
        System.out.println(minimumCost(list));
    }

    private static int minimumCost(List<Integer> arr) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(arr);
        int cost = 0;
        while (pq.size() > 1) {
            int sum = pq.poll() + pq.poll();
            pq.add(sum);
            cost = cost + sum;
            System.out.println(sum +" "+ cost);
        }
        return cost;
    }

}

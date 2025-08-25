package com.org.onHeap;

import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

public class FindKthLargestElement {
    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(68, 53, 89, 5, 8, 134, 203, 305, 16, 34);
        int k = 3;
        System.out.println(findKthElement(list, k));
    }

    private static int findKthElement(List<Integer> arr, int k) {
        int n = arr.size();
        if (n < 3) return -1;
        PriorityQueue<Integer> pq = new PriorityQueue<>(arr.subList(0, k));
        for (int i=k; i<n; i++) {
            int element = arr.get(i);
            if (element > pq.peek()) {
                pq.poll();
                pq.add(element);
            }
        }
        return pq.peek();
    }
}

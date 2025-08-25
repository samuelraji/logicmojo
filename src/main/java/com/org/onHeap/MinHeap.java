package com.org.onHeap;

import java.util.PriorityQueue;

public class MinHeap {
    final PriorityQueue<Integer> pq;
    final int k;

    public MinHeap(PriorityQueue<Integer> pq, int k) {
        this.pq = pq;
        this.k = k;
    }
    public int add(int num) {
        if (pq.size() < k) pq.add(num);
        else if (pq.peek() < num) {
            pq.poll();
            pq.add(num);
        }
        if (pq.size() == k) {
            return pq.peek();
        } else {
            return -1;
        }
    }

    public static void main(String[] args) {
        MinHeap minHeap = new MinHeap(new PriorityQueue<>(), 3);
        minHeap.add(5);
        System.out.println(minHeap.add(10));
        System.out.println(minHeap.add(15));
        System.out.println(minHeap.add(20));
        System.out.println(minHeap.add(7));
        System.out.println(minHeap.add(5));
        System.out.println(minHeap.add(205));
        System.out.println(minHeap.add(303));
        System.out.println(minHeap.add(85));
    }
}

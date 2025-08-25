package com.org.onQueue;

import java.util.LinkedList;
import java.util.Queue;

public class MovingAverage {

    public static void main(String[] args) {
        Integer[] arr = new Integer[]{1,10,3,5};
        int size = 3;
        int sum = 0;
        int curSize = 0;
        Queue<Integer> queue = new LinkedList<>();
        for (int i=0; i< arr.length; i++) {
            curSize++;
            queue.add(arr[i]);
            Integer first = curSize>size? queue.poll() : 0;
            if(curSize>size) curSize--;
            sum = sum - first + arr[i];
            System.out.println(sum/(double)curSize);
        }
    }
}

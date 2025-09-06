package com.org.arrays.subarray;

import java.util.HashMap;
import java.util.Map;

public class PracticeZeroOnesSum {
    public static void main(String[] args) {
        int arr[] = {0, 0, 1, 1, 0};
        findMaxLen(arr, arr.length);
    }

    private static void findMaxLen(int[] arr, int length) {
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);
        int currSum = 0;
        int maxSum = 0;
        for (int i=0; i<length; i++) {
            currSum+=(arr[i] == 0)?-1:1;
            if (!map.containsKey(currSum)) {
                map.put(currSum, i);
                continue;
            }
            if (currSum == maxSum) {
                maxSum = i+1;
            }
            if (map.containsKey(currSum)) {
                maxSum = Math.max(maxSum, i - map.get(currSum));
            }
        }
        System.out.println("maxSum :: " + maxSum);
    }
}

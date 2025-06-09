package com.org.arrays.subarray;

import java.util.HashMap;
import java.util.Map;

public class SubArraySum {

    public static void main(String[] args) {
        int arr[] = {1, 4, 20, 3, 10, 5}, targetsum = 33;
        Map<Integer, Integer> hashMap = new HashMap<>();
        int sum = 0;
        int start = 0, end = -1;
        for (int i=0; i<arr.length; i++) {
            sum += arr[i];
            // 1:0, 5:1, 25:2, 28:3, 38:4, 43:5
            if (!hashMap.containsKey(sum)) {
                hashMap.put(sum, i);
            }
            if (sum == targetsum) {
                end = i;
                break;
            }
            if (hashMap.containsKey(sum-targetsum)) {
                int value = hashMap.get(sum-targetsum);
                start = value + 1;
                end = i;
                break;
            }
        }
        System.out.println(hashMap);
        if (end == -1) {
            System.out.println("There is no subArray matching to this targetSum: "+ targetsum);
        } else {
            for (;start<=end;start++) {
                System.out.print(arr[start] + " ");
            }
        }
    }
}

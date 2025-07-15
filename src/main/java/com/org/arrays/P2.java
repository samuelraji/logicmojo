package com.org.arrays;

import java.util.Arrays;
import java.util.Map;
import java.util.TreeMap;

public class P2 {
    public static void main(String[] args) {
        int arr[] = {1, 4, 20, 3, 10, 5};
        subArraySumEqualstoGiven(arr, 33);
    }

    private static void subArraySumEqualstoGiven(int[] arr, int target_sum) {
        Map<Integer, Integer> map = new TreeMap<>();
        int cur_sum=0;
        int start=0;
        int end=-1;
        for (int i=0;i<arr.length;i++) {
            cur_sum+=arr[i];
            if (cur_sum-target_sum == 0) {
                start=0;
                end = i;
                break;
            }
            if (map.containsKey(cur_sum-target_sum)) {
                start = map.get(cur_sum-target_sum)+1;
                end=i;
                break;
            }
            map.put(cur_sum, i);
        }
        if(end == -1) {
            System.out.println(
                    "No subarray with given sum exists");
        }
        else{
            System.out.println("Sum found between indexes "
                    + start + " to "+ end);
        }
    }

}

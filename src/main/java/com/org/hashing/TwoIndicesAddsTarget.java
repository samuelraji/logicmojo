package com.org.hashing;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class TwoIndicesAddsTarget {

    public static void main(String[] args) {
        int[] arr = {3,2,4};
        int target = 6;
        System.out.println(Arrays.toString(twoSum(arr, target)));
    }

    private static int[] twoSum(int[] arr, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        int size = arr.length;
        for (int i=0; i<size; i++) {
            if (map.get(target - arr[i]) != null) {
                return new int[]{map.get(target - arr[i]), i};
            } else {
                map.put(arr[i], i);
            }
        }
        return new int[]{};
    }
}

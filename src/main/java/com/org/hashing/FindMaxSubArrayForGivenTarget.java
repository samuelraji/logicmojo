package com.org.hashing;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class FindMaxSubArrayForGivenTarget {
    public static void main(String[] args) {
        int[] nums = {5,6,-5,5,3,5,3,-2,0};
        int target = 8;
        System.out.println(Arrays.toString(subArr(nums, target)));
    }

    private static int[] subArr(int[] nums, int target) {
        int end_index = -1;
        int len = 0;
        int sum = 0;
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);
        int size = nums.length;
        for (int i=0; i<size; i++) {
            sum+=nums[i];
            map.putIfAbsent(sum, i);
            if (map.containsKey(sum-target) && len < i-map.get(sum-target)) {
                len = i-map.get(sum-target);
                end_index = i;
            }
        }
        if (end_index == -1) return new int[]{};
        return new int[]{end_index-len+1, end_index};
    }
}

package com.org.arrays;

import java.util.Map;
import java.util.TreeMap;

public class Solution {
    public static void main(String[] args) {
        int[][] intervals = {{0,30},{5,10},{15,20}};
        Map<Integer, Integer> map = new TreeMap<>();
        for (int i=0; i<intervals.length; i++) {
            map.put(intervals[i][0], map.getOrDefault(intervals[i][0], 0)+1);
            map.put(intervals[i][1], map.getOrDefault(intervals[i][1], 0)-1);
        }
        int c=0, max=0;
        for (Map.Entry entry: map.entrySet()) {
            c = c + ((int)entry.getValue());
            if (c > max) {
                max = c;
            }
        }
        System.out.println("Max :: "+ max);
    }
}

package com.org.hashing;

import java.util.HashMap;
import java.util.Map;

public class SymmetricArrays {
    public static void main(String[] args) {
        int[][] arr = {{11, 20}, {30, 40}, {5, 10}, {40, 30}, {10, 5}};
        Map<Integer, Integer> map = new HashMap<>();
        for (int i=0; i< arr.length; i++) {
            //arr[i][0], arr[i][1]
            if (map.get(arr[i][1]) != null) {
                System.out.println(arr[i][1] + " and " + arr[i][0] + " are symmetric");
            } else {
                map.put(arr[i][0], arr[i][1]);
            }
        }
    }
}

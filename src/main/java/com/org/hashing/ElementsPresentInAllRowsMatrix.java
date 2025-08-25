package com.org.hashing;

import java.util.HashMap;
import java.util.Map;

public class ElementsPresentInAllRowsMatrix {
    public static void main(String[] args) {
        int[][] mat = new int[][]{
                            {2,4,3,8,7},
                            {4,7,1,3,6},
                            {3,5,2,1,3},
                            {4,5,0,2,3}};
        Map<Integer, Integer> map = new HashMap<>();
        for (int i=0; i<mat.length; i++) {
            for (int j=0; j<mat[i].length; j++) {
                if (i==0) map.put(mat[i][j], i);
                if (map.containsKey(mat[i][j]) && map.get(mat[i][j]) == i-1) {
                    map.put(mat[i][j], i);
                }
            }
        }
        for (Map.Entry<Integer, Integer> entry: map.entrySet()) {
            if (entry.getValue() == mat.length-1) {
                System.out.println(entry.getKey());
            }
        }
    }
}

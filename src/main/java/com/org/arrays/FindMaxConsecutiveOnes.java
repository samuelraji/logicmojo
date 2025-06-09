package com.org.arrays;

import java.util.List;

public class FindMaxConsecutiveOnes {
    public static void main(String[] args) {
        //1 1 0 1 1 1
        //Sample Output 0
        //3
        List<Integer> list = List.of(1, 1, 0, 1, 1, 1);
        int count=0, maxCount=0;
        for (int i=0;i< list.size(); i++) {
            if (list.get(i) == 1) {
                count++;
            } else {
                count = 0;
            }
            if (count > maxCount) {
                maxCount = count;
            }
        }
        System.out.println("maxCount : "+ maxCount);
    }
}

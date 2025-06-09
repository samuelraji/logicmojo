package com.org.arrays;

import java.util.ArrayList;
import java.util.List;

public class MoveZerosToRight {
    public static void main(String[] args) {
        List<Integer> list = List.of(1, 2, 0, 0, 3, 4);
        List<Integer> newArr = new ArrayList<>();
        int j=0;
        for (int i=0;i<list.size();i++) {
            if (list.get(i) != 0) {
                newArr.add(list.get(i));
                j++;
            }
        }
        for (;j<list.size();j++) {
            newArr.add(0);
        }
        newArr.forEach(System.out::println);
    }
}

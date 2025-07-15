package com.org.practice;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class MaxFrequencyElement {
    public static void main(String[] args) {
        Scanner sn = new Scanner(System.in);
        System.out.print("Enter size of the array: ");
        int size = sn.nextInt();
        int[] arr = new int[size];
        System.out.print("Enter "+ size+" elements : ");
        for (int i=0;i<size;i++) {
            arr[i] = sn.nextInt();
        }
        Map<Integer, Integer> map = new HashMap<>();
        for (int num: arr) {
            map.put(num, map.getOrDefault(num, 0)+1);
        }
        int noOfTimes = 0;
        int occuredNumber = 0;
        for (Map.Entry<Integer, Integer> entry: map.entrySet()) {
            if (noOfTimes <= entry.getValue()) {
                noOfTimes = entry.getValue();
                occuredNumber = entry.getKey();
            }
        }
        System.out.println("noOfTimes :: "+ noOfTimes);
        System.out.println("occuredNumber :: "+ occuredNumber);
        sn.close();
    }
}

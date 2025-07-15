package com.org.practice;

public class Hello {
    public static void main(String[] args) {
        int[] arr = {12, 45, 1, -1, 78, 23, 90};
        if (arr.length < 3) {
            System.out.println("Array must have at least 3 elements.");
            return;
        }
        int first = Integer.MIN_VALUE;
        int second = Integer.MIN_VALUE;
        int third = Integer.MIN_VALUE;
        for (int num: arr) {
            if (num > first) {
                third = second;
                second = first;
                first = num;
            } else if (num > second && num != first) {
                third = second;
                second = num;
            } else if (num > third && num != first && num != second) {
                third = num;
            }
        }
        System.out.println("First: "+ first+" Second: "+second +" Third: "+ third);
    }
}

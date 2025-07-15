package com.org.arrays;

public class MaxWaterInTowers {
    public static void main(String[] args) {
        int[] arr = {1, 8, 6, 2, 5, 4, 8, 3, 7};
        int left=0, right=arr.length-1;
        int maxWater = Integer.MIN_VALUE;
        while (left < right) {
            int minimum = Integer.min(arr[left], arr[right]);
            int width = right - left;
            int currentVal = minimum * width;
            if (maxWater < currentVal) {
                maxWater =currentVal;
            }
            if (arr[left] < arr[right]) {
                left++;
            } else {
                right--;
            }
        }
        System.out.println("maxWater :: " + maxWater);
    }
}

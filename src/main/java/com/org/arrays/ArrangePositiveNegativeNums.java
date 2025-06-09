package com.org.arrays;

public class ArrangePositiveNegativeNums {
    public static void main(String[] args) {
        int arr[] = {-12, 0, 11, -13, -5, 0, 6, -7, 5, -3, -6};
        int left=0, right=arr.length-1, pivot=0;
        while (left<right) {
            if (arr[left] < pivot) {
                left++;
            } else if (arr[right] > pivot) {
                right--;
            } else {
                int temp = arr[left];
                arr[left] = arr[right];
                arr[right] = temp;
                left++;
                right--;
            }
        }
        for (int num: arr) {
            System.out.print(num + " ");
        }
    }
}

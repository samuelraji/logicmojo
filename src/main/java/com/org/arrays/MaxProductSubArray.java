package com.org.arrays;

public class MaxProductSubArray {
    public static void main(String[] args) {
        int arr[] = {6, -3, -10, 0, 2, 50, 3};
        int max_ending_here = arr[0];
        int min_ending_here = arr[0];
        int max_so_far = arr[0];
        int n = arr.length;
        for(int i = 1; i< n; i++) {
            int temp = Math.max(Math.max(arr[i], arr[i] * max_ending_here),
                    arr[i] * min_ending_here);
            min_ending_here = Math.min(
                    Math.min(arr[i], arr[i] * max_ending_here),
                    arr[i] * min_ending_here);
            max_ending_here = temp;
            max_so_far = Math.max(max_so_far, max_ending_here);
        }
        System.out.println("max_so_far :: "+ max_so_far);
    }
}

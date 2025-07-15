package com.org.arrays;

public class ProductExceptCurrentElement {
    public static int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] prefix = new int[n];
        int[] suffix = new int[n];
        int[] result = new int[n];

        prefix[0] = 1;
        for (int i = 1; i< n; i++) {
            prefix[i] = prefix[i-1] * nums[i-1];
        }
        for(int num: prefix) {
            System.out.print(num + " ");
        }
        System.out.println();
        System.out.println("========================");

        suffix[n-1] = 1;
        for (int i = n-2; i>= 0; i--) {
            suffix[i] = suffix[i+1] * nums[i+1];
        }
        for(int num: suffix) {
            System.out.print(num + " ");
        }
        System.out.println();
        System.out.println("========================");

        for (int i = 0; i< n; i++) {
            result[i] = prefix[i] * suffix[i];
        }

        return result;
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4};
        int[] result = productExceptSelf(arr);
        for(int num: result) {
            System.out.print(num + " ");
        }
    }
}

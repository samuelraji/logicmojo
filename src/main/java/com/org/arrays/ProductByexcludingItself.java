package com.org.arrays;

public class ProductByexcludingItself {
    public static void main(String[] args) {
        int arr[] = {1, 2, 3, 4};
        int suffix[] = new int[4];
        int prefix[] = new int[4];
        int res[] = new int[4];
        prefix[0] = 1;
        suffix[arr.length-1] = 1;
        for (int i=1; i<arr.length; i++) {
            prefix[i] = prefix[i-1] * arr[i-1];
        }
        for (int j = arr.length-2; j>=0;j--) {
            suffix[j] = suffix[j+1] * arr[j+1];
        }
        for (int i = 0; i<arr.length;i++) {
            res[i] = prefix[i] * suffix[i];
        }
        for (int num: res) {
            System.out.print(num + " ");
        }
    }
}

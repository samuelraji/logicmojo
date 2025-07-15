package org.example;

import java.util.Arrays;

public class Test2 {

    public static void main(String[] args) {
        int[] arr = {1, 3, 5, 7, 9, 11, 13};
        int key = 7;
        // Perform binary search
        int index = Arrays.binarySearch(arr, 4, 6, key);
        if (index >= 0) {
            System.out.println("Element found at index: " + index);
        } else {
            System.out.println("Element not found.");
        }
    }
}

package com.org.arrays;

public class BinaryArrMaxCountReplace {

    public static int findIndexOfZeroToReplace(int[] arr) {
        int maxCount = 0;
        int maxIndex = -1;

        int prevZeroIndex = -1;
        int left = 0;

        for (int right = 0; right < arr.length; right++) {
            if (arr[right] == 0) {
                // Update left to one after previous zero
                if (prevZeroIndex != -1) {
                    left = prevZeroIndex + 1;
                }
                prevZeroIndex = right;
            }

            // Update if this window is larger
            if (right - left + 1 > maxCount) {
                maxCount = right - left + 1;
                maxIndex = prevZeroIndex;
            }
        }

        return maxIndex;
    }

    public static void main(String[] args) {
        int[] arr = {0, 0, 1, 0, 1, 1, 1, 0, 1, 1};
        int result = findIndexOfZeroToReplace(arr);
        System.out.println("Replace index: " + result); // Output: 7
    }
}

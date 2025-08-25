package com.org.arrays.more;
import java.util.*;

public class MaxRainWater {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Read input size
        int n = sc.nextInt();
        int[] height = new int[n];

        // Read elevation heights
        for (int i = 0; i < n; i++) {
            height[i] = sc.nextInt();
        }

        // Compute and print the total trapped water
        System.out.println(trapRainWater(height));
    }

    public static int trapRainWater(int[] height) {
        int n = height.length;
        if (n == 0) return 0;

        int[] leftMax = new int[n];
        int[] rightMax = new int[n];

        // Build leftMax array
        leftMax[0] = height[0];
        for (int i = 1; i < n; i++) {
            leftMax[i] = Math.max(leftMax[i - 1], height[i]);
        }

        // Build rightMax array
        rightMax[n - 1] = height[n - 1];
        for (int i = n - 2; i >= 0; i--) {
            rightMax[i] = Math.max(rightMax[i + 1], height[i]);
        }

        // Calculate water trapped
        int waterTrapped = 0;
        for (int i = 0; i < n; i++) {
            int waterAtI = Math.min(leftMax[i], rightMax[i]) - height[i];
            if (waterAtI > 0) {
                waterTrapped += waterAtI;
            }
        }

        return waterTrapped;
    }
}


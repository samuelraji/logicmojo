package com.org.arrays.more;

public class PracticeMaxRainWater {
    public static void main(String[] args) {
        int[] height = {0,1,0,2,1,0,1,3,2,1,2,1};
        System.out.println(maxRainWater(height));
    }

    private static int maxRainWater(int[] height) {
        int left=0, right=height.length-1;
        int maxLeft=0, maxRight=0;
        int maxWater = 0;
        while (left<right) {
            if (height[left] < height[right]) {
                if (height[left] >= maxLeft) {
                    maxLeft = height[left];
                } else {
                    maxWater+=maxLeft-height[left];
                }
                left++;
            } else {
                if (height[right] >= maxRight) {
                    maxRight = height[right];
                } else {
                    maxWater+=maxRight-height[right];
                }
                right--;
            }
        }
        return maxWater;
    }
}

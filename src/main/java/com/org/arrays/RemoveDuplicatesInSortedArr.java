package com.org.arrays;

public class RemoveDuplicatesInSortedArr {
    public static void main(String[] args) {
        int nums[] = {0,0,1,1,1,2,2,3,3,4};
        int i=0;
        for (int num: nums) {
            if (i==0 || num > nums[i-1]) {
                nums[i++] = num;
            }
        }
        for (int j=0; j<i; j++) {
            System.out.print(" "+ nums[j]);
        }
    }
}

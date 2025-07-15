package com.org.arrays.twopointer;

public class RemoveAnElement {
    public static int removeElement(int[] nums, int val) {
        int j=0;
        for (int i=0; i<nums.length; i++) {
            if (nums[i] == val) {
                j++;
            }
            if (nums[i] != val && nums[j] == val) {
                nums[j] = nums[i];
                j++;
            }
        }
        return j+1;
    }

    public static void main(String[] args) {
        int nums[] = {0,1,2,2,3,0,4,2}, val = 2;
        int uniqueCount = removeElement(nums, val);

        for (int i = 0; i < uniqueCount; i++) {
            System.out.print(nums[i] + " ");
        }
    }
}

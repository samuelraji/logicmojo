package com.org.arrays.twopointer;

class RemoveDuplicates {
    public static int removeDuplicates(int[] nums) {
        int j = 0;
        for (int i=1; i< nums.length; i++) {
            if (nums[i] != nums[j]) {
                j++;
                nums[j] = nums[i];
            }
        }
        return j+1;
    }

    public static void main(String args[]) {
        int[] nums =  {0,0,1,1,1,2,2,3,3,4};
        // Call method to remove duplicates
        int uniqueCount = removeDuplicates(nums);

        // Print the unique elements
        for (int i = 0; i < uniqueCount; i++) {
            System.out.print(nums[i] + " ");
        }
    }
}
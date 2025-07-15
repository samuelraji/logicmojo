package com.org.binarysearchtree;

public class SumOfElementsFromGivenLowHighNums {
    /*15
    10 20
    8 12 16 25*/
    public static int sum = 0;
    public static void main(String[] args) {
        TreeNode root = new TreeNode(10);
        root.left = new TreeNode(5);
        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(7);
        root.right = new TreeNode(15);
        root.right.right = new TreeNode(18);
        findSumofRangeNum(root, 7, 15);
        System.out.println("Sum :: "+ sum);
    }

    private static void findSumofRangeNum(TreeNode root, int low, int high) {
        if (root == null) {
            return;
        }
        findSumofRangeNum(root.left, low, high);
        if (root.data >= low && root.data <= high) {
            sum += root.data;
        }
        findSumofRangeNum(root.right, low, high);
    }
}

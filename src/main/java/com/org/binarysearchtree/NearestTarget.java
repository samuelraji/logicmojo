package com.org.binarysearchtree;

public class NearestTarget {
    /*15
    10 20
    8 12 16 25*/
    public static int nearestToTarget = 0;
    public static double difference = 0.00;
    public static void main(String[] args) {
        TreeNode root = new TreeNode(4);
        root.left = new TreeNode(2);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(3);
        root.right = new TreeNode(5);
        double target = 3.70;
        findSumofRangeNum(root, target);
        System.out.println("nearestToTarget :: "+ nearestToTarget);
    }

    private static void findSumofRangeNum(TreeNode root, double target) {
        if (root == null) {
            return;
        }
        findSumofRangeNum(root.left, target);
        if ((double)root.data-target > difference && target <= (double) root.data) {
            difference = root.data-target;
            nearestToTarget = root.data;
        }
        findSumofRangeNum(root.right, target);
    }
}

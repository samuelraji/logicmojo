package com.org.trees;

public class MaximumPathSum {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(-10);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);
        int maxPathSum = findMaxPathSum(root);
        System.out.println("maxPathSum :: "+ maxPathSum);
    }

    public static int maxi = Integer.MIN_VALUE;

    private static int findMaxPathSum(TreeNode root) {
        helper(root);
        return maxi;
    }

    private static int helper(TreeNode root) {
        if (root == null) return Integer.MIN_VALUE;
        int left = Math.max(0, helper(root.left));
        int right = Math.max(0, helper(root.right));
        maxi = Math.max(maxi, root.data + left + right);
        return root.data + Math.max(left, right);
    }

}

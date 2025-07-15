package com.org.binarysearchtree;

public class Practice {
    /*15
    10 20
    8 12 16 25*/
    public static void main(String[] args) {
        TreeNode root = new TreeNode(4);
        root.left = new TreeNode(2);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(3);
        root.right = new TreeNode(5);

        findSumofRangeNum(root);
    }

    private static void findSumofRangeNum(TreeNode root) {
        if (root == null) {
            return;
        }
        findSumofRangeNum(root.left);
        //root.data;
        findSumofRangeNum(root.right);
    }
}

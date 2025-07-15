package com.org.trees;

public class GivenPathExistInTheTree {

    /*
     5
   2   3
 1   4
    6  8
     */

    public static void main(String[] args) {
        TreeNode tree1 = new TreeNode(5);
        tree1.left = new TreeNode(2);
        tree1.left.left = new TreeNode(1);
        tree1.left.right = new TreeNode(4);
        tree1.left.right.left = new TreeNode(6);
        tree1.left.right.right = new TreeNode(8);
        tree1.right = new TreeNode(3);
        int[] arr = {5, 2 , 4, 8};
        boolean result = pathExist(tree1, arr, arr.length, 0);
        System.out.println("Are both mirroe images :: "+ result);
    }

    private static boolean pathExist(TreeNode tree1, int[] arr, int n, int currentIndex) {
        if (tree1 == null || currentIndex == n) return false;
        if (tree1 == null || currentIndex < n) return false;
        if (currentIndex == n && tree1 == null) return true;
        return arr[currentIndex] == tree1.data && (pathExist(tree1.left, arr, n, currentIndex+1)
                || pathExist(tree1.right, arr, n, currentIndex+1));
    }
}

package com.org.trees;

public class TwoNodesInSameSubtree {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(16);
        root.left = new TreeNode(26);
        root.left.left = new TreeNode(21);
        root.left.right = new TreeNode(80);
        root.right = new TreeNode(60);
        root.right.left = new TreeNode(8);
        boolean result = printCousins(root, 60, 26);
        System.out.println("Both are in same subtree :: " + result);
    }

    private static boolean printCousins(TreeNode root, int one, int two) {
        if (root == null) {
            return false;
        }
        boolean existLeftSide = findElement(root.left, one) && findElement(root.left, two);
        boolean existRightSide = findElement(root.right, one) && findElement(root.right, two);
        return existLeftSide || existRightSide;
    }

    private static boolean findElement(TreeNode node, int one) {
        if (node == null) {
            return false;
        }
        if (node.data == one) return true;
        boolean found1 = findElement(node.left, one);
        boolean found2 = findElement(node.right, one);
        return found1 || found2;
    }
}

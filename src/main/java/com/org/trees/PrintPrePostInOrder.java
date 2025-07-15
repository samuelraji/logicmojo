package com.org.trees;

public class PrintPrePostInOrder {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(16);
        root.left = new TreeNode(26);
        root.left.left = new TreeNode(21);
        root.left.right = new TreeNode(80);
        root.right = new TreeNode(60);
        root.right.left = new TreeNode(8);
        root.right.right = new TreeNode(50);
        System.out.println("Print Inorder");
        printInOrder(root);
        System.out.println();
        System.out.println("Print PreOrder");
        printPreOrder(root);
        System.out.println();
        System.out.println("Print PostOrder");
        printPostOrder(root);
    }

    private static void printPreOrder(TreeNode root) {
        if (root == null) {
            return;
        }
        System.out.print(root.data + " ");
        printPreOrder(root.left);
        printPreOrder(root.right);
    }

    private static void printInOrder(TreeNode root) {
        if (root == null) {
            return;
        }
        printInOrder(root.left);
        System.out.print(root.data + " ");
        printInOrder(root.right);
    }

    private static void printPostOrder(TreeNode root) {
        if (root == null) {
            return;
        }
        printPostOrder(root.left);
        printPostOrder(root.right);
        System.out.print(root.data + " ");
    }
}

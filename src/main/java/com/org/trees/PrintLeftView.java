package com.org.trees;

import java.util.LinkedList;
import java.util.Queue;

public class PrintLeftView {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(4);
        root.left = new TreeNode(5);
        root.right = new TreeNode(2);
        root.right.left = new TreeNode(3);
        root.right.right = new TreeNode(1);
        root.right.left.left = new TreeNode(6);
        root.right.left.right = new TreeNode(7);
        printLeftView(root);
    }

    private static void printLeftView(TreeNode root) {
        if (root == null) {
            return;
        }
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        while (!q.isEmpty()) {
            int size = q.size();
            for (int i=0;i<size;i++) {
                TreeNode current = q.poll();
                if (i==0) System.out.print(current.data+" ");
                if (current.left != null) q.add(current.left);
                if (current.right != null) q.add(current.right);
            }
        }
    }
}

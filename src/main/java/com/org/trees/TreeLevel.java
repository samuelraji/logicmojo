package com.org.trees;

import java.util.LinkedList;
import java.util.Queue;

public class TreeLevel {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(170);
        root.left = new TreeNode(200);
        root.left.left = new TreeNode(18);
        root.left.left.right = new TreeNode(16);
        root.right = new TreeNode(10);
        root.right.left = new TreeNode(29);
        root.right.left.left = new TreeNode(20);
        System.out.println(getLevelofTree(root));
    }

    private static int getLevelofTree(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int level = -1;
        Queue<TreeNode> q = new LinkedList<TreeNode>();
        q.add(root);
        while (!q.isEmpty()) {
            int size = q.size();
            for (int i=0;i<size;i++) {
                TreeNode front = q.poll();
                System.out.print(front.data+ " ");
                if (front.left != null) q.add(front.left);
                if (front.right != null) q.add(front.right);
            }
            level++;
        }
        System.out.println();
        return level;
    }
}

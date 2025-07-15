package com.org.trees;

import java.util.*;

public class ZigZagTreeLevel {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.left.left = new TreeNode(7);
        root.left.right = new TreeNode(6);
        root.right = new TreeNode(3);
        root.right.left = new TreeNode(5);
        root.right.right = new TreeNode(4);
        System.out.println(getLevelofTree(root));
    }

    private static List<List<Integer>> getLevelofTree(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        int level = -1;
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        while (!q.isEmpty()) {
            int size = q.size();
            List<Integer> levelElements = new ArrayList();
            for (int i=0;i<size;i++) {
                TreeNode front = q.poll();
                levelElements.add(front.data);
                System.out.print(front.data+ " ");
                if (front.left != null) q.add(front.left);
                if (front.right != null) q.add(front.right);
            }
            level++;
            if (level % 2 != 0) {
                Collections.reverse(levelElements);
            }
            result.add(levelElements);
        }
        return result;
    }
}

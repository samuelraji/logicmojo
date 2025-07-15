package com.org.trees;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class PrintCousinsofNode {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(16);
        root.left = new TreeNode(26);
        root.left.left = new TreeNode(21);
        root.left.right = new TreeNode(80);
        root.right = new TreeNode(60);
        root.right.left = new TreeNode(8);
        List<Integer> result = printCousins(root, 80);
        result.forEach(ele -> System.out.println(" "+ele));
    }

    private static List<Integer> printCousins(TreeNode root, int find) {
        if (root == null || root.data == find) {
            return null;
        }
        List<Integer> result = new ArrayList<>();
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        while (!q.isEmpty()) {
            int size = q.size();
            for (int i=0;i<size;i++) {
                TreeNode ele = q.poll();
                if (ele.left != null) {
                    q.add(ele.left);
                }
                if (ele.right != null) {
                    q.add(ele.right);
                }
            }
        }

        return result;
    }
}

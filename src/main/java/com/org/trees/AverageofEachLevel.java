package com.org.trees;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class AverageofEachLevel {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.left.left = new TreeNode(15);
        root.left.right = new TreeNode(7);
        root.right = new TreeNode(20);
        List<String> result = getLevelofTree(root);
        result.forEach(str -> System.out.print(str + " "));
    }

    private static List<String> getLevelofTree(TreeNode root) {
        if (root == null) {
            return null;
        }
        List<String> list = new ArrayList<>();
        Queue<TreeNode> q = new LinkedList<TreeNode>();
        q.add(root);
        while (!q.isEmpty()) {
            int size = q.size();
            int levelTotal = 0;
            int noOfElements = 0;
            for (int i=0;i<size;i++) {
                TreeNode front = q.poll();
                levelTotal += front.data;
                noOfElements++;
                if (front.left != null) q.add(front.left);
                if (front.right != null) q.add(front.right);
            }
            double average = levelTotal/(double)noOfElements;
            list.add(average+"0000");
        }
        return list;
    }
}

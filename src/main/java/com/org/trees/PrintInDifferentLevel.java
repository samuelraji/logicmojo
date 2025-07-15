package com.org.trees;

import java.util.*;

class TNode {
    TreeNode treeNode;
    int level;

    public TNode(TreeNode treeNode, int level) {
        this.treeNode = treeNode;
        this.level = level;
    }
}

public class PrintInDifferentLevel {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(8);
        root.left = new TreeNode(3);
        root.left.left = new TreeNode(1);
        root.right = new TreeNode(10);
        root.right.left = new TreeNode(6);
        root.right.left.left = new TreeNode(4);
        root.right.left.right = new TreeNode(7);
        root.right.right = new TreeNode(14);
        root.right.right.left = new TreeNode(13);
        Map<Integer, List<Integer>> result = printInSlopeMinusOneLevel(root);
        for (Map.Entry<Integer, List<Integer>> entry: result.entrySet()) {
            entry.getValue().forEach(val -> System.out.print(val+" "));
            System.out.println();
        }
    }

    private static Map<Integer, List<Integer>> printInSlopeMinusOneLevel(TreeNode root) {
        if (root == null) {
            return null;
        }
        Map<Integer, List<Integer>> map = new TreeMap<>();
        Queue<TNode> q = new LinkedList<>();
        q.add(new TNode(root, 0));
        while (!q.isEmpty()) {
            TNode tNode = q.poll();
            map.putIfAbsent(tNode.level, new ArrayList<>());
            map.get(tNode.level).add(tNode.treeNode.data);
            if (tNode.treeNode.left != null) {
                q.add(new TNode(tNode.treeNode.left, tNode.level+1));
            }
            if (tNode.treeNode.right != null) {
                q.add(new TNode(tNode.treeNode.right, tNode.level));
            }
        }
        return map;
    }
}

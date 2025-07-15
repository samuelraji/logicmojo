package com.org.trees;

import java.util.LinkedList;
import java.util.Queue;

public class CousinsOfGivenNode {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(16);
        root.left = new TreeNode(26);
        root.left.left = new TreeNode(21);
        root.left.right = new TreeNode(80);
        root.right = new TreeNode(60);
        root.right.left = new TreeNode(8);
        root.right.right = new TreeNode(19);
        printCousins(root, root.left.right);
    }

    private static void printCousins(TreeNode root, TreeNode node_to_find) {
        if (root ==  null) {
            System.out.println("No Cousins Found");
            return;
        }
        Queue<TreeNode> q = new LinkedList<>();
        boolean found = false;
        TreeNode p = null;
        int size_ = 0;
        q.add(root);
        while (!q.isEmpty() && !found) {
            int size = q.size();
            for (int i=0;i<size;i++) {
                TreeNode node = q.poll();
                if((node.left == node_to_find ||
                        node.right == node_to_find)) {
                    found = true;
                } else {
                    if(node.left != null) q.add(node.left);
                    if(node.right!= null) q.add(node.right);
                }
            }
        }
        if(found == true)
        {
            System.out.print("Cousin Nodes : ");
            size_ = q.size();
            if(size_ == 0)
                System.out.print("None");
            for(int i = 0; i< size_; i++) {
                p = q.peek();
                q.poll();
                System.out.print(p.data + " ");
            }
        } else {
            System.out.print("Node not found");
        }
        System.out.println("");
    }
}
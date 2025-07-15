package com.org.trees;

import java.util.LinkedList;
import java.util.Queue;

class TreeNodeNext {
    int data;
    TreeNodeNext left;
    TreeNodeNext right;
    TreeNodeNext next;
    public TreeNodeNext(int data) {
        this.data = data;
        this.left = null;
        this.right = null;
        this.next = null;
    }
}

public class PointToNextPointer {
    public static void main(String[] args) {
        TreeNodeNext root = new TreeNodeNext(3);
        root.left = new TreeNodeNext(2);
        root.left.left = new TreeNodeNext(4);
        root.left.right = new TreeNodeNext(5);
        root.right = new TreeNodeNext(3);
        root.right.right = new TreeNodeNext(7);
        getLevelofTree(root);
    }

    private static void getLevelofTree(TreeNodeNext root) {
        if (root == null) {
            return;
        }
        Queue<TreeNodeNext> q = new LinkedList<TreeNodeNext>();
        q.add(root);
        while (!q.isEmpty()) {
            int size = q.size();
            for (int i=0;i<size;i++) {
                TreeNodeNext front = q.poll();
                if (i < size-1) {
                    front.next = q.peek();
                }
                if (front.left != null) q.add(front.left);
                if (front.right != null) q.add(front.right);
            }
        }
    }
}

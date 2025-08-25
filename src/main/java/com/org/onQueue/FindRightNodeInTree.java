package com.org.onQueue;

import java.util.LinkedList;
import java.util.Queue;

class Node {
    int data;
    Node left;
    Node right;
    Node(int data) {
        this.data = data;
        this.left = null;
        this.right = null;
    }
}

public class FindRightNodeInTree {
    public static void main(String[] args) {
        Node head = new Node(10);
        head.left = new Node(20);
        head.right = new Node(30);
        head.left.left = new Node(15);
        head.left.right = new Node(25);
        head.right.left = new Node(35);
        head.right.right = new Node(45);
        int key = 45;

        Queue<Node> queue = new LinkedList<>();
        queue.add(head);
        boolean found = false;
        while (!queue.isEmpty()) {
            int size = queue.size();
            int i = 0;
            found = false;
            while (i++ < size) {
                Node curr = queue.poll();
                if (found) {
                    System.out.println("Next Element is :: " + curr.data);
                    break;
                }
                if (curr.data == key) found = true;
                if (curr.left != null) queue.add(curr.left);
                if (curr.right != null) queue.add(curr.right);
            }
            if (found) break;
        }
    }
}

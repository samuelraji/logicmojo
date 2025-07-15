package com.org.binarysearchtree;

import java.util.ArrayList;
import java.util.List;

public class SuccessorOfGivenNum {
    /*15
    10 20
    8 12 16 25*/
    public static void main(String[] args) {
        TreeNode root = new TreeNode(15);
        root.left = new TreeNode(10);
        root.left.left = new TreeNode(8);
        root.left.right = new TreeNode(12);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(16);
        root.right.right = new TreeNode(25);
        List<Integer> result = new ArrayList<>();
        int num=12;
        findSuccessor(root, result);
        for (int i=0;i<result.size();i++) {
            if (result.get(i) == num) {
                if (result.size()-1 >= i+1) {
                    System.out.println("The Successor is :: "+ result.get(i+1));
                }
            }
        }
    }

    private static void findSuccessor(TreeNode root, List<Integer> result) {
        if (root == null) {
            return;
        }
        findSuccessor(root.left, result);
        result.add(root.data);
        findSuccessor(root.right, result);
    }
}

package com.org.onHeap;

class  TNode {
    int value;
    TNode left;
    TNode right;

    public TNode(int value) {
        this.value = value;
        this.left = null;
        this.right = null;
    }
}

public class CheckMinHeap {
    public static void main(String[] args) {
        TNode tNode = new TNode(2);
        tNode.left = new TNode(3);
        tNode.right = new TNode(4);
        tNode.left.left = new TNode(5);
        tNode.right.left = new TNode(8);
        tNode.left.right = new TNode(6);
        tNode.right.right = new TNode(10);
        System.out.println(isHeap(tNode));
    }
    private static boolean checkHeap(TNode root,int i,int n)
    {
        // base case
        if(root == null){
            return true;
        }
        // not complete binary tree: out of valid index range
        if(i>= n){
            return false;
        }
        // current node has a higher value than its left or right child
        if((root.left != null && root.left.value <= root.value) ||
                (root.right != null && root.right.value <= root.value)){
            return false;
        }
        // check for left and right subtree
        return checkHeap(root.left,2*i + 1,n)&&
                checkHeap(root.right,2*i + 2,n);
    }

    public static boolean isHeap(TNode root) {
        int i = 0;
        return checkHeap(root, i, size(root));
    }

    private static int size(TNode root) {
        if(root == null){
            return 0;
        }
        return 1 + size(root.left) + size(root.right);
    }

}

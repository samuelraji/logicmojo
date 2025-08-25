package com.org.onHeap;

public class PracticeCheckMinHeap {
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

    private static boolean isHeap(TNode tNode) {
        return checkMinHeap(tNode, 0, size(tNode));
    }

    private static boolean checkMinHeap(TNode tNode, int i, int size) {
        if (tNode == null) {
            return true;
        }
        if (i >= size) {
            return false;
        }
        if ((tNode.left != null && tNode.left.value <= tNode.value)
                ||(tNode.right != null && tNode.right.value <= tNode.value)) {
            return false;
        }
        return checkMinHeap(tNode.left, 2*i+1, size) && checkMinHeap(tNode.right, 2*i+2, size);
    }

    private static int size(TNode tNode) {
        if (tNode == null) {
            return 0;
        }
        return 1+size(tNode.left)+size(tNode.right);
    }
}

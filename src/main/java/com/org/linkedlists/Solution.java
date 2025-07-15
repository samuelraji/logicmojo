package com.org.linkedlists;

public class Solution {
    public static void main(String[] args) {
        Node head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        head.next.next.next = new Node(4);
        head.next.next.next.next = new Node(5);
        head.next.next.next.next.next = new Node(6);
        head.next.next.next.next.next.next = new Node(7);
        head.next.next.next.next.next.next.next = new Node(8);
        int k = 3;
        Node reversed = reversedEveryKlength(head, k);
        while (reversed != null) {
            System.out.print(" "+ reversed.data);
            reversed = reversed.next;
        }
    }
    private static Node reversedEveryKlength(Node head, int k) {
        if (head == null || head.next == null) {
            return head;
        }
        Node result = reversed(head, k);
        return head;
    }

    private static Node reversed(Node head, int k) {
        Node curr = head;
        Node prev = null;
        Node dummy = null;
        for (int i=0;i<k;i++) {
            Node temp = curr.next;

            curr = curr.next;
        }
        return null;
    }
}

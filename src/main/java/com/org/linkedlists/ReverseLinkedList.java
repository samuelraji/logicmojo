package com.org.linkedlists;

public class ReverseLinkedList {
    public static void main(String[] args) {
        Node head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        head.next.next.next = new Node(4);
        head.next.next.next.next = new Node(5);
        Node reversed = reverseList(head);
        while (reversed != null) {
            System.out.print(reversed.data + " ");
            reversed = reversed.next;
        }
    }

    private static Node reverseList(Node head) {
        if (head == null || head.next == null) {
            return head;
        }
        Node prev = null;
        Node cur = head;
        while (cur != null) {
            Node next = cur.next;
            cur.next = prev;
            prev = cur;
            cur = next;
        }
        return prev;
    }
}

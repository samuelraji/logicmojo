package com.org.linkedlists;

public class RemoveDuplicates {
    public static void main(String[] args) {
        Node head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(2);
        head.next.next.next = new Node(2);
        head.next.next.next.next = new Node(5);
        head.next.next.next.next.next = new Node(6);
        head.next.next.next.next.next.next = new Node(6);
        Node reversed = removeDuplicates(head);
        while (reversed != null) {
            System.out.print(reversed.data + " ");
            reversed = reversed.next;
        }
    }
    private static Node removeDuplicates(Node head) {
        if (head == null || head.next == null) {
            return head;
        }
        Node prev = head;
        Node curr = head;
        Node next = head.next;
        while (curr != null) {
            if (prev.data == next.data) {
                prev.next = next.next;
                next = prev.next;
            } else {
                prev = next;
                next = prev.next;
            }
            curr = curr.next;
        }
        return head;
    }
}

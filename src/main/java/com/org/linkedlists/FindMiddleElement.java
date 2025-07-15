package com.org.linkedlists;

public class FindMiddleElement {
    public static void main(String[] args) {
        Node head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(2);
        head.next.next.next = new Node(2);
        head.next.next.next.next = new Node(5);
        head.next.next.next.next.next = new Node(6);
        head.next.next.next.next.next.next = new Node(6);
        head.next.next.next.next.next.next.next = new Node(7);
        head.next.next.next.next.next.next.next.next = new Node(8);
        Node middle = findMiddleElement(head);
        System.out.print(middle.data + " ");
    }
    private static Node findMiddleElement(Node head) {
        if (head == null || head.next == null) {
            return head;
        }
        Node oneStep = head.next;
        Node twoStep = head.next.next;
        while (twoStep != null && twoStep.next != null) {
            oneStep = oneStep.next;
            twoStep = twoStep.next.next;
        }
        return oneStep;
    }
}

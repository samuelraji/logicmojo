package com.org.linkedlists;

public class AddOneTo1999 {
    public static void main(String[] args) {
        Node root = new Node(1);
        root.next = new Node(9);
        root.next.next = new Node(9);
        root.next.next.next = new Node(9);
        Node current = addOnetoTheList(root);
        while (current != null) {
            System.out.println(current.data + " ");
            current = current.next;
        }
    }

    private static Node addOnetoTheList(Node root) {
        if (root == null) {
            return null;
        }
        Node node = reverseList(root);
        int carry = 0;
        Node current = node;
        /*while (current != null) {
            current.data
            current = current.next;
        }*/
        return node;
    }
// 1->2
    private static Node reverseList(Node root) {
        Node current = root;
        Node prev = null;
        while (current != null) {
            Node next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }
        return prev;
    }
}

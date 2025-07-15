package com.org.linkedlists;

public class FindInterSectionOfLinkedlists {
    public static void main(String[] args) {
        Node headA = new Node(1);
        headA.next = new Node(2);
        headA.next.next = new Node(3);
        headA.next.next.next = new Node(4);

        Node headB = new Node(1);
        headB.next = new Node(2);

        Node junction = new Node(5);
        junction.next = new Node(6);
        junction.next.next = new Node(6);
        junction.next.next.next = new Node(7);
        junction.next.next.next.next = new Node(8);

        headA.next.next.next.next = junction;
        headB.next.next = junction;

        Node interSection = findInterSection(headA, headB);
        System.out.print(interSection.data);
    }
    private static Node findInterSection(Node headA, Node headB) {
        if (headA == null || headA.next == null) {
            return null;
        }
        int countA = 0, countB = 0;
        Node temp1 = headA;
        while (temp1 != null) {
            countA++;
            temp1 = temp1.next;
        }
        Node temp2 = headB;
        while (temp2 != null) {
            countB++;
            temp2 = temp2.next;
        }
        temp1 = headA;
        temp2 = headB;
        if (countA > countB) {
            for (int i=0; i<countA-countB;i++) {
                temp1 = temp1.next;
            }
        } else {
            for (int i=0; i<countB-countA;i++) {
                temp2 = temp2.next;
            }
        }
        Node junction = null;
        while (temp1 != null) {
            if (temp1 == temp2) {
                junction = temp1;
                break;
            }
            temp1 = temp1.next;
            temp2 = temp2.next;
        }
        return junction;
    }
}

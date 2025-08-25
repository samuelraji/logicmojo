package com.org.onQueue;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

class NodeChild {
    int data;
    NodeChild next;
    NodeChild child;
    NodeChild(int data) {
        this.data = data;
        this.next = null;
        this.child = null;
    }
}
public class LLWithChildAndNext {
    public static void main(String[] args) {
        NodeChild head = new NodeChild(10);
        head.child =  new NodeChild(4);
        head.child.next =  new NodeChild(20);
        head.child.next.next =  new NodeChild(13);
        head.child.next.next.child =  new NodeChild(16);
        head.child.next.next.child.child =  new NodeChild(3);
        head.child.next.child =  new NodeChild(2);
        head.next =  new NodeChild(5);
        head.next.next =  new NodeChild(12);
        head.next.next.child =  new NodeChild(17);
        head.next.next.child.next =  new NodeChild(6);
        head.next.next.child.child =  new NodeChild(9);
        head.next.next.child.child.next =  new NodeChild(8);
        head.next.next.child.child.child =  new NodeChild(19);
        head.next.next.child.child.child.next =  new NodeChild(15);
        head.next.next.next =  new NodeChild(11);

        Queue<NodeChild> queue = new LinkedList<>();
        Set<NodeChild> visited = new HashSet<>();
        queue.add(head);
        NodeChild curr = head;
        NodeChild prev = null;
        while (curr != null) {
            if (visited.contains(curr)) {
                break; // or continue to avoid cycles
            }
            visited.add(curr);
            System.out.print(curr.data + " ");
            if (curr.child != null && !visited.contains(curr.child)) {
                queue.add(curr.child);
            }
            if (curr.next == null && !visited.contains(curr.next)) {
                queue.add(curr.child);
            }
            if (prev != null) {
                prev.next = curr;
            }

            prev = curr;
            curr = queue.poll();
        }
    }

}

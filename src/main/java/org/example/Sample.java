package org.example;

import java.util.Hashtable;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;

class Node1 {
    int data;
    Node1 left, right;
    public Node1() {}
    public Node1(int item) {
        this.data = item;
        this.left = this.right = null;
    }
}

class BinarySearchTree1 {
    Node1 root;
    public BinarySearchTree1() {}
    void insert(int item) {
        root = insertRec(root, item);
    }

    private Node1 insertRec(Node1 node, int data) {
        if (node == null) {
            node = new Node1(data);
            return node;
        }
        if (data < node.data) {
            node.left = insertRec(node.left, data);
        } else if (data > node.data) {
            node.right = insertRec(node.right, data);
        }
        return node;
    }

    void inorder() {
        inorderRec(root);
    }

    // Recursive method to perform in-order traversal
    void inorderRec(Node1 node) {
        if (node != null) {
            inorderRec(node.right);
            System.out.print(node.data + " ");
            inorderRec(node.left);
        }
    }

    void preorder() {
        preorderRec(root);
    }

    // Recursive method to perform in-order traversal
    void preorderRec(Node1 node) {
        if (node != null) {
            System.out.print(node.data + " ");
            inorderRec(node.right);
            inorderRec(node.left);
        }
    }

    void postorder() {
        postorderRec(root);
    }

    // Recursive method to perform in-order traversal
    void postorderRec(Node1 node) {
        if (node != null) {
            inorderRec(node.left);
            inorderRec(node.right);
            System.out.print(node.data + " ");
        }
    }
}

public class Sample {
    public static void main(String[] args) {
        BinarySearchTree1 bst = new BinarySearchTree1();
        bst.insert(50);
        bst.insert(30);
        bst.insert(20);
        bst.insert(40);
        bst.insert(70);
        bst.insert(60);
        bst.insert(80);

        /*System.out.println("In-order traversal of the BST:");
        bst.inorder();
        System.out.println("\nPre-order traversal of the BST:");
        bst.preorder();
        System.out.println("\nPost-order traversal of the BST:");
        bst.postorder();*/

        Map<String, String> map = new ConcurrentHashMap<>();
        map.put("A", "Apple");
        map.put("B", "Banana");

        Iterator<Map.Entry<String, String>> iterator = map.entrySet().iterator();
        while (iterator.hasNext()) {
            Map.Entry<String, String> entry = iterator.next();
            map.put("C", "Cherry");  // Safe, no ConcurrentModificationException
        }

        List<String> list = new CopyOnWriteArrayList<>();
        list.add("A");
        list.add("B");

        Iterator<String> iterator2 = list.iterator();
        while (iterator2.hasNext()) {
            String element = iterator2.next();
            list.add("C");  // Safe, no ConcurrentModificationException
        }


        Hashtable<String, String> table = new Hashtable<>();
        table.put("key1", "value1");
        table.put("key2", "value2");
        table.put("key3", "value3");

        // Using Iterator to iterate over keys
        Iterator<String> iterator3 = table.keySet().iterator();
        while (iterator3.hasNext()) {
            String key = iterator3.next();
            System.out.println("Key: " + key);
            table.put("jf", "fdsfs");
        }
    }
}

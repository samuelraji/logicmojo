package com.org.onQueue;

import java.util.Scanner;
import java.util.Stack;

public class QueueUsingStack {
    Stack<Integer> stack = new Stack<>();
    Stack<Integer> auxStack = new Stack<>();
    public void push(Integer val) {
        while(!stack.isEmpty()) {
            auxStack.push(stack.pop());
        }
        stack.push(val);
    }
    public Integer pop() {
        while(!auxStack.isEmpty()) {
            stack.push(auxStack.pop());
        }
        return stack.pop();
    }
    public Integer peek() {
        while(!auxStack.isEmpty()) {
            stack.push(auxStack.pop());
        }
        return stack.peek();
    }
    public boolean isEmpty() {
        return stack.isEmpty() && auxStack.isEmpty();
    }

    public void print() {
        System.out.println("Stack elements:");
        for (Integer item : stack) {
            System.out.print(item + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        QueueUsingStack queue = new QueueUsingStack();
        Scanner scanner = new Scanner(System.in);
        Integer n = scanner.nextInt();
        for (int i=0; i<n; i++) {
            queue.push(scanner.nextInt());
        }
        queue.print();
        System.out.println("pop first element :: "+ queue.pop());
        queue.print();
        System.out.println("pop second element :: "+ queue.pop());
        queue.print();
    }
}

package com.org.onStack;

import java.util.Stack;

public class MinimumValueStack {
    Stack<Integer> stack = new Stack<>();
    Stack<Integer> auxStack = new Stack<>();
    //push
    //pop
    public int size() {
        return stack.size();
    }
    public boolean isEmpty() {
        return stack.size() == 0;
    }
    public int peek() {
        return stack.peek();
    }
    public int minValue() {
        return (auxStack.size() == 0)? -1: auxStack.peek();
    }
    public void push(Integer val) {
        if (auxStack.isEmpty()) auxStack.push(val);
        else if (auxStack.peek() > val) auxStack.push(val);
        stack.push(val);
    }
    public void pop() {
        if (stack.isEmpty()) return;
        Integer ele = stack.pop();
        if (auxStack.peek() == ele) {
            auxStack.pop();
        }
    }

    public static void main(String[] args) {
        MinimumValueStack minStack = new MinimumValueStack();
        //20 8 25 100 5 23 1
        minStack.push(20);
        //System.out.println(minStack.minValue());

        minStack.push(8);
        //System.out.println(minStack.minValue());

        minStack.push(25);
        //System.out.println(minStack.minValue());

        minStack.push(100);
        //System.out.println(minStack.minValue());

        minStack.push(5);
        //System.out.println(minStack.minValue());

        minStack.push(23);
        //System.out.println(minStack.minValue());

        minStack.push(1);
        //System.out.println(minStack.minValue());

        minStack.pop();
        System.out.println(minStack.minValue());
        minStack.pop();
        System.out.println(minStack.minValue());
        minStack.pop();
        System.out.println(minStack.minValue());
    }
}

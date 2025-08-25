package com.org.onStack;

import java.util.Stack;

public class EvaluateExpression {
    public static void main(String[] args) {
        String str = "545*+5/";
        Stack<Integer> stackNum = new Stack<>();
        Stack<Character> stackChar = new Stack<>();
        int idx = 0;
        int n = str.length();
        while (idx<n) {
            Character ch = str.charAt(idx++);
            if (Character.isDigit(ch)) {
                stackNum.push(ch-'0');
            } else {
                if (stackNum.isEmpty()) {
                    stackChar.push(ch);
                } else {
                    int num1 = stackNum.pop();
                    int num2 = stackNum.pop();
                    int res = evaluate(num2, num1, ch);
                    stackNum.push(res);
                }
            }
        }
        System.out.println(stackNum);
    }

    private static int evaluate(int num1, int num2, Character ch) {
        switch (ch) {
            case '+': return num1+num2;
            case '-': return num1-num2;
            case '*': return num1*num2;
            case '/': return num1/num2;
        }
        return 0;
    }
}

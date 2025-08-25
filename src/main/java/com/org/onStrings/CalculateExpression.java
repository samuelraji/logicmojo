package com.org.onStrings;

import java.util.Stack;

public class CalculateExpression {
    public static void main(String[] args) {
        String s = " 3+5 / 2 ";
        System.out.println(calculate(s));
    }

    public static int calculate(String s) {
        Stack<Integer> operands = new Stack<>();
        Stack<Character> operators = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (Character.isDigit(c)) {
                int num = 0;
                while (i < s.length() && Character.isDigit(s.charAt(i))) {
                    num = num * 10 + (s.charAt(i) - '0');
                    i++;
                }
                i--; // Decrement to account for the extra increment in the loop
                operands.push(num);
            } else if (c == '+' || c == '-' || c == '*' || c == '/') {
                while (!operators.isEmpty() && hasHigherPrecedence(operators.peek(), c)) {
                    char operator = operators.pop();
                    int rightOperand = operands.pop();
                    int leftOperand = operands.pop();
                    operands.push(performOperation(leftOperand, rightOperand, operator));
                }
                operators.push(c);
            }
        }
        while (!operators.isEmpty()) {
            char operator = operators.pop();
            int rightOperand = operands.pop();
            int leftOperand = operands.pop();
            operands.push(performOperation(leftOperand, rightOperand, operator));
        }
        return operands.pop();
    }

    private static boolean hasHigherPrecedence(char op1, char op2) {
        return (op1 == '*' || op1 == '/') && (op2 == '+' || op2 == '-');
    }

    private static int performOperation(int leftOperand, int rightOperand, char operator) {
        switch (operator) {
            case '+':
                return leftOperand + rightOperand;
            case '-':
                return leftOperand - rightOperand;
            case '*':
                return leftOperand * rightOperand;
            case '/':
                if (rightOperand == 0) {
                    throw new ArithmeticException("Division by zero is not allowed.");
                }
                return leftOperand / rightOperand;
        }
        return leftOperand;
    }
}

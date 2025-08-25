package com.org.onStack;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Stack;

public class NextGreaterElement {
    public static void main(String[] args) {
        /*  Input: arr[] = [4,5,2,25]
            Output: 4->5, 5->25, 2->25, 25-> -1 */
        int[] arr = {4,5,2,25};
        int[] result = nextGreaterElement(arr);
        for (int i=0; i<arr.length; i++) {
            System.out.print(arr[i]+"->"+result[i] + " ");
        }
    }

    private static int[] nextGreaterElement(int[] input) {
        if (input == null) {
            return input;
        }
        int[] result = new int[input.length];
        Arrays.fill(result, -1);
        Stack<Integer> s = new Stack<>();
        for (int i = 0; i < input.length; i++) {
            while(!s.isEmpty()&&input[s.peek()]<input[i]){
                result[s.pop()] = input[i];
            }
            s.push(i);
        }
        return result;
    }
}

package com.org.onStack;

import java.util.Stack;

public class EncodedStrKTimes {
    public static void main(String[] args) {
        String str = "3[a]2[bc]";
        System.out.println(decodeString(str));
    }
    public static String decodeString(String str) {
        String res = "";
        Stack<Integer> stackCount = new Stack<>();
        Stack<String> resStack = new Stack<>();
        int idx = 0;
        int n = str.length();
        while (idx < n) { //"13[a]2[b3[c]]"
            if (Character.isDigit(str.charAt(idx))) {
                int count = 0;
                while (Character.isDigit(str.charAt(idx))) {
                    count = 10 * count + (str.charAt(idx) - '0');
                    idx++;
                }
                stackCount.push(count);
            } else if (str.charAt(idx) == '[') {
                resStack.push(res);
                res = "";
                idx++;
            } else if (str.charAt(idx) == ']') {
                StringBuilder temp = new StringBuilder (resStack.pop());
                int num = stackCount.pop();
                for (int k=0; k<num; k++) {
                    temp.append(res);
                }
                res = temp.toString();
                idx++;
            } else {
                res+=str.charAt(idx);
                idx++;
            }
        }
        return res;
    }

}

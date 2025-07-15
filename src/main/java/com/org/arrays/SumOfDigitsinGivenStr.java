package com.org.arrays;

public class SumOfDigitsinGivenStr {

    public int everyLetterOccurs(String str) {
        char[] chars= str.toCharArray();
        boolean containsT = false;
        int sum = 0;
        for (char ch: chars) {
            if (ch == 't') {
                containsT = true;
            }
            if (Character.isDigit(ch)) {
                sum += ch-'0';
            }
        }
        return containsT? sum: 0;
    }

    public static void main(String[] args) {
        SumOfDigitsinGivenStr p = new SumOfDigitsinGivenStr();
        System.out.println(p.everyLetterOccurs("thag14"));
    }
}

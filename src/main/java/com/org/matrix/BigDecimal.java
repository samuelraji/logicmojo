package com.org.matrix;

import java.math.RoundingMode;
import java.util.Scanner;

public class BigDecimal {
    public static void main(String[] args) {
        Scanner sn = new Scanner(System.in);
        System.out.print("Enter size of the array :: ");
        int size = sn.nextInt();
        java.math.BigDecimal sum = java.math.BigDecimal.ZERO;
        java.math.BigDecimal[] arr = new java.math.BigDecimal[size];
        System.out.print("Enter " +size+ " Elements space separated : ");
        for (int i=0; i<size; i++) {
            java.math.BigDecimal num = new java.math.BigDecimal(sn.next());
            sum = sum.add(num);
            arr[i] = num;
        }
        java.math.BigDecimal mean = sum.divide(java.math.BigDecimal.valueOf(size), 2, RoundingMode.HALF_UP);
        System.out.println("Mean is :: "+ mean);
        sn.close();
    }
}

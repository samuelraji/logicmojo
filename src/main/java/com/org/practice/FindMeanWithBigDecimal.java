package com.org.practice;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Scanner;

public class FindMeanWithBigDecimal {
    public static void main(String[] args) {
        Scanner sn = new Scanner(System.in);
        System.out.print("Enter size of the array :: ");
        int size = sn.nextInt();
        BigDecimal sum = BigDecimal.ZERO;
        BigDecimal[] arr = new BigDecimal[size];
        System.out.print("Enter " +size+ " Elements space separated : ");
        for (int i=0; i<size; i++) {
            BigDecimal num = new BigDecimal(sn.next());
            sum = sum.add(num);
            arr[i] = num;
        }
        BigDecimal mean = sum.divide(BigDecimal.valueOf(size), 2, RoundingMode.HALF_UP);
        System.out.println("Mean is :: "+ mean);
        sn.close();
    }
}

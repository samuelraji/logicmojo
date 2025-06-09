package com.org.arrays;

public class TwoArrSort {
    public static void main(String[] args) {
        int x[] = {1, 4, 7, 8, 10};
        int y[] = {2, 3 ,9};
        // OUTPUT
        // X => 1 2 3 4 7
        // Y => 8 9 10
        for (int i=0;i<x.length;i++) {
            if (x[i] > y[0]) {
                int temp = x[i];
                x[i] = y[0];
                y[0] = temp;
                int first = y[0];
                int k;
                for (k=1;k<y.length && y[k] < first;k++) {
                    y[k-1] = y[k];
                }
                y[k-1] = first;
            }
        }
        System.out.println();
        for (int num : x) {
            System.out.print(num + " ");
        }
        System.out.println();
        for (int num : y) {
            System.out.print(num + " ");
        }

    }
}

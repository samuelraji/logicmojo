package com.org.arrays;

public class ArrManipulation {

    public static void main(String[] args) {
        int arr[]={10,23,0,53,0,21,0};
        int k=0;
        for (int i=0; i<arr.length; i++) {
            if (arr[i] != 0) {
                arr[k] = arr[i];
                k++;
            }
        }
        for (int i=0; i<k; i++) {
            System.out.println(arr[i]);
        }
    }
}

package com.org.arrays;

public class SortZerosOnesTwos {
    public static void main(String[] args) {
        int arr[] = {2,2,0,0,1,1,2,0,0,2,1};
        sortArr(arr, arr.length);
        for (int num:arr) {
            System.out.print(num + " ");
        }
    }
    private static void sortArr(int[] arr, int length) {
        int start=0, mid=0,end=length-1, pivot=1;
        while(mid <= end) {
            if (arr[mid] > pivot) {
                swap(arr, mid, end);
                end--;
            } else if (arr[mid] < pivot) {
                swap(arr, start, mid);
                mid++;
                start++;
            } else {
                mid++;
            }
        }
    }

    private static void swap(int[] arr, int mid, int end) {
        int temp = arr[mid];
        arr[mid] = arr[end];
        arr[end] = temp;
    }
}

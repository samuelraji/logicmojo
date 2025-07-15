package com.org.matrix;

public class SearchSortedMatrix {
    public static void main(String[] args) {
        int[][] mat = {{10,20,30,40},
                       {15,25,35,45},
                       {27,29,37,48},
                       {32,33,39,50}};

        matSearch(mat, 29);
    }

    public static void matSearch(int mat[][], int x) {
        int first=0;
        int second=mat[0].length-1;
        int p1=-1,p2=-1;
        while(first>=0 && first <mat.length && second>=0 && second<mat[0].length) {
            if(x == mat[first][second]) {
                p1=first;
                p2=second;
                break;
            }
            if(x<mat[first][second]) {
                second = second-1;
            } else {
                first = first+1;
            }
        }
        if (p1 != -1) {
            System.out.println("Element found at " + p1 +" "+ p2);
        } else {
            System.out.println("Element not found");
        }
    }
}

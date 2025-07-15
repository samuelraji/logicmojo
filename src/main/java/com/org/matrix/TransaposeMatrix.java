package com.org.matrix;

public class TransaposeMatrix {
    public static void main(String[] args) {
        int[][] mat = {{10,20,30,40},
                       {15,25,35,45},
                       {27,29,37,48},
                       {32,33,39,50}};

        transposeMatrix(mat);
        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[i].length; j++) {
                System.out.print(mat[i][j] + "\t");  // Use \t for tab spacing
            }
            System.out.println(); // Move to next line after each row
        }
    }

    public static void transposeMatrix(int mat[][]) {
        int n=mat.length;
        for (int i=0;i<n;i++) {
            for (int j=i;j<mat[0].length;j++) {
                int temp = mat[i][j];
                mat[i][j] = mat[j][i];
                mat[j][i] = temp;
            }
        }
    }
}

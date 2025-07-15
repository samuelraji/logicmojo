package com.org.matrix;

public class LargestSqauresConsistsOnes {
    public static void main(String[] args) {
        int[][] mat = {{1,0,1,1,1},
                       {1,0,1,1,1},
                       {1,1,1,1,1},
                       {1,0,0,1,0}};

        int result = largestSqure(mat);
        System.out.println("result :: "+ result);
    }

    public static int largestSqure(int mat[][]) {
        if(mat.length == 0) return 0;
        int m = mat.length, n = mat[0].length, result = 0;
        int[][] b = new int[m+1][n+1];
        for (int i = 1 ;i<= m; i++) {
            for (int j = 1; j <= n; j++) {
                if(mat[i-1][j-1] == 1) {
                    b[i][j] = Math.min(Math.min(b[i][j-1] , b[i-1][j-1]), b[i-1][j]) + 1;
                    result = Math.max(b[i][j], result);
                }
            }
        }
        return result*result;

    }
}

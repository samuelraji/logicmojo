package com.org.matrix;

public class SpiralMatrixFromCenter {

    public static int[][] fillSpiralMatrix(int n) {
        if (n % 2 == 0) {
            throw new IllegalArgumentException("Matrix size must be odd.");
        }

        int[][] matrix = new int[n][n];

        // Start from center
        int x = n / 2;
        int y = n / 2;

        // Directions: right, up, left, down
        int[][] directions = {
                {0, 1},  // right
                {-1, 0}, // up
                {0, -1}, // left
                {1, 0}   // down
        };

        int num = 1;
        matrix[x][y] = num++; // start at center

        int steps = 1;
        int dir = 0;

        while (num <= n * n) {
            for (int i = 0; i < 2; i++) { // Two sides per layer
                int dx = directions[dir % 4][0];
                int dy = directions[dir % 4][1];
                for (int j = 0; j < steps; j++) {
                    if (num > n * n) break;
                    x += dx;
                    y += dy;
                    matrix[x][y] = num++;
                }
                dir++; // change direction
            }
            steps++; // increase step after 2 directions
        }

        return matrix;
    }

    // Print the matrix
    public static void printMatrix(int[][] matrix) {
        for (int[] row : matrix) {
            for (int val : row) {
                System.out.printf("%3d ", val);
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        int size = 5;  // Can be 3, 5, 7, etc.
        int[][] matrix = fillSpiralMatrix(size);
        printMatrix(matrix);
    }
}

package com.org.practice;

import java.util.Scanner;

public class FindMean {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the number of elements: ");
        int size = scanner.nextInt();
        double[] numbers = new double[size];
        double sum = 0.0;
        System.out.println("Enter " + size + " decimal numbers:");
        for (int i = 0; i < size; i++) {
            numbers[i] = scanner.nextDouble();
            sum += numbers[i];
        }
        double mean = sum / size;

        System.out.printf("Mean = %.2f%n", mean);
        scanner.close();
    }
}

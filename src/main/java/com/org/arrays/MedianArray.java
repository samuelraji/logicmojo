package com.org.arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

public class MedianArray {

    private static void median_arrya(ArrayList<Integer> num2, ArrayList<Integer> num1) {

        ArrayList<Integer> resultArr = new ArrayList<>();
        int i=0,j=0;
        for (int k=0;k<num1.size()+num2.size();k++) {
            if (i< num1.size() && j<num2.size() && num2.get(i) < num1.get(j)) {
                resultArr.add(num2.get(i));
                i++;
            } else if (i< num1.size() && j<num2.size() && num2.get(i) > num1.get(j)) {
                resultArr.add(num1.get(j));
                j++;
            } else if (j< num1.size()) {
                resultArr.add(num1.get(j));
                j++;
                k++;
            } else if (i<num2.size()) {
                resultArr.add(num1.get(i));
                i++;
                k++;
            }
        }
        for (Integer num:resultArr) {
            System.out.println(" "+ num);
        }
        int dm = 5%2;
        System.out.println(1+0.0);
    }

    public static void main(String[] args) {
        int size = 10; // Size of each ArrayList
        int bound = 5; // Max value for random numbers (0 to 99)

        ArrayList<Integer> arrayList1 = new ArrayList<>(Arrays.asList(3, 8, 15, 22, 30));

        ArrayList<Integer> arrayList2 = new ArrayList<>(Arrays.asList(2, 7, 14, 20, 28, 35));

        median_arrya(arrayList1, arrayList2);
        System.out.println("Random ArrayList 1: " + arrayList1);
        System.out.println("Random ArrayList 2: " + arrayList2);
    }



    // Method to generate a random ArrayList of given size and bound
    public static ArrayList<Integer> generateRandomArrayList(int size, int bound) {
        Random rand = new Random();
        ArrayList<Integer> list = new ArrayList<>();

        for (int i = 0; i < size; i++) {
            list.add(rand.nextInt(bound));
        }

        return list;
    }
}

package com.org.arrays;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class ArrivalDepartureTrains {
    public static void main(String[] args) {
        Double list1[] = { 2.00, 2.10, 3.00, 3.20, 3.50, 5.00 };
        Double list2[] = { 2.30, 3.40, 3.20, 4.30, 4.00, 5.20 };
        List<Double> trainsArrival = Arrays.asList(list1);
        List<Double> trainsDeparture = Arrays.asList(list2);
        Collections.sort(trainsArrival);
        Collections.sort(trainsDeparture);
        int platforms = 0, count=0, i=0, j=0;
        while (i<trainsArrival.size()) {
            if (trainsArrival.get(i) < trainsDeparture.get(j)) {
                platforms=Integer.max(platforms, ++count);
                i++;
            } else {
                count--;
                j++;
            }
        }
        System.out.println("platforms :: "+ platforms);
    }

}

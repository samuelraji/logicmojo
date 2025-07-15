package org.example;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Test3 {

    public static void main(String[] args) {
        List<Integer> list1 = new ArrayList<>(Arrays.asList(1, 2, 3, 4));
        List<Integer> list2 = new ArrayList<>(Arrays.asList(5, 6, 7, 8));
        List<Integer> list3 = new ArrayList<>(Arrays.asList(3, 5, 6));

        // Check if list1 and list2 are disjoint
        boolean disjoint1 = Collections.disjoint(list1, list2);
        System.out.println("List1 and List2 are disjoint: " + disjoint1); // true

        // Check if list1 and list3 are disjoint
        boolean disjoint2 = Collections.disjoint(list1, list3);
        System.out.println("List1 and List3 are disjoint: " + disjoint2); // false
    }
}

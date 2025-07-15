package com.org.arrays;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class MeetingRoomsUsingTreeMap {
    public static void main(String[] args) {
        List<List<Integer>> a = Arrays.asList(Arrays.asList(0,30),Arrays.asList(5,10),Arrays.asList(15,20));
        Map<Integer, Integer> m = new TreeMap<>();
        for (int i = 0; i<a.size(); i++) {
            m.put(a.get(i).get(0), m.getOrDefault(a.get(i).get(0), 0) + 1);//start time
            m.put(a.get(i).get(1), m.getOrDefault(a.get(i).get(1), 0) - 1);//end time
        }
        int c = 0;
        int maxi = 0;
        for (Map.Entry<Integer, Integer>entry :m.entrySet()) {
            c += entry.getValue();
            if (c > maxi) {
                maxi = c;
            }
        }
        System.out.println("maxi :: " + maxi);
    }
}

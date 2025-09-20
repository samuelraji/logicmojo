package com.org.graphs;

import java.util.HashMap;
import java.util.Map;
/**
 * 1.	Given a list of departure and arrival airports, find the itinerary in order.
 * It may be assumed that departure is scheduled from every airport except the final destination,
 * and each airport is visited only once, i.e., there are no cycles in the route.
 *
 * Input:
 * LAX —> DXB
 * DFW —> JFK
 * LHR —> DFW
 * JFK —> LAX
 *
 * Output: LHR —> DFW —> JFK —> LAX —> DXB*/
public class ArrivalDepartureAirport {
    // This function populates 'result' for given input 'dataset'
    private static void printResult(Map<String, String>dataSet) {
        // To store reverse of given map
        Map<String, String>reverseMap = new HashMap<String, String>();
        // To fill reverse map, iterate through the given map
        for(Map.Entry<String,String> entry: dataSet.entrySet())
            reverseMap.put(entry.getValue(), entry.getKey());
        // Find the starting point of itinerary
        String start = null;
        for(Map.Entry<String,String> entry: dataSet.entrySet()) {
            if(!reverseMap.containsKey(entry.getKey())) {
                start = entry.getKey();
                break;
            }
        }
        // If we could not find a starting point, then something wrong
        // with input
        if(start == null) {
            System.out.println("Invalid Input");
            return;
        }
        // Once we have starting point, we simple need to go next, next
        // of next using given hash map
        String to = dataSet.get(start);
        while(to != null) {
            System.out.print(start +  "->"+ to + ", ");
            start = to;
            to = dataSet.get(to);
        }
    }

    public static void main(String[] args) {
        // Example dataset: from -> to
        Map<String, String> dataSet = new HashMap<>();
        dataSet.put("LAX", "DXB");
        dataSet.put("DFW", "JFK");
        dataSet.put("LHR", "DFW");
        dataSet.put("JFK", "LAX");
        // Call the function with dataset
        printResult(dataSet);
    }
}

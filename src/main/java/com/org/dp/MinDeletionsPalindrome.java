package com.org.dp;

import java.util.HashMap;
import java.util.Map;

public class MinDeletionsPalindrome {

    public static int minDeletions(String X,int i,int j,Map<String,Integer>lookup) {
        // base condition
        if(i>= j) return 0;
        // construct a unique map key from dynamic elements of the input
        String key = i + "|" + j;
        // if the subproblem is seen for the first time, solve it and
        // store its result in a map
        if(!lookup.containsKey(key)) {
            // if the last character of the string is the same as the first character
            if(X.charAt(i) == X.charAt(j)){
                lookup.put(key,minDeletions(X,i + 1,j - 1,lookup));
            }
            else{
                // if the last character of the string is different from the first
                // character

                // 1. Remove the last character and recur for the remaining substring
                // 2. Remove the first character and recur for the remaining substring

                // return 1 (for remove operation) + minimum of the two values

                int result = 1 + Math.min(minDeletions(X,i,j - 1,lookup),
                        minDeletions(X,i + 1,j,lookup));
                lookup.put(key,result);
            }
        }
        // return the subproblem solution from the map
        return lookup.get(key);
    }

    public static void main(String[]args) {
        String X = "ACBCDBAA";
        int n = X.length();
        // create a map to store solutions to subproblems
        Map<String,Integer> lookup = new HashMap<>();
        System.out.print("The minimum number of deletions required is " +
                minDeletions(X,0,n - 1,lookup));
    }

}

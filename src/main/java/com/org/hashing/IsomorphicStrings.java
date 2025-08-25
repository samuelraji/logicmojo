package com.org.hashing;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class IsomorphicStrings {
    public static void main(String[] args) {
        System.out.println(isIsomorphic("ACAB", "XCXY"));
    }

    // Find if strings 'X' and 'Y' are Isomorphic or not
    public static boolean isIsomorphic(String X, String Y) {
        if(X == null || Y == null) return false;
        if(X.length() != Y.length()) return false;
        // use a map to store a mapping from characters of string 'X' to string 'Y'
        Map<Character,Character> map = new HashMap<>();
        // use set to store a pool of already mapped characters
        Set<Character> set = new HashSet<>();
        for(int i = 0;i<X.length();i++) {
            char x = X.charAt(i),y = Y.charAt(i);
            if(map.containsKey(x)) { // if 'x' is seen before
                // return false if the first occurrence of `x` is mapped to a
                // different character
                if(map.get(x) != y){
                    return false;
                }
            } else { // if 'x' is seen for the first time (i.e., it isn't mapped yet)
                // return false if 'y' is already mapped to some other char in 'X'
                if(set.contains(y)){
                    return false;
                }
                // map 'y' to 'x' and mark it as mapped
                map.put(x,y);
                set.add(y);
            }
        }
        return true;
    }
}

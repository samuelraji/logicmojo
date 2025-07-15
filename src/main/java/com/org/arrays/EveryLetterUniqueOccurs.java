package com.org.arrays;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

public class EveryLetterUniqueOccurs {

    public int everyLetterOccurs(String str) {
        char[] chars = str.toCharArray();
        Map<Character, Integer> freqMap = new TreeMap<>();
        for (int i=0;i<chars.length; i++) {
            freqMap.put(chars[i], freqMap.getOrDefault(chars[i], 0)+1);
        }
        Set<Integer> usedFrequencies = new HashSet<>();
        int deletions = 0;

        for (int freq : freqMap.values()) {
            // Reduce frequency until it's unique or 0
            while (freq > 0 && !usedFrequencies.add(freq)) {
                freq--;
                deletions++;
            }
        }

        return deletions;
    }

    public static void main(String[] args) {
        EveryLetterUniqueOccurs p = new EveryLetterUniqueOccurs();
        System.out.println(p.everyLetterOccurs("dcaaaabbbb"));
    }
}

package com.org.onStrings;

import java.util.HashMap;
import java.util.Map;

public class CommonSubStringSequences {
    public static void main(String[] args) {
        String s = "abcde", t = "ace";
        System.out.println(commonSubstringSequence(s, t));
    }

    private static int commonSubstringSequence(String text1, String text2) {
        Map<String, Integer> map = new HashMap<>();
        int ans = 0;
        ans = lcsDP(text1, text2, text1.length(), text2.length(), map);
        return ans;
    }

    private static int lcsDP(String text1, String text2, int n, int m, Map<String, Integer> map) {
        if (m == 0 || n == 0) {
            return 0;
        }
        String key = n + "," + m;
        if (map.containsKey(key)) return map.get(key);
        int lcs = 0;
        if (text1.charAt(n-1) == text2.charAt(m-1)) {
            lcs = 1 + lcsDP(text1, text2, n-1, m-1, map);
        } else {
            lcs = Math.max(lcsDP(text1, text2, n-1, m, map), lcsDP(text1, text2, n, m-1, map));
        }
        map.put(key, lcs);
        return lcs;
    }

}

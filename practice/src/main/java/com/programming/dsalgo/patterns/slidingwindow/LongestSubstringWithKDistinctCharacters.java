package com.programming.dsalgo.patterns.slidingwindow;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class LongestSubstringWithKDistinctCharacters {

    public static void main(String[] args) {
        System.out.println(longestSubstring("eceba", 2));
    }

    // Brute force
    private static int longestSubstring1(String str, int k) {
        int max = 0;
        for (int i = 0; i < str.length(); i++) {
            Set<Character> set = new HashSet<>();
            for (int j = i; j < str.length(); j++) {
                set.add(str.charAt(j));
                if (set.size() <= k) {
                    max = Math.max(max, j - i + 1);
                } else {
                    break;
                }
            }
        }
        return max;
    }

    // Sliding window
    private static int longestSubstring(String str, int k) {
        int maxLen = 0;
        int start = 0, end = 0;
        Map<Character, Integer> freqMap = new HashMap<>();
        while (end < str.length()) {
            freqMap.put(str.charAt(end), freqMap.getOrDefault(str.charAt(end), 0) + 1);
            while (freqMap.size() > k) {
                freqMap.put(str.charAt(start), freqMap.get(str.charAt(start)) - 1);
                if (freqMap.get(str.charAt(start)) == 0) {
                    freqMap.remove(str.charAt(start));
                }
                start++;
            }
            maxLen = Math.max(maxLen, end - start + 1);
            end++;
        }
        return maxLen;
    }
}

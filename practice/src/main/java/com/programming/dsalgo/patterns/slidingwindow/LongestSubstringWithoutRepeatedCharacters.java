package com.programming.dsalgo.patterns.slidingwindow;

import java.util.HashSet;
import java.util.Set;

public class LongestSubstringWithoutRepeatedCharacters {

    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstring("aaaa"));
    }

    // Brute Force
    private static int lengthOfLongestSubstring1(String s) {
        int maxLen = 0;
        Set<Character> set = new HashSet<>();
        for (int i = 0; i < s.length(); i++) {
            set.add(s.charAt(i));
            int len = 1;
            for (int j = i + 1; j < s.length(); j++) {
                if (!set.contains(s.charAt(j))) {
                    set.add(s.charAt(j));
                    len++;
                } else {
                    break;
                }
            }
            maxLen = Math.max(maxLen, len);
        }
        return maxLen;
    }

    // Sliding window
    private static int lengthOfLongestSubstring(String s) {
        int maxLen = 0;
        int start = 0, end = 0;
        Set<Character> set = new HashSet<>();
        while (end < s.length()) {
            while (set.contains(s.charAt(end))) {
                set.remove(s.charAt(start));
                start++;
            }
            set.add(s.charAt(end));
            maxLen = Math.max(maxLen, end - start + 1);
            end++;
        }
        return maxLen;
    }
}

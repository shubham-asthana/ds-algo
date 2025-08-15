package com.programming.dsalgo.patterns.slidingwindow;

public class LongestRepeatingCharacterReplacement {

    public static void main(String[] args) {
        System.out.println(characterReplacement("AABABBA", 1));
    }

    // Brute Force - Using hashtable
    private static int characterReplacement1(String s, int k) {
        int maxLen = 0;
        for (int i = 0; i < s.length(); i++) {
            int maxFreq = 0;
            int[] countTable = new int[26];
            for (int j = i; j < s.length(); j++) {
                countTable[s.charAt(j) - 'A']++;
                maxFreq = Math.max(maxFreq, countTable[s.charAt(j) - 'A']);
                if ((j - i + 1) - maxFreq <= k) {
                    maxLen = Math.max(maxLen, j - i + 1);
                }
            }
        }
        return maxLen;
    }

    // Sliding window
    private static int characterReplacement(String s, int k) {
        int maxLen = 0;
        int start = 0, end = 0;
        int[] countTable = new int[26];
        int maxFreq = 0;
        while (end < s.length()) {
            countTable[s.charAt(end) - 'A']++;
            maxFreq = Math.max(maxFreq, countTable[s.charAt(end) - 'A']);
            while ((end - start + 1) - maxFreq > k) {
                countTable[s.charAt(start) - 'A']--;
                start++;
            }
            maxLen = Math.max(maxLen, end - start + 1);
            end++;
        }
        return maxLen;
    }
}

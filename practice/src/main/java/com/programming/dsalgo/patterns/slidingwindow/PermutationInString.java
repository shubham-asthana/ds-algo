package com.programming.dsalgo.patterns.slidingwindow;

import java.util.Arrays;

public class PermutationInString {

    public static void main(String[] args) {
        System.out.println(checkInclusion("sea", "tae"));
    }

    // Brute Force
    private static boolean checkInclusion1(String s1, String s2) {
        char[] s1Array = s1.toCharArray();
        Arrays.sort(s1Array);
        String sortedS1Str = new String(s1Array);

        for (int i = 0; i < s2.length(); i++) {
            for (int j = i; j < s2.length(); j++) {
                char[] s2Array = s2.substring(i, j + 1).toCharArray();
                Arrays.sort(s2Array);
                String sortedS2Str = new String(s2Array);

                if (sortedS2Str.equals(sortedS1Str))
                    return true;
            }
        }
        return false;
    }

    // O(nxm)
    private static boolean checkInclusion2(String s1, String s2) {
        int[] s1Freq = new int[26];
        for (int i = 0; i < s1.length(); i++) {
            s1Freq[s1.charAt(i) - 'a']++;
        }
        int left = 0, right = s1.length() - 1;
        while (right < s2.length()) {
            int[] s2Freq = new int[26];
            for (int i = left; i <= right; i++) {
                s2Freq[s2.charAt(i) - 'a']++;
            }
            boolean match = true;
            for (int i = 0; i < s1Freq.length; i++) {
                if (s1Freq[i] != s2Freq[i]) {
                    match = false;
                    break;
                }
            }
            if (match) {
                return true;
            }
            left++;
            right++;
        }
        return false;
    }

    private static boolean checkInclusion(String s1, String s2) {
        if (s1.length() > s2.length())
            return false;

        int[] s1Freq = new int[26];
        int[] s2Freq = new int[26];
        for (int i = 0; i < s1.length(); i++) {
            s1Freq[s1.charAt(i) - 'a']++;
            s2Freq[s2.charAt(i) - 'a']++;
        }
        int matches = 0;
        for (int i = 0; i < 26; i++) {
            if (s1Freq[i] == s2Freq[i])
                matches++;
        }

        int left = 0, right = s1.length();
        while (right < s2.length()) {
            if (matches == 26)
                return true;
            int index = s2.charAt(right) - 'a';
            s2Freq[index]++;
            if (s1Freq[index] == s2Freq[index])
                matches++;
            else if (s1Freq[index] + 1 == s2Freq[index])
                matches--;

            index = s2.charAt(left) - 'a';
            s2Freq[index]--;
            if (s1Freq[index] == s2Freq[index])
                matches++;
            else if (s1Freq[index] - 1 == s2Freq[index])
                matches--;

            left++;
            right++;
        }
        return matches == 26;
    }
}

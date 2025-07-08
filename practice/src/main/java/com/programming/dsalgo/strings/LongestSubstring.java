package com.programming.dsalgo.strings;

public class LongestSubstring {

    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstring("pwwkew"));
    }

    private static int lengthOfLongestSubstring(String s) {

        // O(n^2)
        // int maxLength = 0;
        // for (int i = 0; i < s.length(); i++) {
        // String temp = "";
        // for (int j = i; j < s.length(); j++) {
        // String ch = String.valueOf(s.charAt(j));
        // if (temp.indexOf(ch) < 0) {
        // temp += ch;
        // maxLength = Math.max(maxLength, temp.length());
        // } else {
        // break;
        // }
        // }
        // }
        // return maxLength;
        int maxLength = 0;
        int[] charIndex = new int[256];
        int left = 0;
        for (int right = 0; right < s.length(); right++) {
            char ch = s.charAt(right);
            if (charIndex[ch] > left) {
                left = charIndex[ch];
            }
            charIndex[ch] = right + 1;
            maxLength = Math.max(maxLength, right - left + 1);
        }
        return maxLength;
    }
}

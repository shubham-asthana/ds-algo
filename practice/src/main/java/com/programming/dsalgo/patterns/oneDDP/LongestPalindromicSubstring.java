package com.programming.dsalgo.patterns.oneDDP;

public class LongestPalindromicSubstring {

    public static void main(String[] args) {
        System.out.println(longestPalindrome("ababd"));
    }

    private static String longestPalindrome(String s) {
        String longest = "";
        for (int i = 0; i < s.length(); i++) {
            for (int j = i; j < s.length(); j++) {
                if (isPalindrome(s, i, j)) {
                    String subStr = s.substring(i, j + 1);
                    if (subStr.length() > longest.length()) {
                        longest = subStr;
                    }
                }
            }
        }
        return longest;
    }

    private static boolean isPalindrome(String str, int left, int right) {
        while (left < right) {
            if (str.charAt(left) != str.charAt(right))
                return false;
            left++;
            right--;
        }
        return true;
    }
}

package com.programming.dsalgo.strings;

public class ValidPalindrome {

    public static void main(String[] args) {
        System.out.print(isPalindrome("Was it a car or a cat I saw?"));
    }

    private static boolean isPalindrome(String s) {
        s = s.replaceAll("[^A-Za-z0-9]", "").toLowerCase();
        // String s1 = new StringBuilder(s).reverse().toString();
        // return s1.equals(s) ? true : false;
        int start = 0, end = s.length() - 1;
        while (start <= end) {
            if (s.charAt(start) == s.charAt(end)) {
                start++;
                end--;
            } else {
                return false;
            }
        }
        return true;
    }
}

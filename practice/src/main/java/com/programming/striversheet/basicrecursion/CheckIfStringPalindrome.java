package com.programming.striversheet.basicrecursion;

public class CheckIfStringPalindrome {

    public static void main(String[] args) {
        System.out.println(isPalindrome("A man, a plan, a canal: Panama"));
        System.out.println(isPalindrome("bob"));
    }

    // T.C & S.C => O(n/2) because only going till half length of the string
    private static boolean isPalindrome(String str) {
        str = str.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();
        return checkCharacters(0, str);
    }

    private static boolean checkCharacters(int start, String str) {
        if (start >= str.length() / 2)
            return true;
        if (str.charAt(start) != str.charAt(str.length() - 1 - start))
            return false;
        return checkCharacters(start + 1, str);
    }
}

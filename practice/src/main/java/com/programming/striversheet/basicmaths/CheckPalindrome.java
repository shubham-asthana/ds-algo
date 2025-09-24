package com.programming.striversheet.basicmaths;

public class CheckPalindrome {

    public static void main(String[] args) {
        System.out.println(isPalindrome(122));
        System.out.println(isPalindrome(121));
    }

    private static boolean isPalindrome(int n) {
        int rev = 0;
        int temp = n;
        while (temp > 0) {
            int lastDigit = temp % 10;
            rev = rev * 10 + lastDigit;
            temp /= 10;
        }
        return rev == n;
    }
}

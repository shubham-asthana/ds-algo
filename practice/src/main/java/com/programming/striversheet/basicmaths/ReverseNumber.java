package com.programming.striversheet.basicmaths;

public class ReverseNumber {

    public static void main(String[] args) {
        System.out.println(reverseNumber(1234));
    }

    // O(log10(n))
    private static int reverseNumber(int n) {
        int reversed = 0;
        while (n > 0) {
            int lastDigit = n % 10;
            reversed = reversed * 10 + lastDigit;
            n /= 10;
        }
        return reversed;
    }
}

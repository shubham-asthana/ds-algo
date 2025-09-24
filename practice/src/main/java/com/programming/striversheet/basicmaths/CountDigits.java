package com.programming.striversheet.basicmaths;

public class CountDigits {

    public static void main(String[] args) {
        System.out.println(countDigits1(312321));
        System.out.println(countDigits2(3213123));
    }

    // Brute - O(log10(n))
    private static int countDigits1(int n) {
        int count = 0;
        while (n > 0) {
            // int lastDigit = n % 10;
            n /= 10; // since dividing by 10 log10
            count++;
        }
        return count;
    }

    // Optimal - O(1)
    private static int countDigits2(int n) {
        return 1 + (int) Math.log10(n); // log10(3213123) ~= 6.....
    }
}

package com.programming.striversheet.basicmaths;

public class CheckPrime {

    public static void main(String[] args) {
        System.out.println(isPrime1(12));
        System.out.println(isPrime1(11));
        System.out.println(isPrime1(1));
        System.out.println(isPrime2(12));
        System.out.println(isPrime2(11));
        System.out.println(isPrime2(1));
    }

    // Brute - O(n)
    private static boolean isPrime1(int n) {
        if (n == 0 || n == 1)
            return false;
        int count = 0;
        for (int i = 1; i <= n; i++) {
            if (n % i == 0)
                count++;
        }
        return count == 2;
    }

    // O(sqrt(n))
    private static boolean isPrime2(int n) {
        if (n == 0 || n == 1)
            return false;
        int count = 0;
        for (int i = 1; i * i <= n; i++) {
            if (n % i == 0) {
                count++;
                if (n / i != i)
                    count++;
            }
        }
        return count == 2;
    }
}

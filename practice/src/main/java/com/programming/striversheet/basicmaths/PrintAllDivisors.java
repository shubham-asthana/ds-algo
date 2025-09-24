package com.programming.striversheet.basicmaths;

public class PrintAllDivisors {

    public static void main(String[] args) {
        printAllDivisors1(36);
        System.out.println();
        printAllDivisors2(36);
    }

    // O(n)
    private static void printAllDivisors1(int n) {
        for (int i = 1; i <= n; i++) {
            if (n % i == 0) {
                System.out.print(i + " ");
            }
        }
    }

    // O(sqrt(n))
    private static void printAllDivisors2(int n) {
        for (int i = 1; i <= Math.sqrt(n); i++) {
            if (n % i == 0) {
                if (i != n / i)
                    System.out.print(i + " " + n / i + " ");
                else
                    System.out.print(i);
            }
        }
    }
}

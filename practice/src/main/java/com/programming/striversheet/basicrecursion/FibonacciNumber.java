package com.programming.striversheet.basicrecursion;

public class FibonacciNumber {

    public static void main(String[] args) {
        System.out.println(fibonacciNumber(8));
    }

    // Example of multiple recursion calls
    // T.C(~2^n) -> every recursion call had two calls...
    private static int fibonacciNumber(int n) {
        if (n <= 1)
            return n;
        return fibonacciNumber(n - 1) + fibonacciNumber(n - 2);
    }
}

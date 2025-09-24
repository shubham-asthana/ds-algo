package com.programming.striversheet.basicrecursion;

public class SumFirstNNumbers {

    public static void main(String[] args) {
        System.out.println(sum1(5, 0));
        System.out.println(sum2(5));
    }

    private static int sum1(int i, int n) {
        if (i < 1)
            return n;
        return sum1(i - 1, n + i);
    }

    private static int sum2(int n) {
        if (n == 0)
            return 0;
        return n + sum2(n - 1);
    }
}

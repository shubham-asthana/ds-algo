package com.programming.striversheet.revision1.basicmaths;

public class GCD {

    public static void main(String[] args) {
        System.out.println(gcd1(4, 12));
        System.out.println(gcd2(4, 12));
        System.out.println(gcd3(4, 12));
    }

    private static int gcd1(int a, int b) {
        int gcd = 1;
        for (int i = 1; i <= Math.min(a, b); i++) {
            if (a % i == 0 || b % i == 0)
                gcd = i;
        }
        return gcd;
    }

    private static int gcd2(int a, int b) {
        int gcd = 1;
        for (int i = Math.min(a, b); i > 0; i--) {
            if (a % i == 0 || b % i == 0) {
                gcd = i;
                break;
            }
        }
        return gcd;
    }

    private static int gcd3(int a, int b) {
        while (a > 0 && b > 0) {
            if (a > b)
                a %= b;
            else
                b = b % a;
        }
        return a == 0 ? b : a;
    }
}

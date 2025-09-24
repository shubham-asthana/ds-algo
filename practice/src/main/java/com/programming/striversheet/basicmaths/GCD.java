package com.programming.striversheet.basicmaths;

public class GCD {

    public static void main(String[] args) {
        System.out.println(gcd1(9, 12));
        System.out.println(gcd2(9, 12));
        System.out.println(gcd3(9, 12));
    }

    // O(smallest of a or b)
    private static int gcd1(int a, int b) {
        int gcd = 1;
        for (int i = 1; i <= Math.min(a, b); i++) {
            if (a % i == 0 && b % i == 0) {
                gcd = i;
            }
        }
        return gcd;
    }

    // Slightly better than above or similar to above
    private static int gcd2(int a, int b) {
        int gcd = 1;
        for (int i = Math.min(a, b); i >= 1; i--) {
            if (a % i == 0 && b % i == 0) {
                gcd = i;
                break;
            }
        }
        return gcd;
    }

    // Euclidean Algorithm -> gcd(a, b) = gcd(a-b, b); if a > b
    // => gcd(a, b) = gcd(a % b, b)
    // O(log(min(a, b)))
    private static int gcd3(int a, int b) {
        while (a > 0 && b > 0) {
            if (a > b)
                a %= b;
            else
                b %= a;
        }
        return a == 0 ? b : a;
    }
}

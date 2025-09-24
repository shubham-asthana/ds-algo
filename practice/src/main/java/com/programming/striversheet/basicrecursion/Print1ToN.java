package com.programming.striversheet.basicrecursion;

public class Print1ToN {

    public static void main(String[] args) {
        print(1, 5);
    }

    private static void print(int i, int n) {
        if (i > n)
            return;
        System.out.println(i);
        print(i + 1, n);
    }
}

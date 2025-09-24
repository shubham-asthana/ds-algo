package com.programming.striversheet.basicrecursion;

public class PrintNTo1 {

    public static void main(String[] args) {
        print(5, 5);
    }

    private static void print(int i, int n) {
        if (i < 1)
            return;
        System.out.println(i);
        print(i - 1, n);
    }
}

package com.programming.striversheet.basicrecursion;

public class PrintNTo1UsingfBacktracking {

    public static void main(String[] args) {
        print(1, 5);
    }

    private static void print(int i, int n) {
        if (i > n)
            return;
        print(i + 1, n);
        System.out.println(i);
    }
}

package com.programming.striversheet.basicrecursion;

public class PrintName {

    public static void main(String[] args) {
        printName(1, 5);
    }

    // O(n) -> n function calls for T.C, O(n) -> S.C for stack space
    private static void printName(int i, int n) {
        if (i > n)
            return;
        System.out.println("Shubham");
        printName(i + 1, n);
    }
}

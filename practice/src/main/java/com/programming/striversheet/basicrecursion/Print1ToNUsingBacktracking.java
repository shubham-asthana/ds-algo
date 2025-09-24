package com.programming.striversheet.basicrecursion;

public class Print1ToNUsingBacktracking {

    public static void main(String[] args) {
        print(5, 5);
    }

    private static void print(int i, int n) {
        if (i < 1)
            return;
        print(i - 1, n);
        System.out.println(i);
    }
}

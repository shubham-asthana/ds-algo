package com.programming.striversheet.basicrecursion;

public class PrintNTimes {

    private static int count;

    public static void main(String[] args) {
        printNTimes();
    }

    private static void printNTimes() {
        if (count == 5)
            return;
        count++;
        System.out.println(count);
        printNTimes();
    }
}

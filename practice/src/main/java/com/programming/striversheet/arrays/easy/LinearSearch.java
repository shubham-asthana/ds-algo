package com.programming.striversheet.arrays.easy;

public class LinearSearch {

    public static void main(String[] args) {
        int[] arr = { 6, 7, 8, 4, 1 };
        System.out.println(linearSearch(arr, 4));
    }

    // T.C = O(n), S.C = O(1)
    // Note that if this code gives first occurrence.
    // If asked last occurrence iterate array from end -> arr.length - 1.
    // If asked all occurrences, add the index to a list and return.
    private static int linearSearch(int[] arr, int k) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == k)
                return i;
        }
        return -1;
    }
}

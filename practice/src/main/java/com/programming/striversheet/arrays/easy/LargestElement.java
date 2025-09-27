package com.programming.striversheet.arrays.easy;

import java.util.Arrays;

public class LargestElement {

    public static void main(String[] args) {
        int[] arr = { 1, 7, 5, 2, 6, 2, 4, 3 };
        System.out.println(findLargest1(arr));
        System.out.println(findLargest2(arr));
    }

    // T.C = O(nlogn)
    private static int findLargest1(int[] arr) {
        Arrays.sort(arr);
        return arr[arr.length - 1];
    }

    // T.C = O(n)
    private static int findLargest2(int[] arr) {
        int largest = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > largest)
                largest = arr[i];
        }
        return largest;
    }
}

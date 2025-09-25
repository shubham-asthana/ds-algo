package com.programming.striversheet.sorting1;

public class SelectionSort {

    public static void main(String[] args) {
        int[] arr = { 3, 2, 5, 4, 9, 8, 7 };
        sort(arr);
        for (int num : arr)
            System.out.print(num + " ");
    }

    // Step 1: Find the minimum from the arr and place it at arr[0]
    // Step 2: From arr[1] to arr[n - 1], repeat step 1 and so on.
    // O(n^2) - best, avg, worst
    private static void sort(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            int min = i; // start with first index in a subarray
            for (int j = i; j < arr.length; j++) { // inner loop to find the index of the min element.
                if (arr[j] < arr[i])
                    min = j;
            }
            int temp = arr[i];
            arr[i] = arr[min];
            arr[min] = temp;
        }
    }
}

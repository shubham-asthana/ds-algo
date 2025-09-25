package com.programming.striversheet.sorting1;

public class BubbleSort {

    public static void main(String[] args) {
        int[] arr = { 3, 2, 5, 4, 9, 8, 7 };
        sort(arr);
        for (int num : arr)
            System.out.print(num + " ");
    }

    // Step 1: Compare adjacent elements and swap - this pushes the max element to
    // the last
    // Step 2: Then compare adjacent elements from start to last - 1 and swap as
    // above and so on. Hence run outer loop from n - 1 to 1 and inner loop runs
    // from 0 to i - 1 -> for the last element case.
    // O(n ^ 2) - worst, avg, O(n) - best
    private static void sort(int[] arr) {
        for (int i = arr.length - 1; i > 0; i--) {
            int swapped = 0; // flag to check if swap is happening or not
            for (int j = 0; j < i; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                    swapped = 1;
                }
            }
            if (swapped == 0) // If array is sorted, reduces T.C to O(n)
                break;
        }
    }
}

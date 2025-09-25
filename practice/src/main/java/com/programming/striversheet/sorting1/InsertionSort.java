package com.programming.striversheet.sorting1;

// Takes an element and places it in the correct order.
public class InsertionSort {

    public static void main(String[] args) {
        int[] arr = { 3, 2, 5, 4, 9, 8, 7 };
        sort(arr);
        for (int num : arr)
            System.out.print(num + " ");
    }

    // Step 1: Start with a window of suppose two elements, check if the elements
    // are in correct order, if not, swap.
    // Step 2: Keep on increasing the window size till all element are in correct
    // order.
    // T.C = O(n ^ 2) - worst, avg, O(n) - best when array is sorted as while loop
    // does not get executed
    private static void sort(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            int j = i;
            while (j > 0 && arr[j - 1] > arr[j]) {
                int temp = arr[j - 1];
                arr[j - 1] = arr[j];
                arr[j] = temp;
            }
        }
    }
}

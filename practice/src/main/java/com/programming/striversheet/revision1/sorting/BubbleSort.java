package com.programming.striversheet.revision1.sorting;

public class BubbleSort {

    public static void main(String[] args) {
        int[] arr = { 2, 5, 3, 1, 4, 7, 6 };
        sort(arr);
        for (int num : arr)
            System.out.print(num + " ");
    }

    private static void sort(int[] arr) {
        for (int i = arr.length - 1; i >= 0; i--) {
            int swapped = 0;
            for (int j = 0; j < i; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                    swapped = 1;
                }
            }
            if (swapped == 0)
                break;
        }
    }
}

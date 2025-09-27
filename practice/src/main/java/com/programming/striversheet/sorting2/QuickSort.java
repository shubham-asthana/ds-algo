package com.programming.striversheet.sorting2;

public class QuickSort {

    public static void main(String[] args) {
        int[] arr = { 3, 2, 5, 4, 9, 8, 7 };
        sort(arr);
        for (int num : arr)
            System.out.print(num + " ");
    }

    // T.C = O(nlog(n))
    // S.C = O(1)
    /**
     * 1. Pick pivot - 1st or last or median or random ele, and place it in its
     * correct place in the sorted array.
     * 2. Smaller element should be on the left, larger elements should be on the
     * right.
     * 
     * @param arr
     */
    private static void sort(int[] arr) {
        quickSort(arr, 0, arr.length - 1);
    }

    // Divide and Conquer Algo
    private static void quickSort(int[] arr, int low, int high) {
        if (low < high) {
            int partitionIndex = partitionIndex(arr, low, high);
            quickSort(arr, low, partitionIndex - 1);
            quickSort(arr, partitionIndex + 1, high);
        }
    }

    // T.C = O(n)
    private static int partitionIndex(int[] arr, int low, int high) {
        int i = low, j = high;
        int pivot = arr[low];
        while (i < j) {
            while (arr[i] <= pivot && i < high) {
                i++;
            }
            while (arr[j] > pivot && j > low) {
                j--;
            }
            if (i < j) {
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }
        int temp = arr[low];
        arr[low] = arr[j];
        arr[j] = temp;

        return j;
    }
}

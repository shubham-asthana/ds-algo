package com.programming.dsalgo.searching;

public class SearchInRotatedArrayTwoPass {

    public static void main(String[] args) {
        int[] arr = new int[] { 5, 6, 7, 8, 9, 10, 1, 2, 3 };
        System.out.println(search(arr, 11));
    }

    private static int search(int[] arr, int key) {
        int pivot = findMinIndex(arr);
        int low = 0, high = arr.length - 1;
        if (key >= arr[pivot] && key <= arr[high]) {
            low = pivot;
        } else {
            high = pivot - 1;
        }
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (arr[mid] == key) {
                return mid;
            } else if (key < arr[mid]) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return -1;
    }

    private static int findMinIndex(int[] arr) {
        int low = 0, high = arr.length - 1;
        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (arr[low] <= arr[high])
                return low;

            if (arr[mid] > arr[high]) {
                low = mid + 1;
            } else {
                high = mid;
            }
        }
        return low;
    }
}

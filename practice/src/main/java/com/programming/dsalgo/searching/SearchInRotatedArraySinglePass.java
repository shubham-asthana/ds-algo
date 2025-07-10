package com.programming.dsalgo.searching;

public class SearchInRotatedArraySinglePass {

    public static void main(String[] args) {
        int[] arr = new int[] { 5, 6, 7, 8, 9, 10, 1, 2, 3 };
        System.out.println(search(arr, 8));
    }

    private static int search(int[] arr, int key) {
        int low = 0, high = arr.length - 1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (arr[mid] == key) {
                return mid;
            }
            if (arr[low] <= arr[mid]) {
                if (key > arr[mid] || key < arr[low]) {
                    low = mid + 1;
                } else {
                    high = mid - 1;
                }
            } else {
                if (key < arr[mid] || key > arr[high]) {
                    high = mid - 1;
                } else {
                    low = mid + 1;
                }
            }
        }
        return -1;
    }
}

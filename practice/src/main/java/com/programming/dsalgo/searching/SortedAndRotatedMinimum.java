package com.programming.dsalgo.searching;

public class SortedAndRotatedMinimum {

    public static void main(String[] args) {
        int[] arr = new int[] { 5, 6, 1, 2, 3, 4 };
        System.out.println(findMin(arr));
    }

    private static int findMin(int[] arr) {
        int low = 0, high = arr.length - 1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (arr[low] <= arr[high]) {
                return arr[low];
            }
            if (arr[mid] > arr[high]) {
                low = mid + 1;
            } else {
                high = mid;
            }
        }
        return arr[low];
    }
}

package com.programming.dsalgo.searching;

public class CountFrequency {

    public static void main(String[] args) {
        int[] arr = new int[] { 1, 2, 2, 2, 2, 3, 4, 5, 6, 7, 8, 8 };
        System.out.println(countFreq(arr, 8));
    }

    private static int countFreq(int[] arr, int target) {
        return upperBound(arr, target) - lowerBound(arr, target);
    }

    private static int lowerBound(int[] arr, int target) {
        int lower = arr.length;
        int low = 0, high = arr.length - 1;
        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (arr[mid] >= target) {
                lower = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return lower;
    }

    private static int upperBound(int[] arr, int target) {
        int upper = arr.length;
        int low = 0, high = arr.length - 1;
        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (arr[mid] > target) {
                upper = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return upper;
    }
}

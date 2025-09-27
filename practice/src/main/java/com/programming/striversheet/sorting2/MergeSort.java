package com.programming.striversheet.sorting2;

import java.util.ArrayList;
import java.util.List;

public class MergeSort {

    public static void main(String[] args) {
        int[] arr = { 3, 2, 5, 4, 9, 8, 7 };
        sort(arr);
        for (int num : arr)
            System.out.print(num + " ");
    }

    // T.C = O(nlog(n))
    // S.C = O(n)
    private static void sort(int[] arr) {
        mergeSort(arr, 0, arr.length - 1);
    }

    // T.C = O(nlog(n))
    private static void mergeSort(int[] arr, int low, int high) {
        if (low >= high)
            return;

        int mid = (low + high) / 2;
        mergeSort(arr, low, mid);
        mergeSort(arr, mid + 1, high);

        merge(arr, low, mid, high);
    }

    // T.C = O(n)
    // S.C = O(n)
    private static void merge(int[] arr, int low, int mid, int high) {
        List<Integer> temp = new ArrayList<>();
        int left = low;
        int right = mid + 1;
        while (left <= mid && right <= high) {
            if (arr[left] <= arr[right]) {
                temp.add(arr[left]);
                left++;
            } else {
                temp.add(arr[right]);
                right++;
            }
        }
        while (left <= mid) {
            temp.add(arr[left]);
            left++;
        }
        while (right <= high) {
            temp.add(arr[right]);
            right++;
        }

        for (int i = low; i <= high; i++) {
            arr[i] = temp.get(i - low); // Remember this
        }
    }
}

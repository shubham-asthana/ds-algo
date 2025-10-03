package com.programming.striversheet.arrays.medium;

import java.util.Arrays;

//Sort Colors
public class SortArrayOfZerosOnesTwos {

    public static void main(String[] args) {
        int[] arr1 = { 0, 1, 2, 0, 1, 2, 1, 2, 0, 0, 0, 1 };
        sort1(arr1);
        for (int num : arr1)
            System.out.print(num + " ");
        System.out.println();
        int[] arr2 = { 0, 1, 2, 0, 1, 2, 1, 2, 0, 0, 0, 1 };
        sort2(arr2);
        for (int num : arr2)
            System.out.print(num + " ");
        System.out.println();
        int[] arr3 = { 0, 1, 2, 0, 1, 2, 1, 2, 0, 0, 0, 1 };
        sort3(arr3);
        for (int num : arr3)
            System.out.print(num + " ");
    }

    // T.C = O(NlogN), S.C = O(N)
    private static void sort1(int[] arr) {
        Arrays.sort(arr); // using merge sort
    }

    // T.C = O(2N), S.C = O(1)
    private static void sort2(int[] arr) {
        int count0 = 0, count1 = 0, count2 = 0;
        for (int i = 0; i < arr.length; i++) { // O(N)
            if (arr[i] == 0)
                count0++;
            else if (arr[i] == 1)
                count1++;
            else
                count2++;
        }
        // O(N)
        for (int i = 0; i < count0; i++)
            arr[i] = 0;
        for (int i = count0; i < count0 + count1; i++)
            arr[i] = 1;
        for (int i = count0 + count1; i < arr.length; i++)
            arr[i] = 2;
    }

    // Dutch National Flag Algo
    // There are 3 flags -> low, mid, high
    // Everything from 0 to low - 1 = 0s -> extreme left
    // Everything from low to mid - 1 = 1s
    // Everything from high + 1 to n - 1 = 2s -> extreme right
    // From mid to high -> random order of 0s, 1s, 2s. -> Basically this the array
    // we need to sort.
    // Therefore when we start the algo our index 0 is mid and n-1 is high as the
    // entire array is unsorted. low can also be put at index = 0
    // Always visualize using a diagram.
    // T.C = O(N), S.C = O(1)
    private static void sort3(int[] arr) {
        int low = 0, mid = 0, high = arr.length - 1;
        while (mid <= high) {
            if (arr[mid] == 0) {
                int temp = arr[mid];
                arr[mid] = arr[low];
                arr[low] = temp;
                low++;
                mid++;
            } else if (arr[mid] == 1)
                mid++;
            else if (arr[mid] == 2) {
                int temp = arr[mid];
                arr[mid] = arr[high];
                arr[high] = temp;
                high--;
            }
        }
    }
}

package com.programming.striversheet.arrays.easy;

import java.util.ArrayList;
import java.util.List;

public class IntersectionOfTwoSortedArrays {

    public static void main(String[] args) {
        int[] arr1 = { 1, 1, 2, 3, 4, 5 };
        int[] arr2 = { 2, 3, 4, 4, 5 };
        for (int num : intersection1(arr1, arr2))
            System.out.print(num + " ");
        System.out.println();
        for (int num : intersection2(arr1, arr2))
            System.out.print(num + " ");
    }

    // Interesection -> elements which are present on both the arrays, reptition of
    // elements is allowed.
    // T.C = O(n1 * n2), S.C = O(n2) + O(n1 + n2), for intersection array
    private static int[] intersection1(int[] arr1, int[] arr2) {
        int n1 = arr1.length, n2 = arr2.length;
        int[] visited = new int[n2]; // array to denote an element exists in the intersection array and was there in
                                     // both the arrays.
        List<Integer> intersection = new ArrayList<>();
        for (int i = 0; i < n1; i++) {
            for (int j = 0; j < n2; j++) {
                if (arr1[i] == arr2[j] && visited[j] == 0) {
                    intersection.add(arr1[i]);
                    visited[j] = 1;
                    break;
                }
                if (arr2[j] > arr1[i])
                    break; // condition to stop checking with rest of the arr2 elements in case arr1[i] <
                           // arr2[j] because no point to iterating as array is sorted.
            }
        }
        return intersection.stream().mapToInt(Integer::intValue).toArray();
    }

    // Using two pointer -> Note that arrays are already sorted, else we need to
    // sort them first.
    // T.C = O(n1 + n2), S.C = O(n1 + n2) for intersection list
    private static int[] intersection2(int[] arr1, int[] arr2) {
        int n1 = arr1.length, n2 = arr2.length;
        List<Integer> insersection = new ArrayList<>();
        int i = 0, j = 0;
        while (i < n1 && j < n2) {
            if (arr1[i] < arr2[j])
                i++;
            else if (arr2[j] < arr1[i])
                j++;
            else {
                insersection.add(arr1[i]);
                i++;
                j++;
            }
        }
        return insersection.stream().mapToInt(Integer::intValue).toArray();
    }
}

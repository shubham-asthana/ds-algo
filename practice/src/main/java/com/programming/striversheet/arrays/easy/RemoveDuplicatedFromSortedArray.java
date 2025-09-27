package com.programming.striversheet.arrays.easy;

import java.util.HashSet;
import java.util.Set;

public class RemoveDuplicatedFromSortedArray {

    public static void main(String[] args) {
        int[] arr1 = { 1, 1, 2, 2, 2, 3, 3, 4 };
        System.out.println(removeDuplicates1(arr1));
        int[] arr2 = { 1, 1, 2, 2, 2, 3, 3, 4 };
        System.out.println(removeDuplicates2(arr2));
    }

    // Using set - Brute force
    // T.C = O(nlogn) + O(n)
    // S.C = O(n)
    private static int removeDuplicates1(int[] arr) {
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < arr.length; i++) {
            set.add(arr[i]);
        }
        int uniqueEl = 0;
        for (int num : set) {
            arr[uniqueEl] = num;
            uniqueEl++;
        }
        return uniqueEl;
    }

    // Using two pointer
    // T.C = O(n)
    private static int removeDuplicates2(int[] arr) {
        int uniqueEl = 0;
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] != arr[uniqueEl]) {
                arr[uniqueEl + 1] = arr[i];
                uniqueEl++;
            }
        }
        return uniqueEl + 1;
    }
}

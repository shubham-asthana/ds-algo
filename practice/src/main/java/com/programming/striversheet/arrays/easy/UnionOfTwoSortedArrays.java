package com.programming.striversheet.arrays.easy;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class UnionOfTwoSortedArrays {

    public static void main(String[] args) {
        int[] arr1 = { 1, 1, 2, 3, 4, 5 };
        int[] arr2 = { 2, 3, 4, 4, 5 };
        for (int num : union1(arr1, arr2))
            System.out.print(num + " ");
        System.out.println();
        for (int num : union2(arr1, arr2))
            System.out.print(num + " ");
    }

    // Union -> Unique elements from both the arrays

    // Using a set comes to mins because of uniqueness
    // T.C = O(n1logn + n2logn) + O(n1 + n2), S.C = O(n1 + n2) + O(n1 + n2)
    private static int[] union1(int[] arr1, int[] arr2) {
        Set<Integer> set = new HashSet<>(); // S.C O(n1 + n2)
        for (int i = 0; i < arr1.length; i++) // O(n1)
            set.add(arr1[i]);
        for (int i = 0; i < arr2.length; i++) // O(n2)
            set.add(arr2[i]);

        int[] union = new int[set.size()]; // S.C = O(n1 + n2)
        int i = 0;
        for (int num : set) { // T.C = O(n1 + n2)
            union[i] = num;
            i++;
        }
        return union;
    }

    // Using two pointers
    // T.C = O(n1 + n2), S.C = O(n1 + n2) for union array
    private static int[] union2(int[] arr1, int[] arr2) {
        int n1 = arr1.length, n2 = arr2.length;
        int i = 0, j = 0;
        List<Integer> union = new ArrayList<>();
        while (i < n1 && j < n2) {
            if (arr1[i] <= arr2[j]) {
                if (union.isEmpty() || !union.contains(arr1[i]))
                    union.add(arr1[i]);
                i++;
            } else if (arr2[j] < arr1[i]) {
                if (union.isEmpty() || !union.contains(arr2[j]))
                    union.add(arr2[j]);
                j++;
            }
        }
        while (i < n1) {
            if (union.isEmpty() || !union.contains(arr1[i]))
                union.add(arr1[i]);
            i++;
        }
        while (j < n2) {
            if (union.isEmpty() || !union.contains(arr2[j]))
                union.add(arr2[j]);
            j++;
        }
        return union.stream().mapToInt(Integer::intValue).toArray();
    }
}

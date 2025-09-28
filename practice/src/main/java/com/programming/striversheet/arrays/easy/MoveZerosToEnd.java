package com.programming.striversheet.arrays.easy;

import java.util.ArrayList;
import java.util.List;

public class MoveZerosToEnd {

    public static void main(String[] args) {
        int[] arr1 = { 1, 0, 2, 3, 2, 0, 0, 4, 5, 1 };
        moveZeros1(arr1);
        for (int num : arr1)
            System.out.print(num + " ");
        System.out.println();
        int[] arr2 = { 1, 0, 2, 3, 2, 0, 0, 4, 5, 1 };
        moveZeros2(arr2);
        for (int num : arr2)
            System.out.print(num + " ");
    }

    // Brute
    // T.C = O(2n), S.C = O(x) or O(n)
    private static void moveZeros1(int[] arr) {
        List<Integer> temp = new ArrayList<>();
        for (int i = 0; i < arr.length; i++) { // O(n)
            if (arr[i] != 0)
                temp.add(arr[i]);
        }
        for (int i = 0; i < temp.size(); i++) // O(x)
            arr[i] = temp.get(i);

        for (int i = temp.size(); i < arr.length; i++) // (n - x)
            arr[i] = 0;
    }

    // Using two pointers
    // T.C = O(n), S.C = O(1)
    private static void moveZeros2(int[] arr) {
        int j = -1;
        for (int i = 0; i < arr.length; i++) { // O(x) -> trying to find first zero, if not j = -1
            if (arr[i] == 0) {
                j = i;
                break;
            }
        }
        if (j == -1) // if no zeros, don't do anything
            return;
        for (int i = j + 1; i < arr.length; i++) { // O(n - x) -> put i after first zero and swap with zero
            if (arr[i] != 0) {
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
                j++;
            }
        }
    }
}

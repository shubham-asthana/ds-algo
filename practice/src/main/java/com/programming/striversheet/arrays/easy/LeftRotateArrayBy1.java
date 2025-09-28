package com.programming.striversheet.arrays.easy;

public class LeftRotateArrayBy1 {

    public static void main(String[] args) {
        int[] arr = { 1, 2, 3, 4, 5 };
        leftRotate(arr);
        for (int num : arr)
            System.out.print(num + " ");

    }

    // O(n)
    private static void leftRotate(int[] arr) {
        int temp = arr[0];
        for (int i = 1; i < arr.length; i++) {
            arr[i - 1] = arr[i];
        }
        arr[arr.length - 1] = temp;
    }
}

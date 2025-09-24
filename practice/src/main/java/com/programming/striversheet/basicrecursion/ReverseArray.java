package com.programming.striversheet.basicrecursion;

public class ReverseArray {

    public static void main(String[] args) {
        int[] arr1 = { 1, 2, 3, 4, 5 };
        int[] arr2 = { 1, 2, 3, 4, 5 };
        for (int num : reverseArray1(arr1)) {
            System.out.print(num + " ");
        }
        System.out.println();
        for (int num : reverseArray2(arr2)) {
            System.out.print(num + " ");
        }
    }

    private static int[] reverseArray1(int[] arr) {
        reverse1(0, arr.length - 1, arr);
        return arr;
    }

    private static int[] reverseArray2(int[] arr) {
        reverse2(0, arr);
        return arr;
    }

    private static void reverse1(int left, int right, int[] arr) {
        if (left >= right)
            return;
        int temp = arr[left];
        arr[left] = arr[right];
        arr[right] = temp;
        reverse1(left + 1, right - 1, arr);
    }

    private static void reverse2(int start, int[] arr) {
        if (start >= arr.length / 2)
            return;
        int temp = arr[start];
        arr[start] = arr[arr.length - 1 - start];
        arr[arr.length - 1 - start] = temp;
        reverse2(start + 1, arr);
    }
}

package com.programming.striversheet.arrays.easy;

public class LeftRotateArrayByK {

    public static void main(String[] args) {
        int[] arr1 = { 1, 2, 3, 4, 5 };
        leftRotate1(arr1, 2);
        for (int num : arr1)
            System.out.print(num + " ");
        System.out.println();
        int[] arr2 = { 1, 2, 3, 4, 5 };
        leftRotate2(arr2, 2);
        for (int num : arr2)
            System.out.print(num + " ");
    }

    // Observe that when k > arr.length, we can break it into arr.length + x = k =>
    // we need to rotate arr by x places. Ex: if in above example we are asked to
    // rotate by 7 place => we can break it into 5 + 2 => we need to rotate the
    // array by two places.
    // The way to find out x => k % arr.length, because if we do 7 % 5 = 2 =>
    // effecitve k is 2
    // Brute => T.C = O(n + k), S.C = O(k)
    private static void leftRotate1(int[] arr, int k) {
        int length = arr.length;
        k = k % length;
        // Store first k in temp
        // O(k)
        int[] temp = new int[k];
        for (int i = 0; i < k; i++) {
            temp[i] = arr[i];
        }
        // Shift from k to end to left
        // O(n-k)
        for (int i = k; i < length; i++) {
            arr[i - k] = arr[i];
        }
        // Put back temp to arr
        // O(k)
        // int j = 0;
        for (int i = length - k; i < length; i++) {
            // arr[i] = temp[j];
            // j++; // without any index calculation
            arr[i] = temp[i - (length - k)];
        }
    }

    // O(2n)
    private static void leftRotate2(int[] arr, int k) {
        k = k % arr.length;
        reverse(arr, 0, k - 1); // O(k)
        reverse(arr, k, arr.length - 1); // O(n -k)
        reverse(arr, 0, arr.length - 1); // O(n)
    }

    private static void reverse(int[] arr, int st, int en) {
        while (st < en) {
            int temp = arr[st];
            arr[st] = arr[en];
            arr[en] = temp;
            st++;
            en--;
        }
    }
}

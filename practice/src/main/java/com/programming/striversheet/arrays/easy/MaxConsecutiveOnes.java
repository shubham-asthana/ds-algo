package com.programming.striversheet.arrays.easy;

public class MaxConsecutiveOnes {

    public static void main(String[] args) {
        int[] arr = { 1, 1, 0, 1, 1, 1, 0, 1, 1 };
        System.out.println(maxConsecutiveOnes(arr));
    }

    // T.C = O(n)
    private static int maxConsecutiveOnes(int[] arr) {
        int max = 0, count = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == 1)
                count++;
            else
                count = 0;
            max = Math.max(max, count);
        }
        return max;
    }
}

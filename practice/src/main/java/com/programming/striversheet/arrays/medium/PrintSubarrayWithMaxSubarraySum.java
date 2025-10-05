package com.programming.striversheet.arrays.medium;

// Extension of max subarray sum - Kadane's algo
public class PrintSubarrayWithMaxSubarraySum {

    public static void main(String[] args) {
        int[] arr = { -2, -3, 4, -1, -2, 1, 5, -3 };
        for (int num : printMaxSubarraySumArray(arr))
            System.out.print(num + " ");
    }

    // T.C = O(N), S.C = O(1)
    private static int[] printMaxSubarraySumArray(int[] arr) {
        int maxSum = Integer.MIN_VALUE, sum = 0, ansSt = -1, ansEn = -1;
        int start = 0;
        for (int i = 0; i < arr.length; i++) {
            if (sum == 0)
                start = i;
            sum += arr[i];
            if (sum > maxSum) {
                maxSum = sum;
                ansSt = start;
                ansEn = i;
            }
            if (sum < 0)
                sum = 0;
        }
        return new int[] { ansSt, ansEn };
    }
}

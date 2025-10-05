package com.programming.striversheet.arrays.medium;

public class MaximumSubarraySum {

    public static void main(String[] args) {
        int[] arr = { -2, -3, 4, -1, -2, 1, 5, -3 };
        System.out.println(maxSubarraySum1(arr));
        System.out.println(maxSubarraySum2(arr));
        System.out.println(maxSubarraySum3(arr));
    }

    // T.C = O(N^3), S.C = O(1)
    private static int maxSubarraySum1(int[] arr) {
        int maxSum = Integer.MIN_VALUE;
        for (int i = 0; i < arr.length; i++) {
            for (int j = i; j < arr.length; j++) {
                int sum = 0;
                for (int k = i; k <= j; k++) {
                    sum += arr[k];
                }
                maxSum = Math.max(maxSum, sum);
            }
        }
        return maxSum;
    }

    // T.C = O(N^2), S.C = O(1)
    private static int maxSubarraySum2(int[] arr) {
        int maxSum = Integer.MIN_VALUE;
        for (int i = 0; i < arr.length; i++) {
            int sum = 0;
            for (int j = i; j < arr.length; j++) {
                sum += arr[j];
                maxSum = Math.max(maxSum, sum);
            }
        }
        return maxSum;
    }

    // ********** Kadane's Algo ***********
    //
    // assume max = Integer.min and sum = 0
    // Start iterating and add the element at index i to sum, compare with max and
    // update max.
    // But whenever sum < 0, no need to carry it forward as it will only hamper or
    // reduce the sum, so when sum < 0, reduce it to 0.
    // Add the next el to sum and compare with max.
    // If sum > 0, we need to carry it forward as it is a positive sum.
    // The reason for doing this is that till sum > 0, however small, it can do a
    // value addition and maximise the chances of getting a larger sum.
    private static int maxSubarraySum3(int[] arr) {
        int maxSum = Integer.MIN_VALUE, sum = 0;
        for (int i = 0; i < arr.length; i++) {
            if (sum < 0)
                sum = 0;
            sum += arr[i];
            maxSum = Math.max(maxSum, sum);
        }
        return maxSum;
    }
}

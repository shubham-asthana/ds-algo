package com.programming.dsalgo.arrays;

public class MaximumSubArraySum {

    public static void main(String[] args) {
        int[] nums = { -2, -3, 4, -1, -2, 1, 5, -3 };
        System.out.print(maximumSubArraySum(nums)[0] + " ");
        System.out.print(maximumSubArraySum(nums)[1]);
    }

    public static int[] maximumSubArraySum(int[] nums) {
        // Kadane's Algo
        int maxSum = Integer.MIN_VALUE;
        int sum = 0;
        int ansStart = -1, ansEnd = -1, start = -1;
        for (int i = 0; i < nums.length; i++) {
            if (sum == 0) {
                start = i;
            }
            sum += nums[i];
            if (sum < 0) {
                sum = 0;
            }
            if (sum > maxSum) {
                maxSum = Math.max(sum, maxSum);
                ansStart = start;
                ansEnd = i;
            }
        }
        return new int[] { ansStart, ansEnd };
    }
}

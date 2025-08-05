package com.programming.dsalgo.patterns.slidingwindow;

public class MaximumAverageSubArray1 {

    public static void main(String[] args) {
        int[] nums = { 1, 12, -5, -6, 50, 3 };
        System.out.println(findMaxAverage(nums, 4));
    }

    // Brute force
    private static double findMaxAverage1(int[] nums, int k) {
        double max = 0;
        for (int i = 0; i <= nums.length - k; i++) {
            int sum = 0;
            for (int j = i; j < i + k; j++) {
                sum += nums[j];
            }
            double avg = sum / (double) k;
            max = Math.max(max, avg);
        }
        return max;
    }

    // Sliding window
    private static double findMaxAverage(int[] nums, int k) {
        double maxAvg = 0;
        int winSum = 0;
        for (int i = 0; i < k; i++) {
            winSum += nums[i];
        }
        maxAvg = winSum / (double) k;

        for (int i = k; i < nums.length; i++) {
            winSum += nums[i] - nums[i - k];
            double avg = winSum / (double) k;
            maxAvg = Math.max(maxAvg, avg);
        }
        return maxAvg;
    }
}

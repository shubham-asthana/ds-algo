package com.programming.dsalgo.patterns.slidingwindow;

public class LongestSubArraySumLessThanEqualK {

    public static void main(String[] args) {
        int[] nums = { 1, 2, 1, 0, 1, 1, 0 };
        System.out.println(maxSubArrayLength(nums, 4));
    }

    // Brute force
    private static int maxSubArrayLength1(int[] nums, int target) {
        int max = 0;
        for (int i = 0; i < nums.length; i++) {
            int sum = 0;
            for (int j = i; j < nums.length; j++) {
                sum += nums[j];
                if (sum <= target) {
                    max = Math.max(max, j - i + 1);
                }
            }
        }
        return max;
    }

    // Sliding window
    private static int maxSubArrayLength(int[] nums, int target) {
        int start = 0, end = 0, maxLen = 0, sum = 0;
        while (end < nums.length) {
            sum += nums[end];
            while (sum > target) {
                sum -= nums[start];
                start++;
            }
            maxLen = Math.max(maxLen, end - start + 1);
            end++;
        }
        return maxLen;
    }
}

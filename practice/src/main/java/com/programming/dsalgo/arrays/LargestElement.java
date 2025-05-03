package com.programming.dsalgo.arrays;

public class LargestElement {

    public static void main(String[] args) {
        int[] arr = new int[] { 13, 46, 24, 52, 20, 9 };
        System.out.print(largestElement(arr));
    }

    private static int largestElement(int[] nums) {
        int max = Integer.MIN_VALUE;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > max) {
                max = nums[i];
            }
        }
        return max;
    }
}

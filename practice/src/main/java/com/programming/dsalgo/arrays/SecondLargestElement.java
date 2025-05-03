package com.programming.dsalgo.arrays;

public class SecondLargestElement {

    public static void main(String[] args) {
        // int[] arr = new int[] { 13, 46, 24, 52, 20, 9 };
        int[] arr = new int[] { 13, 13, 12, 13, 13, 13 };
        System.out.print(secondLargestElement(arr));
    }

    private static int secondLargestElement(int[] nums) {
        int largest = largestElement(nums);
        int secondLargestElement = -1;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > secondLargestElement && nums[i] != largest) {
                secondLargestElement = nums[i];
            }
        }
        return secondLargestElement;
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

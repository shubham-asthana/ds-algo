package com.programming.dsalgo.arrays;

public class MajorityElement {

    public static void main(String[] args) {
        int[] nums = { 1, 0, 1 };
        System.out.print(majorityElement(nums));
    }

    public static int majorityElement(int[] nums) {
        // Step 1: Moore's Voting ALgo
        int count = 0;
        int element = 0;

        for (int i = 0; i < nums.length; i++) {
            if (count == 0) {
                count = 1;
                element = nums[i];
            } else if (nums[i] == element) {
                count++;
            } else {
                count--;
            }
        }

        // Step 2: Iterate and check if element is max
        int maxCount = 0;
        for (int i = 0; i < nums.length; i++) {
            if (element == nums[i]) {
                maxCount++;
            }
        }
        if (maxCount > nums.length / 2) {
            return element;
        }
        return -1;
    }
}

package com.programming.dsalgo.patterns.twopointers;

import java.util.Arrays;

public class SortColors {

    public static void main(String[] args) {
        int[] nums = { 2, 1, 2, 0, 1, 0, 1, 0, 1 };
        for (int num : sortColors3(nums)) {
            System.out.print(num + " ");
        }
    }

    // Using sort
    private static int[] sortColors1(int[] nums) {
        Arrays.sort(nums);
        return nums;
    }

    // Using bucket sort
    private static int[] sortColors2(int[] nums) {
        int[] count = new int[3];
        for (int num : nums) {
            count[num]++;
        }

        int index = 0;
        for (int i = 0; i < 3; i++) {
            while (count[i] > 0) {
                nums[index++] = i;
                count[i]--;
            }
        }
        return nums;
    }

    // Using two pointers
    private static int[] sortColors3(int[] nums) {
        int left = 0, right = nums.length - 1, i = 0;
        while (i <= right) {
            if (nums[i] == 0) {
                swap(nums, left, i);
                left++;
            } else if (nums[i] == 2) {
                swap(nums, i, right);
                right--;
                i--;
            }
            i++;
        }
        return nums;
    }

    private static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}

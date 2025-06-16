package com.programming.dsalgo.arrays;

public class MoveZeros {

    public static void main(String[] args) {
        int[] nums = { 1, 0, 1 };
        moveZeroes(nums);
        for (int num : nums) {
            System.out.print(num + " ");
        }
    }

    public static void moveZeroes(int[] nums) {
        if (nums.length <= 1)
            return;
        for (int i = 0, j = 1; i < nums.length && j < nums.length;) {
            if (nums[i] == 0 && nums[j] != 0) {
                int temp = nums[i];
                nums[i] = nums[j];
                nums[j] = temp;
                i++;
                j++;
            } else if (nums[i] != 0) {
                i++;
                j++;
            } else {
                j++;
            }
        }
    }
}

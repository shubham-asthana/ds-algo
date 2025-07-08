package com.programming.dsalgo.arrays;

public class TwoSumSortedArray {

    public static void main(String[] args) {
        int[] arr = new int[] { 1, 2, 3, 4 };
        for (int i : twoSum(arr, 3)) {
            System.out.println(i);
        }
    }

    private static int[] twoSum(int[] nums, int target) {
        int[] res = new int[2];
        int l = 0, r = nums.length - 1;
        while (l <= r) {
            int currSum = nums[l] + nums[r];
            if (currSum < target) {
                l++;
            } else if (currSum > target) {
                r--;
            } else {
                res[0] = l + 1;
                res[1] = r + 1;
                return res;
            }
        }
        return res;
    }
}

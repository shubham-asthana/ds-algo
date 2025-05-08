package com.programming.dsalgo.arrays;

public class FindSingleNumber {

    public static void main(String[] args) {
        int[] arr = new int[] { 1, 2, 1, 2, 3 };
        System.out.print(findSingleNumber(arr));
    }

    private static int findSingleNumber(int[] nums) {
        int xor = 0;
        for (int i = 0; i < nums.length; i++) {
            xor ^= nums[i];
        }
        return xor;
    }
}

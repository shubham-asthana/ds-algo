package com.programming.dsalgo.arrays;

public class CheckArrayIsSorted {

    public static void main(String[] args) {
        int[] arr = new int[] { 1, 2, 4, 3, 5 };
        System.out.print(checkArrayIsSorted(arr));
    }

    private static boolean checkArrayIsSorted(int[] nums) {
        boolean isSorted = true;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] < nums[i - 1]) {
                isSorted = false;
                break;
            }
        }
        return isSorted;
    }
}

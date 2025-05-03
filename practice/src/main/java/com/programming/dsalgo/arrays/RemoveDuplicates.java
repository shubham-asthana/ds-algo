package com.programming.dsalgo.arrays;

public class RemoveDuplicates {

    public static void main(String[] args) {
        int[] arr = new int[] { 1, 2, 2, 3, 5 };
        System.out.print(removeDuplicates(arr));
    }

    private static int removeDuplicates(int[] nums) {
        int uniqueElements = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] != nums[i - 1]) {
                nums[uniqueElements] = nums[i];
                uniqueElements++;
            }
        }
        return uniqueElements;
    }
}

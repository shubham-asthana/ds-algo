package com.programming.dsalgo.arrays;

import java.util.Arrays;

public class ProductExceptSelf {

    public static void main(String[] args) {
        int[] nums = { -1, 1, 0, -3, 3 };
        int[] res = productExceptSelf(nums);
        for (int num : res) {
            System.out.print(num + " ");
        }
    }

    // O(n ^ 2)
    // private static int[] productExceptSelf(int[] nums) {
    // int[] productArr = new int[nums.length];
    // for (int i = 0; i < nums.length; i++) {
    // int product = 1;
    // for (int j = 0; j < nums.length; j++) {
    // if (i != j) {
    // product *= nums[j];
    // }
    // }
    // productArr[i] = product;
    // }
    // return productArr;
    // }

    // O(n)
    private static int[] productExceptSelf(int[] nums) {
        int[] productArr = new int[nums.length];
        Arrays.fill(productArr, 1);
        int prefix = 1;
        for (int i = 0; i < nums.length; i++) {
            productArr[i] *= prefix;
            prefix *= nums[i];
        }
        int suffix = 1;
        for (int i = nums.length - 1; i >= 0; i--) {
            productArr[i] *= suffix;
            suffix *= nums[i];
        }
        return productArr;
    }
}

package com.programming.dsalgo.arrays;

public class TrappingRainWater {

    public static void main(String[] args) {
        int[] height = new int[] { 0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1 };
        System.out.println(trap(height));
    }

    // Brute Force - Unoptimized
    // private static int trap(int[] height) {
    // int trapped = 0;
    // int[] prefixMax = prefixMax(height);
    // int[] suffixMax = suffixMax(height);
    // for (int i = 0; i < height.length; i++) {
    // if (height[i] < prefixMax[i] && height[i] < suffixMax[i]) {
    // trapped += Math.min(prefixMax[i], suffixMax[i]) - height[i];
    // }
    // }
    // return trapped;
    // }

    // private static int[] prefixMax(int[] height) {
    // int[] prefixMax = new int[height.length];
    // prefixMax[0] = height[0];
    // for (int i = 1; i < height.length; i++) {
    // prefixMax[i] = Math.max(prefixMax[i - 1], height[i]);
    // }
    // return prefixMax;
    // }

    // private static int[] suffixMax(int[] height) {
    // int[] suffixMax = new int[height.length];
    // suffixMax[height.length - 1] = height[height.length - 1];
    // for (int i = height.length - 2; i >= 0; i--) {
    // suffixMax[i] = Math.max(suffixMax[i + 1], height[i]);
    // }
    // return suffixMax;
    // }

    // Two Pointers
    private static int trap(int[] height) {
        int left = 0, right = height.length - 1;
        int leftMax = height[left], rightMax = height[right];
        int trapped = 0;
        while (left < right) {
            if (leftMax < rightMax) {
                left++;
                leftMax = Math.max(leftMax, height[left]);
                trapped += leftMax - height[left];
            } else {
                right--;
                rightMax = Math.max(rightMax, height[right]);
                trapped += rightMax - height[right];
            }
        }
        return trapped;
    }
}

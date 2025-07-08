package com.programming.dsalgo.arrays;

public class ContainerWithMostWater {

    public static void main(String[] args) {
        int[] heights = new int[] { 1, 8, 6, 2, 5, 4, 8, 3, 7 };
        System.out.println(maxArea(heights));
    }

    private static int maxArea(int[] height) {
        // O(n^2)
        // int maxArea = Integer.MIN_VALUE;
        // for (int i = 0; i < height.length; i++) {
        // for (int j = i + 1; j < height.length; j++) {
        // int area = Math.min(height[i], height[j]) * (j - i);
        // maxArea = Math.max(maxArea, area);
        // }
        // }
        // return maxArea;

        // O(n)
        int maxArea = Integer.MIN_VALUE;
        int left = 0, right = height.length - 1;
        while (left < right) {
            int area = Math.min(height[left], height[right]) * (right - left);
            maxArea = Math.max(maxArea, area);
            if (height[left] < height[right])
                left++;
            else // For loop to end we need to check in either first or second condition to
                 // increment/decrement, else loop will continue
                right--;
        }
        return maxArea;
    }
}

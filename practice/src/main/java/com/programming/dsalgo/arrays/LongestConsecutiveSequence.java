package com.programming.dsalgo.arrays;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class LongestConsecutiveSequence {

    public static void main(String[] args) {
        int[] arr = new int[] { 0, 3, 7, 2, 5, 8, 4, 6, 0, 1 };
        System.out.println(longestConsecutive(arr));
    }

    private static int longestConsecutive(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        int longest = 1;
        Set<Integer> numSet = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            numSet.add(nums[i]);
        }

        for (int num : numSet) {
            if (!numSet.contains(num - 1)) {
                int count = 1;
                int curr = num;
                while (numSet.contains(curr + 1)) {
                    curr += 1;
                    count++;
                }
                longest = Math.max(longest, count);
            }
        }
        return longest;
    }

    private static int longestConsecutiveSorting(int[] nums) {
        int longest = 1;
        Arrays.sort(nums);
        int lastSmall = Integer.MIN_VALUE;
        int count = 1;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] - 1 == lastSmall) {
                lastSmall = nums[i];
                count += 1;
            } else if (nums[i] != lastSmall) {
                count = 1;
                lastSmall = nums[i];
            }
            longest = Math.max(longest, count);
        }

        return longest;
    }

    private static int longestConsecutiveBruteForce(int[] nums) {
        int longest = 1;
        for (int i = 0; i < nums.length; i++) {
            int curr = nums[i];
            int count = 0;
            while (linearSearch(nums, curr)) {
                curr += 1;
                count += 1;
            }
            longest = Math.max(longest, count);
        }
        return longest;
    }

    private static boolean linearSearch(int[] nums, int k) {
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == k) {
                return true;
            }
        }
        return false;
    }
}

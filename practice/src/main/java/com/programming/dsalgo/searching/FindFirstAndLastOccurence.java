package com.programming.dsalgo.searching;

public class FindFirstAndLastOccurence {

    public static void main(String[] args) {
        int[] nums = new int[] { 5, 7, 7, 8, 8, 10 };
        int[] res = searchRange(nums, 11);
        for (int num : res) {
            System.out.print(num + " ");
        }
    }

    private static int[] searchRange(int[] nums, int target) {
        if (!isPresent(nums, target))
            return new int[] { -1, -1 };
        int lower = lowerBound(nums, target);
        int upper = upperBound(nums, target) - 1;
        return new int[] { lower, upper };
    }

    private static boolean isPresent(int[] nums, int target) {
        int low = 0, high = nums.length - 1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (nums[mid] == target) {
                return true;
            }
            if (nums[mid] > target) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return false;
    }

    private static int lowerBound(int[] nums, int target) {
        int lower = nums.length;
        int low = 0, high = nums.length - 1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (nums[mid] >= target) {
                lower = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return lower;
    }

    private static int upperBound(int[] nums, int target) {
        int upper = nums.length;
        int low = 0, high = nums.length - 1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (nums[mid] > target) {
                upper = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return upper;
    }
}

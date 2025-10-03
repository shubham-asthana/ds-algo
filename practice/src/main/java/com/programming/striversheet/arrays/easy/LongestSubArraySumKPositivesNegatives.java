package com.programming.striversheet.arrays.easy;

import java.util.HashMap;
import java.util.Map;

public class LongestSubArraySumKPositivesNegatives {

    public static void main(String[] args) {
        int[] arr = { 1, 2, 3, 1, 1, 1, 1, 4, 2, 3 };
        System.out.println(longestSubarraySum1(arr, 3));
        System.out.println(longestSubarraySum2(arr, 3));
        System.out.println(longestSubarraySum3(arr, 3));
        int[] arr1 = { 2, 0, 0, 3 };
        System.out.println(longestSubarraySum3(arr1, 3));
        System.out.println(longestSubarraySum4(arr, 3));
        System.out.println(longestSubarraySum4(arr1, 3));
    }

    // Generating all subarrays and adding them
    // T.C = ~O(n^3)
    private static int longestSubarraySum1(int[] arr, int s) {
        int maxLen = 0;
        for (int i = 0; i < arr.length; i++) {
            for (int j = i; j < arr.length; j++) {
                int sum = 0;
                for (int k = i; k <= j; k++) {
                    sum += arr[k];
                }
                if (sum == s) {
                    maxLen = Math.max(maxLen, j - i + 1);
                }
            }
        }
        return maxLen;
    }

    // Generating all subarrays and adding them
    // T.C = ~O(n^2)
    private static int longestSubarraySum2(int[] arr, int k) {
        int maxLen = 0;
        for (int i = 0; i < arr.length; i++) {
            int sum = 0;
            for (int j = i; j < arr.length; j++) {
                sum += arr[j];
                if (sum == k) {
                    maxLen = Math.max(maxLen, j - i + 1);
                }
            }
        }
        return maxLen;
    }

    // Using hashing - refer paper notes as well for simulation of prefix sum.
    // If there exists a subarray with sum k as current(.) as the last element. Now
    // sum till that current(.) = prefix sum, let's say its x and there might be
    // subarray from one of the other previous dots to the current(.) = k. then the
    // sum of the remaining previous subarray from start to that . will be x-k.
    // This code is better than previous solution but if arr has zeros, then it will
    // not work correctly unless we add condition to check if map already has sum in
    // line 76.
    // This is the most optimal solution when arr has positives, negatives and
    // zeros.
    // T.C = O(N), in worst case O(N^2) as in worst case map operations would take
    // O(N) for map. S.C = O(N) - for all prefix sums.
    private static int longestSubarraySum3(int[] arr, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        int sum = 0, maxLen = 0;
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
            if (sum == k) {
                maxLen = Math.max(maxLen, i + 1);
            }
            int rem = sum - k;
            if (map.containsKey(rem)) {
                int len = i - map.get(rem);
                maxLen = Math.max(maxLen, len);
            }
            if (!map.containsKey(sum)) // when arr contains zeros we should not update the indexes otherwise we will
                                       // not get the longest. for {2,0,0,3} and k = 3, if this condition does not
                                       // exist we will get length as 1 but it should be 3.
                map.put(sum, i);
        }
        return maxLen;
    }

    // Using two pointer or sliding window - most optimal for positives + zeros
    // case.
    // T.C = O(N) for outer while, but for inner while it varies and is not always
    // O(N) because inner while is to move the left pointer which does happen until
    // sum > k, so it adds N operations at max and not always mutliplies N
    // operations for each outer while iteration. Therefore, total T.C = O(2N).
    // S.C = O(1).
    private static int longestSubarraySum4(int[] arr, int k) {
        int left = 0, right = 0;
        int sum = arr[0], maxLen = 0;
        while (right < arr.length) {
            while (left <= right && sum > k) {
                sum -= arr[left];
                left++;
            }
            if (sum == k)
                maxLen = Math.max(maxLen, right - left + 1);
            right++;
            if (right < arr.length)
                sum += arr[right];
        }
        return maxLen;
    }
}

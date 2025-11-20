package com.programming.dsalgo.arrays;

import java.util.HashMap;
import java.util.Map;

public class SubArraySumK {

    public static void main(String[] args) {
        int[] nums = { 1, 2, 3 };
        System.out.print(subarraySumK(nums, 3));
    }

    public static int subarraySumK(int[] nums, int k) {
        // O(n^2)
        // int count = 0;
        // for (int i = 0; i < nums.length; i++) {
        // int sum = 0;
        // for (int j = i; j < nums.length; j++) {
        // sum += nums[j];
        // if (sum == k) {
        // count++;
        // break;
        // }
        // }
        // }
        // return count;

        // Prefix Sum
        Map<Integer, Integer> prefixSumMap = new HashMap<>();
        int prefixSum = 0, count = 0;
        prefixSumMap.put(0, 1);
        for (int i = 0; i < nums.length; i++) {
            prefixSum += nums[i];
            int remove = prefixSum - k;
            if (prefixSumMap.containsKey(remove)) {
                count += prefixSumMap.get(remove);
            }
            if (prefixSumMap.containsKey(prefixSum)) {
                prefixSumMap.put(prefixSum, prefixSumMap.get(prefixSum) + 1);
            } else {
                prefixSumMap.put(prefixSum, 1);
            }
        }
        return count;
    }
}

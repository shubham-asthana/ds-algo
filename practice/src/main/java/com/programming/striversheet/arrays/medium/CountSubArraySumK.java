package com.programming.striversheet.arrays.medium;

import java.util.HashMap;
import java.util.Map;

public class CountSubArraySumK {

    public static void main(String[] args) {
        int[] nums = { 1, 2, 3, -3, 1, 1, 1, 4, 2, -3 };
        System.out.println(subarraySum1(nums, 3));
        System.out.println(subarraySum2(nums, 3));
        System.out.println(subarraySum3(nums, 3));
    }

    // T.C = ~O(N^3), S.C = O(1)
    private static int subarraySum1(int[] nums, int k) {
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            for (int j = i; j < nums.length; j++) {
                int sum = 0;
                for (int k1 = i; k1 <= j; k1++) { // loop from i to j to accumulate the sum of elements for a subarray.
                    sum += nums[k1];
                }
                if (sum == k)
                    count++;
            }
        }
        return count;
    }

    // T.C = ~O(N^2), S.C = O(1)
    private static int subarraySum2(int[] nums, int k) {
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            int sum = 0;
            for (int j = i; j < nums.length; j++) {
                sum += nums[j]; // just add the new element, no need to separately accumulate as in previous
                                // solution.
                if (sum == k)
                    count++;
            }
        }
        return count;
    }

    // *********** Prefix Sum ************
    // Till an index i -> prefix sum (sum of all elements up till that index -
    // inclusive) is x
    // Probably there exists a subarray with sum k, before x
    // Thus, there will exists a subarray with sum x-k, because (x - k) + k = x =>
    // prefix sum.
    // Note that there can be more than one subarray with sum k till prefix sum
    // index => same no. of x-k subarrays with sum x - k exists.
    // Thus, instead of looking for how many subarrays with sum k exists(becuase it
    // will be somehwere in between based on our assumption), we will look for how
    // many subarrays with sum x-k exist, as it starts from beginning.
    // We have taken this approach as its easy to calculate the prefix sum but
    // difficult to calculate the in between sum.
    // T.C = O(N), S.C = O(N)
    private static int subarraySum3(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>(); // stores prefixSum -> count (prefix sum is key, count is the
                                                     // value)
        int prefixSum = 0, count = 0;
        map.put(0, 1); // initially when we start we do not pick any element so prefix sum is 0 -> add
                       // to map an entry 0,1 (count of array having
                       // prefix sum as 0 = 1).
        for (int i = 0; i < nums.length; i++) {
            prefixSum += nums[i];
            int remove = prefixSum - k;
            count += map.getOrDefault(remove, 0);
            map.put(prefixSum, map.getOrDefault(prefixSum, 0) + 1);
        }
        return count;
    }
}

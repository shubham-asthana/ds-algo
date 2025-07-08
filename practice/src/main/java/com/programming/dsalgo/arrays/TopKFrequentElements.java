package com.programming.dsalgo.arrays;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TopKFrequentElements {

    public static void main(String[] args) {
        int[] arr = new int[] { 1, 2, 2, 3, 3, 3 };
        for (int i : topKFrequent(arr, 2)) {
            System.out.println(i);
        }
    }

    private static int[] topKFrequent(int[] nums, int k) {
        int[] res = new int[k];
        Map<Integer, Integer> freqMap = new HashMap<>();
        for (int num : nums) {
            freqMap.put(num, freqMap.getOrDefault(num, 0) + 1);
        }

        List<Integer>[] bucketArr = new List[nums.length + 1];
        for (int i = 0; i < bucketArr.length; i++) {
            bucketArr[i] = new ArrayList<>();
        }

        for (Map.Entry<Integer, Integer> entry : freqMap.entrySet()) {
            bucketArr[entry.getValue()].add(entry.getKey());
        }

        int last = bucketArr.length;
        int j = 0;
        for (int i = last; i > 0 && j < k; i--) {
            if (bucketArr[i].isEmpty()) {
                continue;
            } else {
                for (int num : bucketArr[i]) {
                    res[j++] = num;
                    if (j > k) {
                        return res;
                    }
                }
            }
        }
        return res;
    }
}

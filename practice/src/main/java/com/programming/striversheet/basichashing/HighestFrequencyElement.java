package com.programming.striversheet.basichashing;

import java.util.HashMap;
import java.util.Map;

public class HighestFrequencyElement {

    public static void main(String[] args) {
        int[] nums = { 4, 4, 5, 5, 6 };
        System.out.println(mostFrequentElement1(nums));
        System.out.println(mostFrequentElement2(nums));
    }

    private static int mostFrequentElement1(int[] nums) {
        int highest = 0;
        int res = nums[0];
        for (int i = 0; i < nums.length; i++) {
            int count = 0;
            for (int j = i; j < nums.length; j++) {
                if (nums[i] == nums[j])
                    count++;
            }
            if (count > highest || (count == highest && nums[i] < res)) {
                highest = count;
                res = nums[i];
            }
        }
        return res;
    }

    private static int mostFrequentElement2(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        int highest = 0;
        int res = nums[0];
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
            int count = map.get(nums[i]);
            if (count > highest || (count == highest && nums[i] < res)) {
                highest = count;
                res = nums[i];
            }
        }
        return res;
    }
}

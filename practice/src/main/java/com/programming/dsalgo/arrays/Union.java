package com.programming.dsalgo.arrays;

import java.util.ArrayList;
import java.util.List;

public class Union {

    public static void main(String[] args) {
        int[] nums1 = { 1, 1, 3, 4, 9 };
        int[] nums2 = { 1, 2, 7 };
        int[] nums = unionArray(nums1, nums2);
        for (int num : nums) {
            System.out.print(num + " ");
        }
    }

    private static int[] unionArray(int[] nums1, int[] nums2) {
        if (null == nums1 || nums1.length == 0) {
            return nums2;
        }
        if (null == nums2 || nums2.length == 0) {
            return nums1;
        }
        List<Integer> unionArray = new ArrayList<>();
        int i = 0, j = 0;
        while (i < nums1.length && j < nums2.length) {
            if (nums1[i] == nums2[j] && !unionArray.contains(nums1[i])) {
                unionArray.add(nums1[i]);
                i++;
                j++;
            } else if (nums1[i] < nums2[j] && !unionArray.contains(nums1[i])) {
                unionArray.add(nums1[i]);
                i++;
            } else if (nums1[i] > nums2[j] && !unionArray.contains(nums2[j])) {
                unionArray.add(nums2[j]);
                j++;
            } else if (unionArray.contains(nums1[i])) {
                i++;
            } else if (unionArray.contains(nums2[j])) {
                j++;
            }
        }
        while (i < nums1.length) {
            unionArray.add(nums1[i]);
            i++;
        }
        while (j < nums2.length) {
            unionArray.add(nums2[j]);
            j++;
        }
        return unionArray.stream().mapToInt(Integer::intValue).toArray();
    }
}

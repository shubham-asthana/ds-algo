package com.programming.dsalgo.arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class IntersectionOfTwoArraysII {

    public static void main(String[] args) {
        int[] nums1 = new int[] { 1, 2, 3, 4 };
        int[] nums2 = new int[] { 1, 2, 3 };
        int[] res = intersect(nums1, nums2);
        for (int i : res) {
            System.out.println(i);
        }
    }

    // Brute Force
    // public static int[] intersect(int[] nums1, int[] nums2) {
    // List<Integer> result = new ArrayList<>();
    // Arrays.sort(nums1);
    // Arrays.sort(nums2);
    // int[] visited = new int[nums2.length];
    // for (int i = 0; i < nums1.length; i++) {
    // for (int j = 0; j < nums2.length; j++) {
    // if (nums1[i] == nums2[j] && visited[j] == 0) {
    // result.add(nums1[i]);
    // visited[j] = 1;
    // break;
    // }
    // }
    // }
    // return result.stream().mapToInt(i -> i).toArray();
    // }

    public static int[] intersect(int[] nums1, int[] nums2) {
        List<Integer> result = new ArrayList<>();
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        int i = 0, j = 0;
        while (i < nums1.length && j < nums2.length) {
            if (nums1[i] > nums2[j]) {
                j++;
            } else if (nums1[i] < nums2[j]) {
                i++;
            } else {
                result.add(nums1[i]);
                i++;
                j++;
            }
        }
        return result.stream().mapToInt(Integer::intValue).toArray();
    }
}

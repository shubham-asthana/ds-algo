package com.programming.striversheet.arrays.medium;

import java.util.HashMap;
import java.util.Map;

public class TwoSum {

    public static void main(String[] args) {
        int[] arr = { 2, 6, 5, 8, 11 };
        System.out.println(twoSum11(arr, 14));
        System.out.println(twoSum12(arr, 14));
        for (int index : twoSum21(arr, 14))
            System.out.print(index + " ");
        System.out.println();
        for (int index : twoSum22(arr, 14))
            System.out.print(index + " ");
    }

    // T.C = O(N^2)
    private static boolean twoSum11(int[] arr, int target) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[i] + arr[j] == target)
                    return true;
            }
        }
        return false;
    }

    // T.C = O(N), S.C = O(N)
    // For this variant we can sort and then use two pointer approach but for that
    // T.C = O(N) + O(NlogN), S.C = O(1) as no map required but since we are
    // changint the array so O(N)
    private static boolean twoSum12(int[] arr, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            int comp = target - arr[i];
            if (map.containsKey(comp))
                return true;
            else
                map.put(arr[i], i);
        }
        return false;
    }

    // T.C = O(N^2)
    private static int[] twoSum21(int[] arr, int target) {
        int[] res = new int[2];
        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[i] + arr[j] == target) {
                    res[0] = i;
                    res[1] = j;
                }
            }
        }
        return res;
    }

    // T.C = O(N), S.C = O(N)
    private static int[] twoSum22(int[] arr, int target) {
        int[] res = new int[2];
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            int comp = target - arr[i];
            if (map.containsKey(comp)) {
                res[0] = i;
                res[1] = map.get(comp);
            } else
                map.put(arr[i], i);
        }
        return res;
    }
}

package com.programming.striversheet.arrays.easy;

import java.util.HashMap;
import java.util.Map;

public class SingleNumber {

    public static void main(String[] args) {
        int[] arr = { 1, 1, 2, 3, 3, 4, 4 };
        System.out.println(findSingleNumber1(arr));
        System.out.println(findSingleNumber2(arr));
        System.out.println(findSingleNumber3(arr));
        System.out.println(findSingleNumber4(arr));
    }

    // Brute - Linear search
    // T.C = O(n^2)
    private static int findSingleNumber1(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            int count = 0;
            for (int j = 0; j < arr.length; j++) {
                if (arr[i] == arr[j])
                    count++;
            }
            if (count == 1)
                return arr[i];
        }
        return -1;
    }

    // Better - Using hashing
    // T.C = O(3N), S.C = O(maxEl))
    // But this only works fo el >= 0
    private static int findSingleNumber2(int[] arr) {
        int maxEl = arr[0];
        for (int i = 1; i < arr.length; i++) {
            maxEl = Math.max(maxEl, arr[i]);
        }
        int[] hash = new int[maxEl + 1];
        for (int i = 0; i < arr.length; i++) {
            hash[arr[i]]++;
        }
        for (int i = 0; i < hash.length; i++) {
            if (hash[i] == 1)
                return i;
        }
        return -1;
    }

    // Using hashmap
    // T.C = O(N + N/2 + 1), S.C = O(N/2 + 1)
    private static int findSingleNumber3(int[] arr) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < arr.length; i++) { // T.C = O(N)
            map.put(arr[i], map.getOrDefault(arr[i], 0) + 1);
        }
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) { // T.C = O(N/2 + 1)
            if (entry.getValue() == 1)
                return entry.getKey();
        }
        return -1;
    }

    // USing xor -> a ^ a = 0
    // T.C = O(N)
    private static int findSingleNumber4(int[] arr) {
        int xor = 0;
        for (int i = 0; i < arr.length; i++)
            xor ^= arr[i];
        return xor;
    }
}

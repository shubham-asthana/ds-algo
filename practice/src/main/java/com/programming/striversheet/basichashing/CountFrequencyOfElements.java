package com.programming.striversheet.basichashing;

import java.util.HashMap;
import java.util.Map;

public class CountFrequencyOfElements {

    public static void main(String[] args) {
        int[] arr = { 1, 2, 4, 2, 4 };
        System.out.println(countFrequency1(arr, 2));
        System.out.println(countFrequency2(arr, 4));
        System.out.println(countFrequency3(arr, 2));
    }

    // O(n)
    private static int countFrequency1(int[] arr, int number) {
        int count = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == number)
                count++;
        }
        return count;
    }

    private static int countFrequency2(int[] arr, int number) {
        int[] hash = new int[100];
        for (int i = 0; i < arr.length; i++) {
            hash[arr[i]]++;
        }
        return hash[number];
    }

    // Storing and fetching in avg case = O(1) for hashmap, O(n) for worst case
    private static int countFrequency3(int[] arr, int number) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            map.put(arr[i], map.getOrDefault(arr[i], 0) + 1);
        }
        return map.get(number);
    }
}

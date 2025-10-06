package com.programming.striversheet.arrays.medium;

import java.util.ArrayList;
import java.util.List;

public class LeadersInAnArray {

    public static void main(String[] args) {
        int[] arr = { 10, 22, 12, 3, 0, 6 };
        for (int num : leadersInAnArray1(arr))
            System.out.print(num + " ");
        System.out.println();
        for (int num : leadersInAnArray2(arr))
            System.out.print(num + " ");
    }

    // T.C = ~O(N^2), S.C = O(N) for ans
    private static int[] leadersInAnArray1(int[] arr) {
        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < arr.length; i++) {
            boolean leader = true;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] > arr[i]) {
                    leader = false;
                    break;
                }
            }
            if (leader)
                res.add(arr[i]);
        }
        return res.stream().mapToInt(Integer::intValue).toArray();
    }

    // T.C = O(N), S.C = O(N) for ans
    private static int[] leadersInAnArray2(int[] arr) {
        List<Integer> res = new ArrayList<>();
        int max = Integer.MIN_VALUE;
        for (int i = arr.length - 1; i >= 0; i--) {
            if (arr[i] > max) {
                max = arr[i];
                res.add(max);
            }
        }
        // If asked to return in the order elements come in array -> reverse the ans ->
        // O(N)
        // If asked to return in sorted order, sort the ans. - O(NlogN) => not required
        // when going from back of array.
        return res.stream().mapToInt(Integer::intValue).toArray();
    }
}

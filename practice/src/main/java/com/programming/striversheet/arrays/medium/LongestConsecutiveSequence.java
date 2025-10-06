package com.programming.striversheet.arrays.medium;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class LongestConsecutiveSequence {

    public static void main(String[] args) {
        int[] arr1 = { 102, 4, 100, 1, 101, 3, 2, 1, 1 };
        System.out.println(longestConsecutiveSequence1(arr1));
        int[] arr2 = { 100, 102, 100, 101, 101, 4, 3, 2, 3, 2, 1, 1, 1, 2 };
        System.out.println(longestConsecutiveSequence2(arr2));
        System.out.println(longestConsecutiveSequence3(arr2));
    }

    // Sequence -> numbers in array one after another in value but may or may not be
    // one after another in indexes
    // T.C = O(N^3), S.C = O(1)
    private static int longestConsecutiveSequence1(int[] arr) {
        int longest = 1;
        for (int i = 0; i < arr.length; i++) {
            int x = arr[i];
            int count = 1;
            while (linearSearch(arr, x + 1)) {
                x += 1;
                count++;
            }
            longest = Math.max(longest, count);
        }
        return longest;
    }

    private static boolean linearSearch(int[] arr, int num) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == num)
                return true;
        }
        return false;
    }

    // T.C = O(N + NlogN), S.C = O(N)
    private static int longestConsecutiveSequence2(int[] arr) {
        Arrays.sort(arr);
        int longest = 1, lastSmaller = Integer.MIN_VALUE, countCurr = 0;
        for (int i = 0; i < arr.length; i++) {
            int x = arr[i];
            if (lastSmaller + 1 == x) {
                countCurr++;
                lastSmaller = x;
            } else if (arr[i] != lastSmaller) {
                lastSmaller = x;
                countCurr = 1;
            }
            longest = Math.max(longest, countCurr);
        }
        return longest;
    }

    // T.C = O(1){Set} + O(N) + O(~2N{for checking sequence using while loop}) =>
    // O(3N) - assuming set takes O(1), if it takes logN the T.C increases and we
    // may fall back to the sorting solution. S.C =
    // O(N)
    private static int longestConsecutiveSequence3(int[] arr) {
        if (arr.length == 0)
            return 0;
        int longest = 1;
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < arr.length; i++)
            set.add(arr[i]);
        for (int num : set) {
            if (set.contains(num - 1)) // Since we have this check, thus in the while loop we are not checking for
                                       // every combination as we are ensuring only if x - 1 does not exist in the set
                                       // search for x+1, x+2 and so on. This reduces T.C from O(NxN) to O(~2N) for
                                       // while loop.
                                       // Ex: for {102, 4, 100, 1, 101, 3 ,2} in the set we run about 14 iterations, 7
                                       // for the the number of elements + 3 for 100 as 99 does not exist + 4 for 1 as
                                       // 0 does not exist.
                continue;
            int x = num, count = 1;
            while (set.contains(x + 1)) {
                count++;
                x += 1;
            }
            longest = Math.max(count, longest);
        }
        return longest;
    }
}

package com.programming.striversheet.arrays.medium;

import java.util.ArrayList;
import java.util.List;

public class RearrangeArrayElements {

    public static void main(String[] args) {
        int[] arr1 = { 3, 1, -2, -5, 2, -4 };
        rearrangeElements1(arr1);
        for (int num : arr1)
            System.out.print(num + " ");
        System.out.println();
        int[] arr2 = { 3, 1, -2, -5, 2, -4 };
        for (int num : rearrangeElements2(arr2))
            System.out.print(num + " ");
        System.out.println();
        int[] arr3 = { 1, 2, -4, -5, 3, 6 };
        for (int num : rearrangeElements3(arr3))
            System.out.print(num + " ");
    }

    // T.C = O(N + N/2), S.C = O(N) = {N/2 + N/2}
    private static void rearrangeElements1(int[] arr) {
        List<Integer> positives = new ArrayList<>();
        List<Integer> negatives = new ArrayList<>();
        for (int i = 0; i < arr.length; i++) { // O(N)
            if (arr[i] < 0)
                negatives.add(arr[i]);
            else
                positives.add(arr[i]);
        }
        for (int i = 0; i < arr.length / 2; i++) { // O(N/2)
            arr[2 * i] = positives.get(i);
            arr[2 * i + 1] = negatives.get(i);
        }
    }

    // Reducing 2-pass to 1-pass
    // T.C = O(N), S.C = O(N)
    private static int[] rearrangeElements2(int[] arr) {
        int[] res = new int[arr.length];
        int pos = 0, neg = 1;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] < 0) {
                res[neg] = arr[i];
                neg += 2;
            } else {
                res[pos] = arr[i];
                pos += 2;
            }
        }
        return res;
    }

    // Variety 2 where positives and negatives are not equal, so if any number is
    // left, add to the end without altering the order.
    // Hence we need to fallback to the brute force solution and not optimal as pos
    // != neg, either pos > neg or neg > pos.
    // T.C = O(N) + O(min(pos, neg)) + O(leftovers) = O(2N), S.C = O(N)
    private static int[] rearrangeElements3(int[] arr) {
        List<Integer> positives = new ArrayList<>();
        List<Integer> negatives = new ArrayList<>();
        for (int i = 0; i < arr.length; i++) { // O(N)
            if (arr[i] < 0)
                negatives.add(arr[i]);
            else
                positives.add(arr[i]);
        }
        if (positives.size() > negatives.size()) {
            for (int i = 0; i < negatives.size(); i++) {
                arr[2 * i] = positives.get(i);
                arr[2 * i + 1] = negatives.get(i);
            }
            int index = negatives.size() * 2;
            for (int i = negatives.size(); i < positives.size(); i++) {
                arr[index] = positives.get(i);
                index++;
            }
        } else {
            for (int i = 0; i < positives.size(); i++) {
                arr[2 * i] = positives.get(i);
                arr[2 * i + 1] = negatives.get(i);
            }
            int index = positives.size() * 2;
            for (int i = positives.size(); i < negatives.size(); i++) {
                arr[index] = negatives.get(i);
                index++;
            }
        }
        return arr;
    }
}

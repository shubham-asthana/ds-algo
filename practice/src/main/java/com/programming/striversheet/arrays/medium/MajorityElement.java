package com.programming.striversheet.arrays.medium;

import java.util.HashMap;
import java.util.Map;

public class MajorityElement {

    public static void main(String[] args) {
        int[] arr = { 2, 2, 3, 3, 1, 2, 2 };
        System.out.println(majorityElement1(arr));
        System.out.println(majorityElement2(arr));
        System.out.println(majorityElement3(arr));
    }

    // T.C = O(N^2)
    private static int majorityElement1(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            int count = 0;
            for (int j = 0; j < arr.length; j++) {
                if (arr[i] == arr[j])
                    count++;
            }
            if (count > arr.length / 2)
                return arr[i];
        }
        return -1;
    }

    // Since counting -> hashing
    // T.C = O(N), S.C = O(N)
    private static int majorityElement2(int[] arr) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < arr.length; i++)
            map.put(arr[i], map.getOrDefault(arr[i], 0) + 1);
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getValue() > arr.length / 2)
                return entry.getKey();
        }
        return -1;
    }

    // ************** Moore's voting algo ***************
    // Step 1:
    // We take two vars el and cnt, initally cnt = 0.
    // Now we start iterating, pick first el, suppose 2 and increase cnt by 1
    // In the next iteration if el is same as prev = 2, increase cnt by 1
    // If el is not same as prev = 3, reduce cnt by 1
    // Increase back again when you get el = 2
    // When count becomes 0, if you consider elements up till that index in the
    // array, then the selected el = 2 cannot be the majority element
    // Ex: el = 2, cnt = 0 -> i = 0, arr[0] = 2, cnt++, arr[1] = 2, cnt++, arr[2] =
    // 3, cnt--, arr[3] = 3, cnt-- => cnt = 0 till i=3 => selcted el = 2 is not
    // majority element in subarray {2,2,3,3} which is true.
    // When cnt becomes zeros, update el with the next arr[i] => el = 1 in our case.
    // Repeat the steps till cnt becomes 0
    // When iteration has ended and cnt != 0 => selected el can only be the majority
    // element, in our case it will be 2. cnt does not reprsent actual count of
    // majority element.

    // Step 2:
    // Iterate through the array again and verify the element that came as majority
    // is actually > n/2 times, if yes return el else return -1.

    // T.C = O(2N), S.C = O(1)
    private static int majorityElement3(int[] arr) {
        int el = 0, count = 0;
        for (int i = 0; i < arr.length; i++) {
            if (count == 0) {
                el = arr[i];
                count++;
            } else if (el == arr[i])
                count++;
            else
                count--;
        }
        // Below steps might not be needed if problem states that array always has
        // majority element => T.C = O(N)
        int cnt = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == el)
                cnt++;
        }
        if (cnt > arr.length / 2)
            return el;
        return -1;
    }
}

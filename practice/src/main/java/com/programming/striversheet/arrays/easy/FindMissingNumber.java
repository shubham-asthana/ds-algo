package com.programming.striversheet.arrays.easy;

// Incomplete
public class FindMissingNumber {

    public static void main(String[] args) {
        int[] arr = { 9, 6, 4, 2, 3, 5, 7, 0, 1 };
        System.out.println(missingNumber1(arr, 9));
        System.out.println(missingNumber2(arr, 9));
        System.out.println(missingNumber3(arr, 9));
        System.out.println(missingNumber4(arr, 9));
    }

    // Linear search
    // T.C = O(n ^ 2)
    private static int missingNumber1(int[] arr, int n) {
        for (int i = 0; i <= n; i++) {
            boolean flag = false;
            for (int j = 0; j < arr.length; j++) {
                if (arr[j] == i) {
                    flag = true;
                    break;
                }
            }
            if (!flag)
                return i;
        }
        return -1;
    }

    // Using hashing
    // T.C = 2xO(n), S.C = O(n)
    private static int missingNumber2(int[] arr, int n) {
        int[] hash = new int[n + 1];
        for (int i = 0; i < arr.length; i++)
            hash[arr[i]] = 1;
        for (int i = 0; i < hash.length; i++) {
            if (hash[i] == 0)
                return i;
        }
        return -1;
    }

    // Using sum formula -> Takes more space than xor solution, image n = 10^5,
    // cannot be stored in int, need to use a bigger datatype.
    // T.C = O(n)
    private static int missingNumber3(int[] arr, int n) {
        int sum1 = (n * (n + 1)) / 2;
        int sum2 = 0;
        for (int i = 0; i < arr.length; i++)
            sum2 += arr[i];
        return sum1 - sum2;
    }

    // Using XOR -> a ^ a = 0
    // T.C = O(n)
    private static int missingNumber4(int[] arr, int n) {
        int xor1 = 0;
        for (int i = 0; i < arr.length - 1; i++) {
            xor1 ^= arr[i];
        }
        int xor2 = 0;
        for (int i = 0; i <= n; i++) {
            xor2 ^= i;
        }
        return xor1 ^ xor2;

        // Instead of two loops, improving further
        // int xor1 = 0, xor2 = 0;
        // for (int i = 0; i < n - 1; i++) {
        // xor2 ^= arr[i];
        // xor1 ^= xor1 ^ (i);
        // }
        // xor1 ^= n;
        // return xor1 ^ xor2;
    }
}

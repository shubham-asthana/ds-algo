package com.programming.striversheet.arrays.easy;

import java.util.Arrays;

public class SecondLargest {

    public static void main(String[] args) {
        int[] arr = { 1, 7, 5, 2, 6, 2, 4, 3 };
        System.out.println(findSecondLargest1(arr));
        System.out.println(findSecondLargest2(arr));
        System.out.println(findSecondLargest3(arr));
        System.out.println(findSecondSmallest(arr));
    }

    // T.C = O(nlogn) + O(n)
    private static int findSecondLargest1(int[] arr) {
        Arrays.sort(arr);
        int largest = arr[arr.length - 1];
        int secondLargest = 0;
        for (int i = arr.length - 2; i >= 0; i--) {
            if (arr[i] < largest) {
                secondLargest = arr[i];
                break;
            }
        }
        return secondLargest;
    }

    // T.C = O(n) + O(n)
    private static int findSecondLargest2(int[] arr) {
        // find largest
        int largest = arr[0];
        for (int i = 1; i < arr.length; i++) {
            largest = Math.max(largest, arr[i]);
        }

        // find second largest
        int secondLargest = Integer.MIN_VALUE;
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > secondLargest && arr[i] < largest) {
                secondLargest = arr[i];
            }
        }
        return secondLargest;
    }

    // T.C = O(n)
    private static int findSecondLargest3(int[] arr) {
        int largest = arr[0], secondLargest = Integer.MIN_VALUE;
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > largest) {
                secondLargest = largest;
                largest = arr[i];
            } else if (arr[i] < largest && arr[i] > secondLargest) {
                secondLargest = arr[i];
            }
        }
        return secondLargest;
    }

    // T.C = O(n)
    private static int findSecondSmallest(int[] arr) {
        int smallest = arr[0], secondSmallest = Integer.MAX_VALUE;
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] < smallest) {
                secondSmallest = smallest;
                smallest = arr[i];
            } else if (arr[i] > smallest && arr[i] < secondSmallest) {
                secondSmallest = arr[i];
            }
        }
        return secondSmallest;
    }
}

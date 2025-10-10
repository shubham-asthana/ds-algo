package com.programming.striversheet.arrays.medium;

import java.util.List;

public class SpiralTraversalOfMatrix {

    public static void main(String[] args) {
        int[][] arr1 = new int[][] { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 } };
        for (int num : spiralOrder(arr1))
            System.out.print(num + " ");
        System.out.println();
        int[][] arr2 = new int[][] { { 1, 2, 3, 4 }, { 5, 6, 7, 8 }, { 9, 10, 11, 12 } };
        for (int num : spiralOrder(arr2))
            System.out.print(num + " ");
    }

    private static List<Integer> spiralOrder(int[][] matrix) {

    }
}

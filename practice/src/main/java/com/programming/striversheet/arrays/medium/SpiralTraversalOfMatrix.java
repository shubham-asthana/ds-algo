package com.programming.striversheet.arrays.medium;

import java.util.ArrayList;
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

    // right -> bottom -> left -> top
    // initially, left = 0, right = n - 1, top = 0, bottom = n - 1
    // T.C = O(N * M). S.C = O(N * M) for ans
    private static List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> result = new ArrayList<>();
        int left = 0, right = matrix[0].length - 1, top = 0, bottom = matrix.length - 1;
        while (top <= bottom && left <= right) {
            for (int i = left; i <= right; i++) {
                result.add(matrix[top][i]);
            }
            top++;
            for (int i = top; i <= bottom; i++) {
                result.add(matrix[i][right]);
            }
            right--;
            if (top <= bottom) { // iterate from right to left only if top has not exceeded bottom => row is
                                 // there to print. If only one row, this loop wil not run.
                for (int i = right; i >= left; i--) {
                    result.add(matrix[bottom][i]);
                }
                bottom--;
            }
            if (left <= right) { // If there are columns left then print, else skip
                for (int i = bottom; i >= top; i--) {
                    result.add(matrix[i][left]);
                }
                left++;
            }
        }
        return result;
    }
}

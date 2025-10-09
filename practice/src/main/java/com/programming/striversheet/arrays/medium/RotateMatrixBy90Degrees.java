package com.programming.striversheet.arrays.medium;

// Rotate Image
public class RotateMatrixBy90Degrees {

    public static void main(String[] args) {
        // Square matrix
        int[][] matrix1 = new int[][] { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 } };
        printMatrix(matrix1);
        System.out.println();
        rotate1(matrix1);
        printMatrix(matrix1);
        System.out.println();

        int[][] matrix2 = new int[][] { { 5, 1, 9, 11 }, { 2, 4, 8, 10 }, { 13, 3, 6, 7 }, { 15, 14, 12, 16 } };
        printMatrix(matrix2);
        System.out.println();
        rotate2(matrix2);
        printMatrix(matrix2);
    }

    private static void printMatrix(int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }

    // Brute force is to create a ans matrix and either copy that back to ques
    // matrix or return ans matrix.
    // Pick each element and put it in its correct place.
    // Basically copy each element of a row to its correct column
    // => i,j => j,n-1-i, 0,0 -> 0,3 | 0,1 -> 1,3
    // T.C = O(N^2), S.C = O(N^2)
    public static void rotate1(int[][] matrix) {
        int rLen = matrix.length, cLen = matrix[0].length;
        int[][] ans = new int[rLen][cLen];
        for (int i = 0; i < rLen; i++) {
            for (int j = 0; j < cLen; j++)
                ans[j][rLen - 1 - i] = matrix[i][j];
        }
        for (int i = 0; i < rLen; i++) {
            for (int j = 0; j < cLen; j++)
                matrix[i][j] = ans[i][j];
        }
    }

    // We need to optimise this for space.
    // Observe that each column becomes a row but in reverse order -> col[0] =>
    // row[0]
    // We need to first transpose the matrix => rows become columns, columns become
    // rows. For transponse no need to touch diagonal and swap elements after
    // diagonal with elements before diagonal.
    // Reverse each row then.
    // T.C = O(N/2 * N/2) + O(N * N/2). S.C = O(1)
    public static void rotate2(int[][] matrix) {
        int rLen = matrix.length, cLen = matrix[0].length;
        for (int i = 0; i < rLen - 1; i++) { // not going till last row index as it lies on a diagonal of a square
                                             // matrix.
            for (int j = i + 1; j < cLen; j++) { // always starts from one element ahead
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }
        for (int i = 0; i < rLen; i++) {
            int left = 0, right = cLen - 1;
            while (left <= right) {
                int temp = matrix[i][left];
                matrix[i][left] = matrix[i][right];
                matrix[i][right] = temp;
                left++;
                right--;
            }
        }
    }
}

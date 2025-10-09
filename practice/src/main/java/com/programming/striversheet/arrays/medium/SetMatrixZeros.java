package com.programming.striversheet.arrays.medium;

public class SetMatrixZeros {

    public static void main(String[] args) {
        int[][] matrix1 = new int[][] { { 1, 1, 1 }, { 1, 0, 1 }, { 1, 1, 1 } };
        setZeros1(matrix1);
        printMatrix(matrix1);
        System.out.println();

        int[][] matrix2 = new int[][] { { 0, 1, 2, 0 }, { 3, 4, 5, 2 }, { 1, 3, 1, 5 } };
        setZeros2(matrix2);
        printMatrix(matrix2);
        System.out.println();

        int[][] matrix3 = new int[][] { { 0, 1, 2, 0 }, { 3, 4, 5, 2 }, { 1, 3, 1, 5 } };
        setZeros3(matrix3);
        printMatrix(matrix3);
    }

    private static void printMatrix(int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }

    // T.C = O(N * M * (N+M) + N * M) ~ O(N^3), S.C = O(1)
    private static void setZeros1(int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (matrix[i][j] == 0) {
                    // Marking non-zeros elements as -1 for the row and col where we encounter a
                    // zero.
                    markRow(i, matrix);
                    markCol(j, matrix);
                }
            }
        }
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (matrix[i][j] == -1)
                    matrix[i][j] = 0;
            }
        }
    }

    private static void markRow(int i, int[][] matrix) {
        for (int j = 0; j < matrix[i].length; j++) {
            if (matrix[i][j] != 0)
                matrix[i][j] = -1;
        }
    }

    private static void markCol(int j, int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            if (matrix[i][j] != 0)
                matrix[i][j] = -1;
        }
    }

    // T.C = O(2 * N * M), S.C = O(N) + O(M)
    private static void setZeros2(int[][] matrix) {
        int[] row = new int[matrix.length];
        int[] col = new int[matrix[0].length];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (matrix[i][j] == 0) {
                    row[i] = 1;
                    col[j] = 1;
                }
            }
        }
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (row[i] == 1 || col[j] == 1) { // or condition because if either row has been marked or column has
                                                  // been marked as 1 set entire row or column to 0, if we put and
                                                  // condition, we will arrive only at the exact element which is 1 in
                                                  // the matrix, thus matrix won't change. I earlier made a mistake and
                                                  // put and but later did a hit and try with or, before I understood
                                                  // the reason.
                    matrix[i][j] = 0;
                }
            }
        }
    }

    // Either watch the optimized solution again or do it on paper while doing
    // revision.
    // The most optimal solution cannot have T.C better than N*M, so we need to
    // optimise for S.C.
    // Instead of taking two separate arrays for row and col, we assume first col =
    // row[n], first row = col[m];
    // But if we see carefully, this is wrong as there is an intersection for
    // matrix[0][0] -> collision.
    // Now what we do is we consider for forst row, we consider column from col[1]
    // instead of col[0].
    // For this extra element, we can create a variable like col0.
    // Another thing is if we start from index 0,0 we will get incorrect answer for
    // first element and first row, last col.
    // Therefore fo not touch the first row and col elements, start iteration from
    // end or from i = 1, j = 1.
    // Then first convert the first row, then convert first col, otherwise chances
    // of getting incorrect answer for first row, last col element
    // T.C = O(2 * N * M)
    private static void setZeros3(int[][] matrix) {
        // int[] row = new int[matrix.length]; -> matrix[...][0]
        // int[] col = new int[matrix[0].length]; -> matrix[0][...]
        int col0 = 1;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (matrix[i][j] == 0) {
                    // mark ith row
                    matrix[i][0] = 0;
                    // mark the jth col
                    if (j != 0)
                        matrix[0][j] = 0;
                    else
                        col0 = 0;
                }
            }
        }
        for (int i = 1; i < matrix.length; i++) {
            for (int j = 1; j < matrix[i].length; j++) {
                if (matrix[i][j] != 0) {
                    // check for col and row
                    if (matrix[0][j] == 0 || matrix[i][0] == 0)
                        matrix[i][j] = 0;
                }
            }
        }
        if (matrix[0][0] == 0) {
            for (int j = 0; j < matrix[0].length; j++)
                matrix[0][j] = 0;
        }
        if (col0 == 0) {
            for (int i = 0; i < matrix.length; i++)
                matrix[i][0] = 0;
        }
    }
}

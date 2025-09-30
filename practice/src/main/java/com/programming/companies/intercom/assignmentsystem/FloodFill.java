package com.programming.companies.intercom.assignmentsystem;

public class FloodFill {

    public static int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        int oldColor = image[sr][sc];
        if (oldColor == newColor)
            return image; // no change needed

        dfs(image, sr, sc, oldColor, newColor);
        return image;
    }

    private static void dfs(int[][] image, int r, int c, int oldColor, int newColor) {
        // boundary check
        if (r < 0 || c < 0 || r >= image.length || c >= image[0].length)
            return;
        // only fill oldColor
        if (image[r][c] != oldColor)
            return;

        // fill
        image[r][c] = newColor;

        // recursive neighbors
        dfs(image, r + 1, c, oldColor, newColor);
        dfs(image, r - 1, c, oldColor, newColor);
        dfs(image, r, c + 1, oldColor, newColor);
        dfs(image, r, c - 1, oldColor, newColor);
    }

    // ---------------- DEMO ----------------
    public static void main(String[] args) {
        int[][] image = {
                { 1, 1, 1 },
                { 1, 1, 0 },
                { 1, 0, 1 }
        };

        int sr = 1, sc = 1, newColor = 2;
        int[][] result = floodFill(image, sr, sc, newColor);

        // print updated image
        for (int[] row : result) {
            for (int val : row) {
                System.out.print(val + " ");
            }
            System.out.println();
        }
    }
}

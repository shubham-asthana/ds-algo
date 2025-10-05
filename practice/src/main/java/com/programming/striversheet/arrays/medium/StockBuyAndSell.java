package com.programming.striversheet.arrays.medium;

public class StockBuyAndSell {

    public static void main(String[] args) {
        int[] arr = { 7, 1, 5, 3, 6, 4 };
        System.out.println(maxProfit1(arr));
    }

    // If you are selling on ith day, then you must buy when price is minimum (from
    // i = 0 to i-1)th day.
    // Since need to maximise profit, will not buy and sell on the same day
    // T.C = O(n), S.C = O(1)
    private static int maxProfit1(int[] arr) {
        int min = arr[0], profit = 0;
        for (int i = 1; i < arr.length; i++) {
            int cost = arr[i] - min;
            profit = Math.max(profit, cost);
            min = Math.min(min, arr[i]); // DP - remembering the min throughtout the array.
        }
        return profit;
    }
}

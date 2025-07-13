package com.programming.dsalgo.intervals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MergeIntervals {

    public static void main(String[] args) {
        int[][] intervals = new int[][] { { 1, 3 }, { 2, 5 }, { 4, 6 } };
        int[][] res = merge(intervals);
        for (int i = 0; i < res.length; i++) {
            System.out.println("[" + res[i][0] + ", " + res[i][1] + "]");
        }
    }

    private static int[][] merge(int[][] intervals) {
        if (intervals.length == 1) {
            return intervals;
        }
        List<int[]> merged = new ArrayList<>();
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));
        merged.add(intervals[0]);
        for (int[] interval : intervals) {
            int start = interval[0], end = interval[1];
            int n = merged.size() - 1;
            if (merged.get(n)[1] >= start) {
                merged.get(n)[1] = Math.max(merged.get(n)[1], end);
            } else {
                merged.add(interval);
            }
        }
        return merged.toArray(new int[merged.size()][]);
    }
}

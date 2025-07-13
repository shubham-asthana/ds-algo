package com.programming.dsalgo.intervals;

import java.util.ArrayList;
import java.util.List;

public class InsertInterval {

    public static void main(String[] args) {
        int[][] intervals = new int[][] { { 1, 3 }, { 4, 6 } };
        int[] newInterval = new int[] { 2, 5 };
        int[][] res = insert(intervals, newInterval);
        for (int i = 0; i < res.length; i++) {
            System.out.println("[" + res[i][0] + ", " + res[i][1] + "]");
        }
    }

    // Greedy
    private static int[][] insert(int[][] intervals, int[] newInterval) {
        if (intervals.length == 0) {
            return new int[][] { newInterval };
        }
        List<int[]> res = new ArrayList<>();
        for (int[] interval : intervals) {
            if (interval[1] < newInterval[0]) {
                res.add(interval);
            } else if (newInterval[1] < interval[0]) {
                res.add(newInterval);
                res.add(interval);
                newInterval = null;
            } else {
                newInterval = mergedInterval(interval, newInterval);
            }
        }
        if (null != newInterval) {
            res.add(newInterval);
        }
        return res.toArray(new int[res.size()][]);
    }

    // Linear Search
    private static int[][] insert1(int[][] intervals, int[] newInterval) {
        if (intervals.length == 0) {
            return new int[][] { newInterval };
        }

        List<int[]> res = new ArrayList<>();
        int i = 0, n = intervals.length;
        while (i < n && intervals[i][1] < newInterval[0]) {
            res.add(intervals[i]);
            i++;
        }
        while (i < n && intervals[i][0] <= newInterval[1]) {
            newInterval = mergedInterval(intervals[i], newInterval);
            i++;
        }
        res.add(newInterval);
        while (i < n) {
            res.add(intervals[i]);
            i++;
        }
        return res.toArray(new int[res.size()][]);
    }

    private static int[] mergedInterval(int[] interval1, int[] interval2) {
        return new int[] { Math.min(interval1[0], interval2[0]), Math.max(interval1[1], interval2[1]) };
    }
}

package com.programming.dsalgo.sorting;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class MeetingRooms {

    class Interval {
        public int start, end;

        public Interval(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }

    public static void main(String[] args) {
        Interval i1 = new MeetingRooms().new Interval(0, 5);
        Interval i2 = new MeetingRooms().new Interval(5, 10);
        Interval i3 = new MeetingRooms().new Interval(15, 20);
        List<Interval> intervals = new ArrayList<>();
        intervals.add(i1);
        intervals.add(i2);
        intervals.add(i3);
        System.out.println(canAttendMeetings(intervals));
    }

    private static boolean canAttendMeetings(List<Interval> intervals) {
        // O(n ^ 2)
        // for (int i = 0; i < intervals.size(); i++) {
        // for (int j = i + 1; j < intervals.size(); j++) {
        // if (intervals.get(i).end > intervals.get(j).start) {
        // return false;
        // }
        // }
        // }
        // return true;
        intervals.sort(Comparator.comparing(interval -> interval.start));
        for (int i = 1; i < intervals.size(); i++) {
            if (intervals.get(i - 1).end > intervals.get(i).start) {
                return false;
            }
        }
        return true;
    }
}

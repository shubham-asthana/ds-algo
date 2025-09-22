package com.programming.dsalgo.patterns.linkedlist;

import java.util.HashSet;
import java.util.Set;

public class DetectCycle {

    // Brute
    public boolean hasCycle1(ListNode head) {
        Set<ListNode> set = new HashSet<>();
        ListNode curr = head;
        while (curr != null) {
            if (set.contains(curr)) {
                return true;
            } else {
                set.add(curr);
                curr = curr.next;
            }
        }
        return false;
    }

    public boolean hasCycle(ListNode head) {
        ListNode slow = head, fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast)
                return true;
        }
        return false;
    }
}

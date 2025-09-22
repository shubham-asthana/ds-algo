package com.programming.dsalgo.patterns.linkedlist;

public class RemoveNthNodeFromEnd {

    public ListNode removeNthFromEnd1(ListNode head, int n) {
        int size = 0;
        ListNode curr = head;
        while (curr != null) {
            size++;
            curr = curr.next;
        }

        int removeIndex = size - n;
        if (removeIndex == 0)
            return head.next;
        curr = head;
        for (int i = 0; i < size - 1; i++) {
            if ((i + 1) == removeIndex) {
                curr.next = curr.next.next;
                break;
            }
            curr = curr.next;
        }
        return head;
    }

    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode(0, head);
        ListNode left = dummy;
        ListNode right = head;
        while (n > 0 && right != null) {
            right = right.next;
            n--;
        }

        while (right != null) {
            left = left.next;
            right = right.next;
        }

        left.next = left.next.next;
        return dummy.next;
    }
}

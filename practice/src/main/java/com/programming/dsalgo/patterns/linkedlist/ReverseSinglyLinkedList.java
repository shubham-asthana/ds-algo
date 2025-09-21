package com.programming.dsalgo.patterns.linkedlist;

public class ReverseSinglyLinkedList {

    public ListNode reverseList(ListNode head) {
        ListNode node = head;
        ListNode prev = null;
        while (node != null) {
            ListNode temp = node.next;
            node.next = prev;
            prev = node;
            node = temp;
        }
        return prev;
    }
}

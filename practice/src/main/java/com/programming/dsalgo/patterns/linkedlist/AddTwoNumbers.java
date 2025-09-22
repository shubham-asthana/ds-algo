package com.programming.dsalgo.patterns.linkedlist;

public class AddTwoNumbers {

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(0);
        ListNode curr = dummy;

        int carry = 0;
        while (l1 != null || l2 != null || carry != 0) {
            int digit1 = null != l1 ? l1.val : 0;
            int digit2 = null != l2 ? l2.val : 0;

            int val = digit1 + digit2 + carry;
            carry = val / 10;
            val %= 10;
            curr.next = new ListNode(val);

            curr = curr.next;
            if (null != l1)
                l1 = l1.next;

            if (null != l2)
                l2 = l2.next;

        }
        return dummy.next;
    }
}

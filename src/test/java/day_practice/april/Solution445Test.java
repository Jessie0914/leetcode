package day_practice.april;

import day_practice.ListNode;
import org.junit.Test;

public class Solution445Test {

    @Test
    public void addTwoNumbers() {
        Solution445 solution445 = new Solution445();
        ListNode l1 = new ListNode(7);
        l1.next = new ListNode(2);
        l1.next.next = new ListNode(4);
        l1.next.next.next = new ListNode(3);

        ListNode l2 = new ListNode(5);
        l2.next = new ListNode(6);
        l2.next.next = new ListNode(4);
        ListNode listNode = solution445.addTwoNumbers(l1, l2);
        System.out.println(listNode.val);

    }
}
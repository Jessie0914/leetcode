package linklist;

import org.junit.Test;

import static org.junit.Assert.*;

public class Solution92Test {

    @Test
    public void reverseBetween() {
        ListNode l11 = new ListNode(1);
        ListNode l12 = new ListNode(2);
        ListNode l13 = new ListNode(3);
        ListNode l14 = new ListNode(4);
        ListNode l15 = new ListNode(5);
        l11.next = l12;
        l12.next = l13;
        l13.next = l14;
        l14.next = l15;

        Solution92 solution92 = new Solution92();
        ListNode node = solution92.reverseBetween(l11, 2, 2);
        System.out.println(node.val);
    }
}
package linklist;

import org.junit.Test;

import static org.junit.Assert.*;

public class Solution86Test {

    @Test
    public void partition() {
        ListNode l11 = new ListNode(1);
        ListNode l12 = new ListNode(4);
        ListNode l13 = new ListNode(3);
        ListNode l14 = new ListNode(2);
        ListNode l15 = new ListNode(5);
        ListNode l16 = new ListNode(2);
        l11.next = l12;
        l12.next = l13;
        l13.next = l14;
        l14.next = l15;
        l15.next = l16;

        Solution86 solution86 = new Solution86();
        ListNode node = solution86.partition(l11, 3);
        System.out.println(node.toString());
    }
}
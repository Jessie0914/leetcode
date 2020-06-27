package ali_leetcode_daily;

import day_practice.ListNode;
import org.junit.Test;

import static org.junit.Assert.*;

public class Solution02_01Test {

    @Test
    public void removeDuplicateNodes() {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(3);
        head.next.next.next.next = new ListNode(2);
        head.next.next.next.next.next = new ListNode(1);

        Solution02_01 solution02_01 = new Solution02_01();
        ListNode node = solution02_01.removeDuplicateNodes(head);
    }
}
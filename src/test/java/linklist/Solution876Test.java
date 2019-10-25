package linklist;

import org.junit.Test;

import static org.junit.Assert.*;

public class Solution876Test {

    @Test
    public void middleNode() {
        ListNode l11 = new ListNode(1);
        ListNode l12 = new ListNode(2);
        ListNode l13 = new ListNode(3);
        ListNode l14 = new ListNode(4);
        ListNode l15 = new ListNode(3);
        ListNode l16 = new ListNode(2);
        ListNode l17 = new ListNode(1);
        l11.next = l12;
        l12.next = l13;
        l13.next = l14;
        l14.next = l15;
        l15.next = l16;
        l16.next = l17;

        Solution876 solution876 = new Solution876();
        ListNode node = solution876.middleNode(l11);
        while (node!=null){
            System.out.println(node.val);
            node = node.next;
        }
    }
}
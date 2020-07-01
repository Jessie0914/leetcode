package linklist;

import org.junit.Test;

import static org.junit.Assert.*;

public class Solution328Test {

    @Test
    public void oddEvenList() {
        ListNode l11 = new ListNode(1);
        ListNode l12 = new ListNode(2);
        ListNode l13 = new ListNode(3);
        ListNode l14 = new ListNode(4);
        ListNode l15 = new ListNode(5);
        l11.next = l12;
        l12.next = l13;
        l13.next = l14;
        l14.next = l15;

        Solution328 solution328 = new Solution328();
        ListNode node = solution328.oddEvenList(l11);
        while (node!=null){
            System.out.println(node.val);
            node = node.next;
        }
    }
}
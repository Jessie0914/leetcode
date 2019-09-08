package linklist;

import org.junit.Test;

public class Solution234Test {

    @Test
    public void isPalindrome2() {
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

        Solution234 solution234 = new Solution234();
        boolean palindrome2 = solution234.isPalindrome2(l11);
        System.out.println(palindrome2);
    }
}
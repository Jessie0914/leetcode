package linklist;

import org.junit.Test;

public class Solution1019Test {

    @Test
    public void nextLargerNodes() {
        ListNode l11 = new ListNode(2);
        ListNode l12 = new ListNode(7);
        ListNode l13 = new ListNode(4);
        ListNode l14 = new ListNode(91);
        ListNode l15 = new ListNode(175);
        l11.next = l12;
        l12.next = l13;
        l13.next = l14;
        l14.next = l15;
        Solution1019 solution1019 = new Solution1019();
        int[] nums = solution1019.nextLargerNodes(l11);
        for (int i=0;i<nums.length;i++){
            System.out.print(nums[i]+" ");
        }
    }
}
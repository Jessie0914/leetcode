package day_practice.may;

import day_practice.ListNode;

/**
 * @ClassName Solution21
 * @Description 21. 合并两个有序链表
 * @Author shishi
 * @Date 2020/5/1 9:24
 **/

/**
 * 输入：1->2->4, 1->3->4
 * 输出：1->1->2->3->4->4
 */
public class Solution21 {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null && l2 == null)
            return null;

        if (l1 == null && l2 != null)
            return l2;

        if (l1 != null && l2 == null)
            return l1;

        ListNode p = new ListNode(-1);
        ListNode head = p;

        while (l1 != null && l2 != null) {
            if (l1.val <= l2.val) {
                ListNode node = new ListNode(l1.val);
                p.next = node;
                p = node;
                l1 = l1.next;
            } else {
                ListNode node = new ListNode(l2.val);
                p.next = node;
                p = node;
                l2 = l2.next;
            }
        }

        while (l1 != null) {
            ListNode node = new ListNode(l1.val);
            p.next = node;
            p = node;
            l1 = l1.next;
        }

        while (l2 != null) {
            ListNode node = new ListNode(l2.val);
            p.next = node;
            p = node;
            l2 = l2.next;
        }

        return head.next;
    }
}

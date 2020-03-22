package top_interview;

/**
 * @ClassName Solution21
 * @Description 合并两个有序链表
 * @Author shishi
 * @Date 2020/3/1 13:01
 **/

/**
 * 将两个有序链表合并为一个新的有序链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。
 * 输入：1->2->4, 1->3->4
 * 输出：1->1->2->3->4->4
 */
public class Solution21 {
    // 常规题
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(-1);
        ListNode head = dummy;
        while (l1 != null && l2 != null) {
            if (l1.val <= l2.val) {
                ListNode node = new ListNode(l1.val);
                dummy.next = node;
                dummy = node;
                l1 = l1.next;
            } else {
                ListNode node = new ListNode(l2.val);
                dummy.next = node;
                dummy = node;
                l2 = l2.next;
            }
        }

        while (l1 != null) {
            ListNode node = new ListNode(l1.val);
            dummy.next = node;
            dummy = node;
            l1 = l1.next;
        }

        while (l2 != null) {
            ListNode node = new ListNode(l2.val);
            dummy.next = node;
            dummy = node;
            l2 = l2.next;
        }

        return head.next;
    }
}

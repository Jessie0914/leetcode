package ali_leetcode_daily.bytedance;

/**
 * @ClassName Solution25
 * @Description 给你一个链表，每 k 个节点一组进行翻转，请你返回翻转后的链表。
 * @Author shishi
 * @Date 2020/7/26 16:56
 **/

/**
 * 给你这个链表：1->2->3->4->5
 * 当 k = 2 时，应当返回: 2->1->4->3->5
 * 当 k = 3 时，应当返回: 3->2->1->4->5
 */
// LC_MARK（https://leetcode-cn.com/problems/reverse-nodes-in-k-group/solution/di-gui-java-by-reedfan-2/）
public class Solution25 {
    public ListNode reverseKGroup(ListNode head, int k) {
        if (head == null || head.next == null)
            return head;

        ListNode tail = head;
        for (int i = 0; i < k; i++) {
            if (tail == null)
                return head;
            tail = tail.next;
        }

        // 翻转head到tail之间的结点
        ListNode newListNode = reverse(head, tail);
        head.next = reverseKGroup(tail, k);

        return newListNode;
    }

    private ListNode reverse(ListNode head, ListNode tail) {
        ListNode pre = null;
        while (head != tail) {
            ListNode next = head.next;
            head.next = pre;
            pre = head;
            head = next;
        }

        return pre;
    }
}

package top_interview;

/**
 * @ClassName Solution19
 * @Description 删除链表的倒数第N个节点
 * @Author shishi
 * @Date 2020/2/28 22:35
 **/

/**
 * 给定一个链表，删除链表的倒数第 n 个节点，并且返回链表的头结点。
 * <p>
 * 给定一个链表: 1->2->3->4->5, 和 n = 2.
 * 当删除了倒数第二个节点后，链表变为 1->2->3->5.
 */
public class Solution19 {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        // p1和p2都是构造的虚拟节点
        ListNode p1 = dummy;
        ListNode p2 = dummy;

        // 先让p2走n+1步
        for (int i = 0; i < n + 1; i++) {
            p2 = p2.next;
        }

        // 当p2走到头的时候，p1正好在要删除的结点的前一个位置
        while (p2 != null) {
            p1 = p1.next;
            p2 = p2.next;
        }
        p1.next = p1.next.next;
        return dummy.next;
    }
}

package jianzhi;

/**
 * @Classname JZ56
 * @Description 删除链表中重复的节点
 * @Date 2020/7/22 10:16 上午
 * @Created by chiyue
 */
public class JZ56 {
    public ListNode deleteDuplication(ListNode pHead) {
        if (pHead == null || pHead.next == null)
            return pHead;

        ListNode dummy = new ListNode(-1);
        ListNode p = dummy;

        p.next = pHead;

        while (pHead != null && pHead.next != null) {
            if (pHead.val != pHead.next.val) {
                p = pHead;
                pHead = pHead.next;
            } else {
                int temp = pHead.val;
                while (pHead != null && pHead.val == temp) {
                    pHead = pHead.next;
                }
                p.next = pHead;
            }
        }
        return dummy.next;
    }
}

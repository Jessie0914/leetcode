package jianzhi;

/**
 * @Classname JZ55
 * @Description 给一个链表，若其中包含环，请找出该链表的环的入口结点，否则，输出null。
 * @Date 2020/7/24 2:52 下午
 * @Created by chiyue
 */
public class JZ55 {
    int lenOfCircle = 0;

    public ListNode EntryNodeOfLoop(ListNode pHead) {
        if (pHead == null)
            return null;

        // 先判断是否有环
        if (judge(pHead)) {
            ListNode p1 = pHead;
            ListNode p2 = pHead;

            // 让p1先走len步
            while (lenOfCircle > 0) {
                p1 = p1.next;
                lenOfCircle--;
            }

            // 然后p1和p2同时走
            while (p1 != p2) {
                p1 = p1.next;
                p2 = p2.next;
            }
            return p1;
        } else
            return null;
    }

    // 用快慢指针来判断是否有环
    private boolean judge(ListNode pHead) {
        if (pHead == null)
            return false;

        ListNode slow = pHead;
        ListNode fast = pHead.next;

        while (slow != null && fast != null) {
            slow = slow.next;
            fast = fast.next.next;
            // 相遇，说明有环
            if (slow == fast) {
                ListNode tmp = slow.next;
                while (tmp != slow) {
                    lenOfCircle++;
                    tmp = tmp.next;
                }
                lenOfCircle++;
                return true;
            }
        }
        return false;
    }
}

package ali_leetcode_daily.bytedance;

/**
 * @ClassName Solution142
 * @Description 142. 环形链表 II
 * @Author shishi
 * @Date 2020/8/4 22:30
 **/
public class Solution142 {
    private int lenOfCircle = 1;

    public ListNode detectCycle(ListNode head) {
        if (head == null)
            return null;
        if (!hasCircle(head))
            return null;
        else {
            // 先让p1走len步
            ListNode p1 = head;
            ListNode p2 = head;
            for (int i = 0; i < lenOfCircle; i++)
                p1 = p1.next;
            while (p1 != p2) {
                p1 = p1.next;
                p2 = p2.next;
            }
            return p1;
        }
    }

    // 快慢指针 判断有没有环
    private boolean hasCircle(ListNode head) {
        if (head == null || head.next == null)
            return false;

        ListNode slow = head;
        ListNode fast = head.next;

        while (slow != fast) {
            if (fast == null || fast.next == null) {
                return false;
            }

            slow = slow.next;
            fast = fast.next.next;
        }

        ListNode p = slow.next;
        while (p != slow) {
            lenOfCircle++;
            p = p.next;
        }

        return true;
    }
}

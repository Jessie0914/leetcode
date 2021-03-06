package jianzhi;

/**
 * @Classname JZ36
 * @Description 输入两个链表，找出它们的第一个公共结点。
 * @Date 2020/7/24 2:05 下午
 * @Created by chiyue
 */
public class JZ36 {
    public ListNode FindFirstCommonNode(ListNode pHead1, ListNode pHead2) {
        if (pHead1 == null || pHead2 == null)
            return null;

        ListNode p1 = pHead1;
        ListNode p2 = pHead2;

        while (p1 != p2) {
            p1 = p1.next;
            p2 = p2.next;
            if (p1 != p2) {
                if (p1 == null)
                    p1 = pHead2;
                if (p2 == null)
                    p2 = pHead1;
            }
        }

        return p1;
    }
}

package ali_leetcode_daily.bytedance;

/**
 * @ClassName Solution160
 * @Description
 * @Author shishi
 * @Date 2020/7/28 22:26
 **/
public class Solution160 {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null)
            return null;

        ListNode p1 = headA;
        ListNode p2 = headB;
        while (p1 != p2) {
            p1 = p1.next;
            p2 = p2.next;

            if (p1 != p2) {
                if (p1 == null)
                    p1 = headA;
                if (p2 == null)
                    p2 = headB;
            }
        }

        return p1;
    }
}

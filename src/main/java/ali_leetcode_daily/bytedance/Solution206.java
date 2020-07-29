package ali_leetcode_daily.bytedance;

/**
 * @ClassName Solution206
 * @Description 反转链表
 * @Author shishi
 * @Date 2020/7/28 22:23
 **/
public class Solution206 {
    public ListNode reverseList(ListNode head) {
        ListNode pre = null;
        while (head != null) {
            ListNode next = head.next;
            head.next = pre;
            pre = head;
            head = next;
        }
        return pre;
    }
}

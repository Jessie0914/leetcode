package jianzhi;

/**
 * @ClassName JZ15
 * @Description 输入一个链表，反转链表后，输出新链表的表头。
 * @Author shishi
 * @Date 2020/7/12 22:54
 **/
public class JZ15 {
    public ListNode ReverseList(ListNode head) {
        if (head == null)
            return null;

        ListNode dummy = null;

        while (head.next != null) {
            ListNode next = head.next;
            head.next = dummy;

            dummy = head;
            head = next;
        }
        // 最后一个单独处理
        head.next = dummy;

        return head;
    }
}

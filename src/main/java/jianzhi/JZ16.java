package jianzhi;

/**
 * @ClassName JZ16
 * @Description 输入两个单调递增的链表，输出两个链表合成后的链表
 * @Author shishi
 * @Date 2020/7/12 23:12
 **/
public class JZ16 {
    public ListNode Merge(ListNode list1, ListNode list2) {
        if (list1 == null && list2 != null)
            return list2;

        if (list1 != null && list2 == null)
            return list1;

        ListNode dummy = new ListNode(-1);
        ListNode p = dummy;
        while (list1 != null && list2 != null) {
            int min;
            if (list1.val <= list2.val) {
                min = list1.val;
                list1 = list1.next;
            } else {
                min = list2.val;
                list2 = list2.next;
            }

            p.next = new ListNode(min);
            p = p.next;
        }

        while (list1 != null) {
            p.next = new ListNode(list1.val);
            p = p.next;
            list1 = list1.next;
        }

        while (list2 != null) {
            p.next = new ListNode(list2.val);
            p = p.next;
            list2 = list2.next;
        }

        return dummy.next;
    }
}

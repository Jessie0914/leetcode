package jianzhi;

/**
 * @ClassName JZ14
 * @Description 输入一个链表，输出该链表中倒数第k个结点。
 * @Author shishi
 * @Date 2020/7/12 22:29
 **/
// JZ_MARK
public class JZ14 {
    // 和leetcode 19题作比较
    // 用两个指针，就可以实现一遍遍历
    // 让P2先走k步
    // 然后p1和p2同时走，当p2到达末尾的时候，p1的位置就正好是在倒数第k个节点
    public ListNode FindKthToTail(ListNode head, int k) {
        if (head == null || k < 0)
            return null;

        ListNode p1 = head;
        ListNode p2 = head;

        // p1先走k步
        int i = 0;
        while (p2 != null && i < k) {
            p2 = p2.next;
            i++;
        }
        // 坑：当k>size的时候，应该返回的是null
        // 但是如果不加下面这段，就会返回head
        if (p2 == null && i < k)
            return null;


        // p1和p2同时走
        while (p2 != null) {
            p1 = p1.next;
            p2 = p2.next;
        }

        return p1;
    }
}

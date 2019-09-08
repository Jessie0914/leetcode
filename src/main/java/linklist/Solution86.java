package linklist;

/**
 * @ClassName Solution86
 * @Description 86.分隔链表
 * @Author shishi
 * @Date 2019/6/30 20:38
 **/

/**
 * 题目要求：
 * 给定一个链表和一个特定值 x，对链表进行分隔，使得所有小于 x 的节点都在大于或等于 x 的节点之前。
 * 你应当保留两个分区中每个节点的初始相对位置
 *
 * 示例：
 * 输入: head = 1->4->3->2->5->2, x = 3
 * 输出: 1->2->2->4->3->5
 */
public class Solution86 {
    // 脑子糊涂了，明明新建两个链表，遍历一遍就好
    public ListNode partition(ListNode head, int x) {
        ListNode leftDummyNode = new ListNode(0);
        ListNode rightDummyNode = new ListNode(0);

        ListNode left_cur = leftDummyNode;
        ListNode right_cur = rightDummyNode;

        ListNode cur = head;
        while (cur != null){
            if (cur.val<x){
                left_cur.next = cur;
                left_cur = left_cur.next;
            }
            else {
                right_cur.next = cur;
                right_cur = right_cur.next;
            }
            cur = cur.next;
        }
        left_cur.next = rightDummyNode.next;
        right_cur.next = null;
        return leftDummyNode.next;
    }
}

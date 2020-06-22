package day_practice.march;

/**
 * @ClassName Solution206
 * @Description 206. 反转链表
 * @Author shishi
 * @Date 2020/4/2 14:43
 **/

import day_practice.ListNode;

/**
 * 输入: 1->2->3->4->5->NULL
 * 输出: 5->4->3->2->1->NULL
 */
public class Solution206 {
    public ListNode reverseList(ListNode head) {
        ListNode preNode = null;
        while (head!=null){
            ListNode next = head.next;
            head.next = preNode;
            preNode = head;
            head = next;
        }
        return preNode;
    }
}

package linklist;

/**
 * @ClassName Solution82
 * @Description 82.删除排序链表中的重复元素2
 * @Author shishi
 * @Date 2019/7/1 12:43
 **/

import java.util.List;

/**
 * 题目要求：
 * 给定一个排序链表，删除所有含有重复数字的节点，只保留原始链表中 没有重复出现 的数字
 *
 * 示例：
 * 输入: 1->2->3->3->4->4->5
 * 输出: 1->2->5
 *
 * 输入: 1->1->1->2->3
 * 输出: 2->3
 */
public class Solution82 {
    // 我自己写的代码总是会遇到null的报错问题(我是用一个新的dummyNode，遇到没有重复的加上去)
    // 下面的代码是pdf上的
    // 这里用到的思想是：创建一个新节点和head相接，head就成为了next结点，只需要判断head！=null即可
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null) return head;

        // 创建一个新的头结点
        ListNode dummy = new ListNode(Integer.MAX_VALUE); // 头结点
        // 与head先连起来
        dummy.next = head;
        ListNode prev = dummy, cur = head;
        while (cur != null) {
            // 判断是不是重复元素的标准
            boolean duplicated = false;
            // 找到重复元素中的最后一个元素
            while (cur.next != null && cur.val == cur.next.val) {
                duplicated = true;
                cur = cur.next;
            }
            if (duplicated) {
                cur = cur.next;
                continue; // 跳出循环，重新比较
            }
            // 拼接起来
            prev.next = cur;
            prev = prev.next;
            cur = cur.next;
        }
        // cur是null的，拼接到最后
        prev.next = cur;
        return dummy.next;
    }
}

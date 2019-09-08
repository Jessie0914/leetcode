package linklist;

import java.util.ArrayList;
import java.util.List;

/**
 * 有点难度
 * 请判断一个链表是否为回文链表。
 * 输入: 1->2
 * 输出: false
 *
 * 1->2->2->1
 * 输出: true
 */
public class Solution234 {
    // 用了作弊的方法，呵呵（用一个list保存下所有节点的值）
    public boolean isPalindrome(ListNode head) {
        List<Integer> list = new ArrayList<>();
        while (head!=null){
            list.add(head.val);
            head = head.next;
        }
        int len = list.size();
        int middle = len/2;
        for (int i=0;i<middle-1;i++){
            int a = list.get(i);
            int b = list.get(len-1-i);
            if (a!=b) return false;
        }
        return true;
    }

    // 题解里的方法，用的快慢指针，一个low，一个fast，fast是low的两倍
    // 所以当fast到达尾部的时候，low刚好到中间部分
    // 然后对前半部分的链表进行反转，和后半部分的链表做比较是否一样
    // 看代码，可能不清楚，用测试用例跑一遍即可
    public boolean isPalindrome2(ListNode head) {
        if(head == null || head.next == null)
            return true;
        // 快慢指针
        ListNode slow = head, fast = head.next;
        // 用来辅助反转的
        ListNode pre = null, prepre = null;
        while(fast != null && fast.next != null) {
            //反转前半段链表
            pre = slow;
            slow = slow.next;
            fast = fast.next.next;
            //先移动指针再来反转
            pre.next = prepre;
            prepre = pre;
        }

        // 后半部分链表的头结点
        ListNode p2 = slow.next;
        slow.next = pre;
        // p1是反转后的前半部分的头
        ListNode p1 = fast == null? slow.next : slow;
        while(p1 != null) {
            if(p1.val != p2.val)
                return false;
            p1 = p1.next;
            p2 = p2.next;
        }
        return true;
    }
}

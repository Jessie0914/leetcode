package linklist;

import java.util.HashSet;
import java.util.Set;

/**
 * 编写一个程序，找到两个单链表相交的起始节点。
 * 创建链表时的逻辑我就不管了，那是leetcode服务器里自己写的
 */
public class Solution160 {
    public static ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        // 创建一个hashMap
        Set<ListNode> set = new HashSet<>();

        // 遍历第一个链表，把遍历到的结点放到hashMap中
        while(headA != null) {
            set.add(headA);
            headA = headA.next;
        }
        // 然后开始遍历第二个链表，如果在hashMap有对应的结点，说明就是第一个相交的结点
        while(headB != null) {
            if(set.contains(headB)) {
                return headB;
            }
            else {
                headB = headB.next;
            }
        }
        // 遍历到最后也没有找到相交的结点，就返回null呗
        return null;
    }
}

package linklist;

import java.util.HashSet;
import java.util.Set;

/**
 * 给定一个链表，判断链表中是否有环。
 * 为了表示给定链表中的环，我们使用整数 pos 来表示链表尾连接到链表中的位置（索引从 0 开始）。 如果 pos 是 -1，则在该链表中没有环。
 * 我一开始以为要根据输入就要自己形成一个列表，还在想这不都告诉我们pos的值了吗？pos=-1就是false啊……还写啥？？
 * 后来明白了，这个输入会自动形成一个链表，然后我们只用这个链表去处理就可以
 */
public class Solution141 {
    /**
     * 方案一：利用hashmap
     * 遍历所有结点并在哈希表中存储每个结点的引用（或内存地址）。
     * 如果当前结点为空结点 null（即已检测到链表尾部的下一个结点），那么我们已经遍历完整个链表，并且该链表不是环形链表。
     * 如果当前结点的引用已经存在于哈希表中，那么返回 true（即该链表为环形链表）。
     * @param head
     * @return
     */
    public boolean hasCycle(ListNode head) {
        // 建一个HashSet
        Set<ListNode> hashSet = new HashSet<>();

        // 遍历
        while (head!=null){
            // 如果哈希表里找到有这个值，就说明之前已经访问过了，那么就有环
            if (hashSet.contains(head)){
                return true;
            }else {
                hashSet.add(head);
            }
            head = head.next;
        }
        return false;
    }

    /**
     * 方案二：快慢指针
     * 通过使用具有 不同速度 的快、慢两个指针遍历链表，空间复杂度可以被降低至 O(1)O(1)。慢指针每次移动一步，而快指针每次移动两步。
     * 如果列表中不存在环，最终快指针将会最先到达尾部，此时我们可以返回 false。
     * 比喻：考虑一个环形链表，把慢指针和快指针想象成两个在环形赛道上跑步的运动员（分别称之为慢跑者与快跑者）。而快跑者最终一定会追上慢跑者。
     * @param head
     * @return
     */
    public boolean hasCycle2(ListNode head){
        if (head==null || head.next==null){
            return false;
        }
        ListNode slow = head;
        ListNode fast = head.next;

        // 如果链表里有环，那么快指针一定会追上慢指针
        // 如果链表里面没有环，那么快指针一定会很快就到达尾部
        while (slow!=fast){
            if (fast==null || fast.next==null){
                return false;
            }
            slow = slow.next;
            fast = fast.next.next;
        }
        return false;
    }
}

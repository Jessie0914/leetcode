package linklist;

/**
 * @ClassName Solution876
 * @Description TODO
 * @Author shishi
 * @Date 2019/10/18 11:17
 **/
public class Solution876 {
    // 最简单直接的方法
    public ListNode middleNode(ListNode head) {
        // 先遍历链表的长度
        ListNode l = head;
        int length = 0;
        while (l!=null){
            length++;
            l = l.next;
        }

        l = head;
        int returnCount = length/2+1;
        int i=1;
        while (i<returnCount&&l!=null){
            i++;
            l = l.next;
        }
        return l;
    }

    // 常用链表方法之：快慢指针
    public ListNode middleNode2(ListNode head) {
        ListNode fast,slow;
        fast = head;
        slow = head;
        while (fast!=null && fast.next!=null){
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
}

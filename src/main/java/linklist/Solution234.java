package linklist;

import java.util.Stack;

/**
 * 请判断一个链表是否为回文链表。
 * 输入: 1->2
 * 输出: false
 *
 * 1->2->2->1
 * 输出: true
 */
public class Solution234 {
    public static void main(String[] args) {
        ListNode l11 = new ListNode(1);
        ListNode l12 = new ListNode(1);
        ListNode l13 = new ListNode(2);
        ListNode l14 = new ListNode(1);
        l11.next = l12;
        l12.next = l13;
        l13.next = l14;

        boolean flag = isPalindrome(l11);
        if (flag==true){
            System.out.println("是回文链表");
        }else {
            System.out.println("不是回文链表");
        }
    }

    public static boolean isPalindrome(ListNode head) {
        Stack<ListNode> stack=new Stack<>();
        ListNode slow=head;
        ListNode fast=head;

        if(fast==null||fast.next==null)//0个节点或是1个节点
            return true;

        stack.push(slow);
        while(fast.next!=null&&fast.next.next!=null)
        {

            fast=fast.next.next;
            slow=slow.next;
            stack.push(slow);
        }
        if(fast.next!=null)//链表长度为偶数
            slow=slow.next;

        ListNode cur=slow;
        while(cur!=null)
        {
            if(cur.val!=stack.pop().val)
                return false;
            cur=cur.next;
        }
        return true;

    }

    public static ListNode reverseList(ListNode head) {
        // 新建一个preNode结点，就是用来存放最后完整的链表头的
        ListNode preNode = null;
        ListNode currentNode = head;
        while (currentNode!=null){
            // 为了不丢失以后的链表，得先把next结点存储下来
            ListNode nextNode = currentNode.next;

            // 反转，并且修改preNode、currentNode
            currentNode.next = preNode;
            preNode = currentNode;
            currentNode = nextNode;
        }
        return preNode;
    }

    public static ListNode reverse(ListNode head) {
        ListNode pre = null;
        ListNode cur = head;
        while (cur != null) {
            ListNode temp = cur.next;
            cur.next = pre;
            pre = cur;
            cur = temp;
        }
        return pre;
    }

}

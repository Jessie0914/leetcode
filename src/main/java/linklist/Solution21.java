package linklist;

/**
 * 将两个有序链表合并为一个新的有序链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。
 * 输入：1->2->4, 1->3->4
 * 输出：1->1->2->3->4->4
 */
public class Solution21 {
    public static void main(String[] args) {
        ListNode l11 = new ListNode(1);
        ListNode l12 = new ListNode(2);
        ListNode l13 = new ListNode(4);
        l11.next = l12;
        l12.next = l13;

        ListNode l21 = new ListNode(1);
        ListNode l22 = new ListNode(3);
        ListNode l23 = new ListNode(4);
        l21.next = l22;
        l22.next = l23;

        ListNode res = mergeTwoLists(l11, l21);
        System.out.println(res.toString());

    }

    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        //新建一个链表，头结点
        ListNode head = new ListNode(0);

        // 新建一个当前节点用来处理
        ListNode currentNode = new ListNode(0);

        // 将两个结点相连成一个链表
        head.next = currentNode;

        // 不加这一段，[][]的测试用例通不过
        // 应该返回[]，但如果不加的话会返回[0]，应该特判
        if (l1==null&&l2==null){
            return null;
        }

        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                currentNode.val = l1.val;
                l1 = l1.next;
            } else {
                currentNode.val = l2.val;
                l2 = l2.next;
            }
            if (l1!=null || l2!=null){
                // 再创建新的结点,接到链表的后面
                currentNode.next = new ListNode(0);
                currentNode = currentNode.next;
            }
        }

        // 把剩下的了l1结点复制
        if (l1 != null) {
            while (l1!=null){
                currentNode.val = l1.val;
                l1 = l1.next;

                if (l1!=null){
                    currentNode.next = new ListNode(0);
                    currentNode = currentNode.next;
                }
            }
        }

        if (l2 != null) {
            while (l2!=null){
                currentNode.val = l2.val;
                l2 = l2.next;

                if (l2!=null){
                    currentNode.next = new ListNode(0);
                    currentNode = currentNode.next;
                }
            }
        }
        return head.next;
    }
}
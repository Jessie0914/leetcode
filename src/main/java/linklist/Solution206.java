package linklist;

/**
 * 反转一个单链表。
 * 输入: 1->2->3->4->5->NULL
 * 输出: 5->4->3->2->1->NULL
 */
public class Solution206 {
    public static void main(String[] args) {
        ListNode l11 = new ListNode(1);
        ListNode l12 = new ListNode(2);
        ListNode l13 = new ListNode(3);
//        ListNode l14 = new ListNode(4);
//        ListNode l15 = new ListNode(5);
        l11.next = l12;
        l12.next = l13;
//        l13.next = l14;
//        l14.next = l15;

        ListNode res = reverseList(l11);
        System.out.println(res.val);
    }

    /**
     * 在遍历列表时，将当前节点的 next 指针改为指向前一个元素。
     * 由于节点没有引用其上一个节点，因此必须事先存储其前一个元素
     * 在更改引用之前，还需要另一个指针来存储下一个节点。
     */
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
}

package linklist;

/**
 * @ClassName Solution92
 * @Description 92.反转链表2
 * @Author shishi
 * @Date 2019/6/30 19:39
 **/

/**
 * 题目要求：
 * 反转从位置 m 到 n 的链表。请使用一趟扫描完成反转。
 *
 * 示例：
 * 输入: 1->2->3->4->5->NULL, m = 2, n = 4
 * 输出: 1->4->3->2->5->NULL
 */
public class Solution92 {

    public ListNode reverseBetween(ListNode head, int m, int n) {
        if (head==null) return null;

        // 创建一个最后要返回的虚拟节点
        ListNode dummyHead = new ListNode(0);
        // 赋给newHead，用来往前进，操作
        ListNode newHead = dummyHead;

        // 当index还没到m之前，就单纯地复制节点到newHead就行，并且不断的更新newHead以及head
        int index =1;
        while (head!=null && index<m){
            newHead.next = head;
            head = head.next;
            newHead = newHead.next;
            newHead.next = null;
            index++;
        }

        // 下面是翻转操作，一共反转m-n+1个结点
        // 在反转的时候，也不断的更新head，head永远当前还没有被操作到的那个结点
        // 先保存head的next结点为nextNode，因为head要和preNode相连，之后的结点会断掉
        // head与preNode相连之后，更新head为新的preNode，以及nextNode为新的head
        // 最后的preNode就是反转后的头结点
        ListNode preNode = null;
        while (index<=n){
            ListNode nextNode = head.next;
            head.next = preNode;
            preNode = head;
            head = nextNode;

            index++;
        }

        // 将反转后的头结点接到newHead的尾部
        newHead.next = preNode;

        // 然后遍历到反转后的链表的尾部，便于接后面还没有被操作到的head结点
        while (preNode.next!=null){
            preNode = preNode.next;
        }
        //把head接上去即可
        preNode.next = head;

        // 返回虚拟节点的下一个结点就是我们要的结果
        return dummyHead.next;
    }
}

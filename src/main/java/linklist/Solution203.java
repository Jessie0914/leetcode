package linklist;

/**
 * 删除链表中等于给定值 val 的所有节点。
 * 输入: 1->2->6->3->4->5->6, val = 6
 * 输出: 1->2->3->4->5
 */
public class Solution203 {
    public static void main(String[] args) {
        ListNode l11 = new ListNode(1);
        ListNode l12 = new ListNode(1);
        ListNode l13 = new ListNode(1);
//        ListNode l14 = new ListNode(3);
//        ListNode l15 = new ListNode(4);
//        ListNode l16 = new ListNode(5);
//        ListNode l17 = new ListNode(6);
        l11.next = l12;
        l12.next = l13;
//        l13.next = l14;
//        l14.next = l15;
//        l15.next = l16;
//        l16.next = l17;

        ListNode res = removeElements(l11, 1);
        if (res==null){
            System.out.println("null");
        }else {
            System.out.println(res.toString());
        }
    }

    /**
     * 还有递归的解法，我没有尝试，感觉递归稍微有点理解困难
     * @param head
     * @param val
     * @return
     */
    public static ListNode removeElements(ListNode head, int val) {
        // 我觉得创建一个新的虚拟节点是一个很好的方法！以后应该也用的到
        // 创建一个虚拟节点，作为表头，这样往后遍历就好删除了
        ListNode dummyNode = new ListNode(0);
        // 将虚拟节点和链表连接起来
        dummyNode.next = head;

        // 用currentNode来操作
        ListNode currentNode = dummyNode;
        // 遍历
        while (currentNode.next!=null){
            // 找到了目标节点
            if (currentNode.next.val==val){
                // 目标节点已经不是最后一个节点
                if (currentNode.next.next!=null){
                    currentNode.next = currentNode.next.next;
                }
                // 目标节点是最后一个结点
                else {
                    currentNode.next = null;
                }
            }
            // 没有找到目标节点就往后移动
            else {
                currentNode = currentNode.next;
            }
        }

        return dummyNode.next;
    }
}

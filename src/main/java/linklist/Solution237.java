package linklist;

/**
 * @ClassName Solution237
 * @Description 237.删除链表中的节点
 * @Author shishi
 * @Date 2019/7/22 16:19
 **/

/**
 * 请编写一个函数，使其可以删除某个链表中给定的（非末尾）节点，你将只被给定要求被删除的节点。
 * 输入: head = [4,5,1,9], node = 5
 * 输出: [4,1,9]
 */
public class Solution237 {
    // 一开始没懂题目，还以为题目出错了，实际上没有，他就是只给了当前节点
    // 不能按照以前的方法来删除，把pre指向next结点
    // 这里只能先拿到下一个结点的值，赋给当前节点，然后再删除下一个结点
    public void deleteNode(ListNode node) {
        int val = node.next.val;
        node.val = val;
        node.next = node.next.next;
    }
}

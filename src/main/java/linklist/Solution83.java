package linklist;

/**
 * 题目要求：
 * 给定一个排序链表，删除所有重复的元素，使得每个元素只出现一次。
 * 输入: 1->1->2
 * 输出: 1->2
 */
public class Solution83 {
    public static void main(String[] args) {
        ListNode l11 = new ListNode(1);
        ListNode l12 = new ListNode(1);
        ListNode l13 = new ListNode(1);
        linklist.ListNode l14 = new linklist.ListNode(3);
        linklist.ListNode l15 = new linklist.ListNode(3);
        l11.next = l12;
        l12.next = l13;
        l13.next = l14;
        l14.next = l15;

        ListNode res = deleteDuplicates(l11);
        System.out.println(res.toString());
    }

    /**
     * 因为链表已经是有序的，所以一遍遍历即可
     * @param head
     * @return
     */
    public static ListNode deleteDuplicates(ListNode head) {
        ListNode currentNode = head;

        while (currentNode!=null && currentNode.next!=null){
            // 如果相同就删除next结点
            // 这种情况下，currentNode不用变，还需要重新开始比较
            if (currentNode.val == currentNode.next.val){
                currentNode.next = currentNode.next.next;
            }
            else{
                currentNode = currentNode.next;
            }
        }

        return head;
    }
}

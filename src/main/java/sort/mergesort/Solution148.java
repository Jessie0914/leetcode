package sort.mergesort;

/**
 * @ClassName Solution148
 * @Description 148.排序链表
 * @Author shishi
 * @Date 2019/7/13 14:57
 **/

/**
 * 在 O(n log n) 时间复杂度和常数级空间复杂度下，对链表进行排序
 *
 */
public class Solution148 {

    // 这题参考pdf的归并排序的做法
    public ListNode sortList(ListNode head) {
        if (head==null || head.next==null) return head;

        ListNode middle = findMiddle(head);
        ListNode tmp = middle.next;
        middle.next = null;

        ListNode sortedLeft = sortList(head);
        ListNode sortedRight = sortList(tmp);
        return mergeSort(sortedLeft,sortedRight);
    }

    private ListNode mergeSort(ListNode sortedLeft, ListNode sortedRight) {
        ListNode dummy = new ListNode(0);
        ListNode cur = dummy;
        while (sortedLeft!=null || sortedRight!=null){
            int val1 = sortedLeft==null? Integer.MAX_VALUE:sortedLeft.val;
            int val2 = sortedRight==null? Integer.MAX_VALUE:sortedRight.val;
            if (val1<=val2){
                cur.next = sortedLeft;
                sortedLeft = sortedLeft.next;
            }else {
                cur.next = sortedRight;
                sortedRight = sortedRight.next;
            }
            cur = cur.next;
        }
        return dummy.next;
    }

    // 利用快慢指针找到中间结点
    private ListNode findMiddle(ListNode head) {
        if (head==null) return null;

        ListNode slow = head;
        ListNode fast = head.next;
        while (fast!=null && fast.next!=null){
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
}

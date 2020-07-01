package sort.insertsort;

public class Solution147Test {
    public static void main(String[] args) {
        ListNode p1 = new ListNode(4);
        ListNode p2 = new ListNode(2);
        ListNode p3 = new ListNode(1);
        ListNode p4 = new ListNode(3);
        p1.next = p2;
        p2.next = p3;
        p3.next = p4;

        Solution147 solution147 = new Solution147();
        ListNode listNode = solution147.insertionSortList(p1);
    }

}
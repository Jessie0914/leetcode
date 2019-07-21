package sort.mergesort;

/**
 * @ClassName ListNode
 * @Description TODO
 * @Author shishi
 * @Date 2019/7/13 14:58
 **/
public class ListNode {
    int val;
    ListNode next;

    public ListNode(int val) {
        this.val = val;
        next = null;
    }

    @Override
    public String toString() {
        return "linklist.ListNode{" +
                "val=" + val +
                ", next=" + next +
                '}';
    }
}

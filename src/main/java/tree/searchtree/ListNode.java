package tree.searchtree;

/**
 * @ClassName ListNode
 * @Description TODO
 * @Author shishi
 * @Date 2019/7/11 16:02
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

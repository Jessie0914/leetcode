package linklist;

class ListNode {
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

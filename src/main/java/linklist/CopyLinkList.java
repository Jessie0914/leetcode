package linklist;

public class CopyLinkList {
    public static void main(String[] args) {
        ListNode l11 = new ListNode(1);
        ListNode l12 = new ListNode(2);
        ListNode l13 = new ListNode(3);
        l11.next = l12;
        l12.next = l13;
        ListNode node = copyLinkList(l11);
        System.out.println(node.toString());
        System.out.println(l11.toString());
    }

    public static ListNode copyLinkList(ListNode head){
        ListNode preNode = new ListNode(0);
        ListNode res = preNode;
        ListNode currentNode = head;
        while (currentNode!=null){
            ListNode node = new ListNode(0);
            node.val = currentNode.val;
            preNode.next = node;
            preNode = currentNode;
            currentNode = currentNode.next;
        }
        return res.next;
    }
}

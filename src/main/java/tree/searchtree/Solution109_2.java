package tree.searchtree;

/**
 * @ClassName Solution109_2
 * @Description 109.有序链表转换二叉搜索树的另一种解法
 * @Author shishi
 * @Date 2019/7/11 16:38
 **/

/**
 * 这个是利用链表的特性的方法，而不是像我把链表转换成数组来操作的
 * 思路可以参考leetcode的官方题解
 */
public class Solution109_2 {
    public TreeNode sortedListToBST(ListNode head) {

        // If the head doesn't exist, then the linked list is empty
        if (head == null) {
            return null;
        }

        // Find the middle element for the list.
        ListNode mid = this.findMiddleElement(head);

        // The mid becomes the root of the BST.
        TreeNode node = new TreeNode(mid.val);

        // Base case when there is just one element in the linked list
        if (head == mid) {
            return node;
        }

        // Recursively form balanced BSTs using the left and right halves of the original list.
        node.left = this.sortedListToBST(head);
        node.right = this.sortedListToBST(mid.next);
        return node;
    }

    private ListNode findMiddleElement(ListNode head) {

        // The pointer used to disconnect the left half from the mid node.
        // 利用快慢指针，快指针每次跳两个，慢指针每次跳一个，当快指针到末尾的时候，慢指针刚好指向中间元素
        ListNode prevPtr = null;
        ListNode slowPtr = head;
        ListNode  fastPtr = head;

        // Iterate until fastPr doesn't reach the end of the linked list.
        while (fastPtr != null && fastPtr.next != null) {
            prevPtr = slowPtr;
            slowPtr = slowPtr.next;
            fastPtr = fastPtr.next.next;
        }

        // Handling the case when slowPtr was equal to head.
        if (prevPtr != null) {
            prevPtr.next = null;
        }

        return slowPtr;
    }
}

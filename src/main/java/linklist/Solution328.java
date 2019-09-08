package linklist;

/**
 * @ClassName Solution328
 * @Description 328.奇偶链表
 * @Author shishi
 * @Date 2019/6/30 16:43
 **/

/**
 * 题目要求：
 * 给定一个单链表，把所有的奇数节点和偶数节点分别排在一起。
 * 请注意，这里的奇数节点和偶数节点指的是节点编号的奇偶性，而不是节点的值的奇偶性。
 *
 * 示例：
 * 输入: 1->2->3->4->5->NULL
 * 输出: 1->3->5->2->4->NULL
 *
 * 输入: 2->1->3->5->6->4->7->NULL
 * 输出: 2->3->6->7->1->5->4->NULL
 */
public class Solution328 {
    public ListNode oddEvenList(ListNode head) {
        if (head==null) return null;
        // 定义两个链表的假结点
        ListNode oddDummy = new ListNode(0);
        ListNode evenDummy = new ListNode(0);

        ListNode odd = oddDummy;
        ListNode even = evenDummy;

        int index = 1;
        while (head!=null){
            // 遇到奇数结点
            if (index%2==1){
                odd.next = head;
                odd = odd.next;
            }
            else {
                even.next = head;
                even = even.next;
            }
            // 回看这一段代码，不大懂为什么要将head.next置空，觉得题目也没有要求。。。
            // 直接head = head.next不就可以了吗
            ListNode tmp = head.next;
            head.next = null;
            head = tmp;
            index++;
        }
        // 将奇偶链表连接起来
        odd.next = evenDummy.next;
        return oddDummy.next;
    }
}

package sort.insertsort;

/**
 * @ClassName Solution147
 * @Description 147.对链表进行插入排序
 * @Author shishi
 * @Date 2019/7/13 13:30
 **/

import java.util.ArrayList;
import java.util.Arrays;

/**
 * 对链表进行插入排序
 */
public class Solution147 {
    // 先找到当前节点应该插入的位置，然后插入
    public ListNode insertionSortList(ListNode head) {
        ListNode newHead = new ListNode(Integer.MIN_VALUE);
        ListNode preNode = newHead;
        ListNode cur = head;
        while (cur!=null){
            ListNode insertPos = findInsertPos(preNode, cur.val);
            ListNode tmp = cur.next;
            cur.next = insertPos.next;
            insertPos.next = cur;
            cur = tmp;
        }
        return newHead.next;
    }

    // 找到在当前链表中应该插入的位置
    private ListNode findInsertPos(ListNode node,int val){
        ListNode insertPos = null;
        while (node!=null){
            if (node.val<=val){
                insertPos = node;
                node = node.next;
            }else break;
        }
        return insertPos;
    }

    // 这个是我一开始想的暴力方法，遍历链表，放到一个数组里面
    // 把数组排好序之后，再构建一个新的链表返回即可
    public ListNode insertionSortList2(ListNode head) {
        ArrayList<Integer> list = new ArrayList<>();
        while (head!=null){
            list.add(head.val);
            head=head.next;
        }
        int[] array = list.stream().mapToInt(Integer::intValue).toArray();
        Arrays.sort(array);
        ListNode dummy = new ListNode(0);
        ListNode preNode = dummy;
        for (int i = 0;i<array.length;i++){
            ListNode cur = new ListNode(array[i]);
            preNode.next = cur;
            preNode = cur;
            preNode.next = null;
        }
        return dummy.next;
    }
}

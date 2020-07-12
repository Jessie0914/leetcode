package jianzhi;

import java.util.ArrayList;

/**
 * @ClassName JZ3
 * @Description 输入一个链表，按链表从尾到头的顺序返回一个ArrayList。
 * @Author shishi
 * @Date 2020/7/12 15:02
 **/

public class JZ3 {
    // 简单粗暴的方法：遍历之后，最后Collections.reverse(list)
    // 这里用另外一个方法，递归
    // 注意递归的时候，不要出现死循环，用的是if而不是while

    ArrayList<Integer> list = new ArrayList<>();
    public ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
        // 不能用while，递归用if
        if (listNode != null) {
            printListFromTailToHead(listNode.next);
            list.add(listNode.val);
        }
        return list;
    }
}

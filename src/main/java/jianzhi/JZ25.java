package jianzhi;

import java.util.HashMap;

/**
 * @ClassName JZ25
 * @Description 输入一个复杂链表（每个节点中有节点值，以及两个指针，
 * 一个指向下一个节点，另一个特殊指针random指向一个随机节点），
 * 请对此链表进行深拷贝，并返回拷贝后的头结点。
 * @Author shishi
 * @Date 2020/7/16 0:38
 **/
// JZ_MARK
public class JZ25 {
    public RandomListNode Clone(RandomListNode pHead) {
        HashMap<RandomListNode, RandomListNode> old_to_new_map = new HashMap<>();

        RandomListNode p = pHead;
        while (p != null) {
            RandomListNode newNode = new RandomListNode(p.label);
            old_to_new_map.put(p, newNode);
            p = p.next;
        }

        p = pHead;
        while (p != null) {
            old_to_new_map.get(p).next = old_to_new_map.get(p.next);
            old_to_new_map.get(p).random = old_to_new_map.get(p.random);
            p = p.next;
        }

        return old_to_new_map.get(pHead);
    }
}

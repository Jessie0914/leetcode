package ali_leetcode_daily;

import day_practice.ListNode;

import java.util.HashSet;
import java.util.Set;

/**
 * @ClassName Solution02_01
 * @Description 面试题 02.01. 移除重复节点
 * @Author shishi
 * @Date 2020/6/26 17:48
 **/

/**
 * 输入：[1, 2, 3, 3, 2, 1]
 * 输出：[1, 2, 3]
 */
public class Solution02_01 {
    public ListNode removeDuplicateNodes(ListNode head) {
        Set<Integer> set = new HashSet<>();
        ListNode p = head;
        ListNode pre = p;
        while (p != null) {
            // 如果没有出现过，那么直接p和pre都往后移动更新
            if (!set.contains(p.val)) {
                pre = p;
                set.add(p.val);
                p = p.next;
            }
            // 需要将p更新到非重复结点那里，然后和pre相连
            // 注意，这里不要过度更新p，p到了非val的地方，需要重新判断下当前新的val是不是重复的
            else {
                int val = p.val;
                while (p != null && p.val == val) {
                    p = p.next;
                }
                pre.next = p;
            }
        }

        return head;
    }
}

package linklist;

import java.util.ArrayList;

/**
 * @ClassName Solution1019
 * @Description 链表中的下一个更大节点
 * @Author shishi
 * @Date 2020/2/10 20:07
 **/
public class Solution1019 {
    public int[] nextLargerNodes(ListNode head) {
        ArrayList<Integer> list = new ArrayList<>();
        while (head != null) {
            list.add(head.val);
            head = head.next;
        }

//        int[] nums = list.stream().mapToInt(Integer::byteValue).toArray();
        int[] nums = new int[list.size()];
        int len = nums.length;
        for (int i=0;i<len;i++){
            nums[i] = list.get(i);
        }
        int[] nextLarger = new int[len];
        nextLarger[len - 1] = 0;
        for (int i = len - 2; i >= 0; i--) {
            int num = nums[i];
            int j = i + 1;
            while (j < len) {
                if (nums[j] > num) {
                    nextLarger[i] = nums[j];
                    break;
                } else if (nextLarger[j]>num){
                    nextLarger[i] = nextLarger[j];
                    break;
                } else
                    j++;
            }
        }

        return nextLarger;
    }
}

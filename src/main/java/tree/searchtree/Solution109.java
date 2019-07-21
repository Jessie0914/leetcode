package tree.searchtree;

/**
 * @ClassName Solution109
 * @Description 109.有序链表转换二叉搜索树
 * @Author shishi
 * @Date 2019/7/11 16:01
 **/

import java.util.ArrayList;

/**
 * 给定一个单链表，其中的元素按升序排序，将其转换为高度平衡的二叉搜索树
 */
public class Solution109 {
    // 这题我的思路，就是根据108题来的
    // 首先将链表转换成有序数组，然后再把有序数组转换成二叉搜索树（108题）
    public TreeNode sortedListToBST(ListNode head) {
        int[] nums = linklistToArray(head);
        return sortedArratToBST(nums);
    }

    private TreeNode sortedArratToBST(int[] nums) {
        return generateArrayToBST(nums,0,nums.length-1);
    }

    private TreeNode generateArrayToBST(int[] nums, int start, int end) {
        // 结束的标识
        if (start>end) return null;

        int length = end-start+1;
        int mid = start+length/2;
        // 取中间的结点为root
        TreeNode root = new TreeNode(nums[mid]);
        // 递归生成左子树和右子树，并与root拼接起来
        root.left = generateArrayToBST(nums, start, mid - 1);
        root.right = generateArrayToBST(nums, mid + 1, end);
        return root;
    }

    // 将链表转换成数组
    // 那么这个问题就又转换成如何将有序数组转换成二叉搜索树了
    private int[] linklistToArray(ListNode head) {
        ArrayList<Integer> list = new ArrayList<>();
        while (head!=null){
            list.add(head.val);
            head = head.next;
        }
        // ArrayList转换成int[]数组，最好记住（这样就不需要用一个循环一个个转换成int[]数组了，一句搞定）
        int[] nums = list.stream().mapToInt(Integer::intValue).toArray();
        return nums;
    }
}

package ali_leetcode_daily.tree;

/**
 * @author chiyue
 * @Description 面试题 04.02. 最小高度树
 * @date 2020/6/28 2:31 下午
 */

/**
 * 给定一个有序整数数组，元素各不相同且按升序排列，编写一个算法，创建一棵高度最小的二叉搜索树。
 * 给定有序数组: [-10,-3,0,5,9],
 * 一个可能的答案是：[0,-3,9,-10,null,5]
 */
public class Solution04_02 {
    public TreeNode sortedArrayToBST(int[] nums) {
        if (nums == null || nums.length == 0) {
            return null;
        }
        return construct(nums, 0, nums.length - 1);
    }

    private TreeNode construct(int[] nums, int i, int j) {
        if (i > j) {
            return null;
        }

        int mid = (i + j) / 2;
        TreeNode root = new TreeNode(nums[mid]);
        root.left = construct(nums, i, mid - 1);
        root.right = construct(nums, mid + 1, j);

        return root;
    }
}

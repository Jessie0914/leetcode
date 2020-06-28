package ali_leetcode_daily.tree;

/**
 * @author chiyue
 * @Description 剑指 Offer 55 - I. 二叉树的深度
 * @date 2020/6/28 2:18 下午
 */
public class Solution_jianzhi_51_1 {
    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        if (root.left == null && root.right == null) {
            return 1;
        }
        return Math.max(maxDepth(root.left), maxDepth(root.right)) + 1;
    }
}

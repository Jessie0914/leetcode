package ali_leetcode_daily.tree;

/**
 * @ClassName Solution111
 * @Description 111. 二叉树的最小深度
 * @Author shishi
 * @Date 2020/6/27 11:03
 **/
public class Solution111 {
    public int minDepth(TreeNode root) {
        if (root == null)
            return 0;

        if (root.left == null && root.right == null)
            return 1;

        if (root.left == null && root.right != null) {
            return minDepth(root.right) + 1;
        }

        if (root.left != null && root.right == null) {
            return minDepth(root.left) + 1;
        }

        return Math.min(minDepth(root.left), minDepth(root.right)) + 1;
    }
}

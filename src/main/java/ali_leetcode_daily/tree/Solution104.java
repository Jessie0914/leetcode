package ali_leetcode_daily.tree;

/**
 * @ClassName Solution104
 * @Description 104. 二叉树的最大深度
 * @Author shishi
 * @Date 2020/6/27 11:00
 **/
public class Solution104 {
    public int maxDepth(TreeNode root) {
        if (root == null)
            return 0;

        if (root.left == null && root.right == null)
            return 1;

        return Math.max(maxDepth(root.left), maxDepth(root.right)) + 1;
    }
}

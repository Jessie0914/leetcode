package ali_leetcode_daily.bytedance;

/**
 * @ClassName Solution543
 * @Description 二叉树的直径
 * @Author shishi
 * @Date 2020/8/4 22:22
 **/
public class Solution543 {
    private int res = 0;

    public int diameterOfBinaryTree(TreeNode root) {
        dfs(root);
        return res;
    }

    // 计算树的高度
    private int dfs(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int left = dfs(root.left);
        int right = dfs(root.right);

        res = Math.max(res, left + right);
        return Math.max(left, right) + 1;
    }
}

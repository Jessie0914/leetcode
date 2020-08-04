package ali_leetcode_daily.bytedance;

/**
 * @ClassName Solution235
 * @Description 二叉搜索树的最近公共祖先
 * @Author shishi
 * @Date 2020/8/4 20:17
 **/
public class Solution235 {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null)
            return null;

        int min = Math.min(p.val, q.val);
        int max = Math.max(p.val, q.val);

        if (root.val >= min && root.val <= max) {
            return root;
        } else if (root.val < min) {
            return lowestCommonAncestor(root.right, p, q);
        } else
            return lowestCommonAncestor(root.left, p, q);

    }
}

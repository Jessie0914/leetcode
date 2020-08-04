package ali_leetcode_daily.bytedance;

/**
 * @ClassName Solution236
 * @Description 二叉树的最近公共祖先
 * @Author shishi
 * @Date 2020/8/4 20:05
 **/
public class Solution236 {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null && (p != null || q != null))
            return null;

        return judge(root, p, q);
    }

    private TreeNode judge(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null)
            return null;

        if (root == p || root == q)
            return root;

        TreeNode left = judge(root.left, p, q);
        TreeNode right = judge(root.right, p, q);

        if (left != null && right != null)
            return root;
        else if (left != null) {
            return left;
        } else
            return right;

    }
}

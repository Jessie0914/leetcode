package ali_leetcode_daily;

import day_practice.TreeNode;

/**
 * @ClassName Solution236
 * @Description TODO
 * @Author shishi
 * @Date 2020/6/17 22:51
 **/
public class Solution236 {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || p == null || q == null)
            return null;

        if (root == p || root == q)
            return root;

        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);

        if (left != null && right != null)
            return root;
        if (left == null && right != null)
            return right;
        if (left != null && right == null)
            return left;

        return null;
    }
}

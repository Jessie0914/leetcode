package ali_leetcode_daily.tree;

/**
 * @ClassName Solution235
 * @Description 235. 二叉搜索树的最近公共祖先
 * @Author shishi
 * @Date 2020/6/27 9:41
 **/
public class Solution235 {

    // 二叉搜索树的解法
    // 要利用BST树的特性
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || p == null || q == null)
            return null;

        int min = p.val < q.val ? p.val : q.val;
        int max = p.val > q.val ? p.val : q.val;

        if (root.val >= min && root.val <= max) {
            return root;
        } else if (root.val < min) {
            return lowestCommonAncestor(root.right, p, q);
        } else {
            return lowestCommonAncestor(root.left, p, q);
        }
    }

    // 这是普通的二叉树
    public TreeNode lowestCommonAncestor2(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || p == null || q == null)
            return null;

        if (root == p || root == q)
            return root;

        TreeNode left = lowestCommonAncestor2(root.left, p, q);
        TreeNode right = lowestCommonAncestor2(root.right, p, q);

        if (left != null && right != null)
            return root;

        else if (left == null && right != null)
            return lowestCommonAncestor2(root.right, p, q);

        else
            return lowestCommonAncestor2(root.left, p, q);
    }
}

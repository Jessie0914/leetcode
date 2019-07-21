package tree.recursion;

/**
 * @ClassName Solution236
 * @Description 236.二叉树的最近公共祖先
 * @Author shishi
 * @Date 2019/7/11 21:45
 **/

/**
 * 给定一个二叉树, 找到该树中两个指定节点的最近公共祖先。
 * 这题和235的区别是，235是二叉搜索树，更简单，236是普通的二叉树
 */
public class Solution236 {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root==null) {
            return null;
        }
        if (root.val==p.val || root.val==q.val) {
            return root;
        }
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        if (left!=null && right!=null) {
            return root;
        }
        if (left==null && right!=null) {
            return right;
        }
        if (left!=null && right==null) {
            return left;
        }
        return null;
    }


}

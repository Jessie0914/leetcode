package tree.searchtree;

/**
 * @ClassName Solution235
 * @Description 235.二叉搜索树的最近公共祖先
 * @Author shishi
 * @Date 2019/7/11 17:06
 **/

/**
 * 给定一个二叉搜索树, 找到该树中两个指定节点的最近公共祖先。
 * 百度百科中最近公共祖先的定义为：
 * “对于有根树 T 的两个结点 p、q，最近公共祖先表示为一个结点 x，满足 x 是 p、q 的祖先且 x 的深度尽可能大（一个节点也可以是它自己的祖先）。
 */
public class Solution235 {
    // 只有三种情况
    // ①当前节点的值在min和max之间，就说明当前节点就是最近公共祖先
    // ②当前节点的值小于min的值，说明需要往当前节点的右子树找最近公共祖先
    // ③当前节点的值大于max的值，说明需要往当前节点的左子树找最近公共祖先
    // 我这里用到的是递归的思想，还可以用迭代的方法
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) return null;
        TreeNode min = p.val < q.val ? p : q;
        TreeNode max = p.val > q.val ? p : q;
        if (root.val >= min.val && root.val <= max.val)
            return root;
        else {
            if (root.val >= max.val) {
                return lowestCommonAncestor(root.left, p, q);
            }
            if (root.val <= min.val) {
                return lowestCommonAncestor(root.right, p, q);
            }
        }
        return null;
    }

    // 迭代的方法（提交之后发现比递归的效率还低？？）
    public TreeNode lowestCommonAncestor2(TreeNode root, TreeNode p, TreeNode q) {
        while (root != null) {
            if (Math.max(p.val, q.val) < root.val) root = root.left;
            else if (Math.min(p.val, q.val) > root.val) root = root.right;
            else return root;
        }
        return null;
    }
}

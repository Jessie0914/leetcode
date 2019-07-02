package tree;

/**
 * @ClassName Solution111
 * @Description 111.二叉树的最小深度
 * @Author shishi
 * @Date 2019/6/27 19:54
 **/

/**
 * 给定一个二叉树，找出其最小深度。
 * 最小深度是从根节点到最近叶子节点的最短路径上的节点数量。
 */
public class Solution111 {
    // 最小深度和最大深度稍微有一丢丢不一样
    public int minDepth(TreeNode root) {
        // 如果节点为空，深度就为0
        if (root == null) return 0;
        // 如果一个子树不为空且另一个子树为空，那么最小深度就是不为空的子树的最小深度+1
        if (root.left != null && root.right == null) return minDepth(root.left);
        if (root.right != null && root.left == null) return minDepth(root.right);

        // 再把问题分成小模块的
        return Math.min(minDepth(root.left),minDepth(root.right))+1;
    }
}

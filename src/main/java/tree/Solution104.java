package tree;

/**
 * @ClassName Solution104
 * @Description 104.二叉树的最大深度
 * @Author shishi
 * @Date 2019/6/27 19:41
 **/

/**
 * 给定一个二叉树，找出其最大深度。
 * 二叉树的深度为根节点到最远叶子节点的最长路径上的节点数。
 */
public class Solution104 {
    // 最简单直观的方法就是递归，但是效率好像不是特别高
    // 还可以用迭代来完成
    public int maxDepth(TreeNode root) {
        if (root == null) return 0;
        return Math.max(maxDepth(root.left), maxDepth(root.right)) + 1;
    }
}

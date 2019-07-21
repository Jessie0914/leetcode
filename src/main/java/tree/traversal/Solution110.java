package tree.traversal;

/**
 * @ClassName Solution110
 * @Description 110.平衡二叉树
 * @Author shishi
 * @Date 2019/7/5 15:06
 **/


/**
 * 题目要求：
 * 给定一个二叉树，判断它是否是高度平衡的二叉树。
 * 本题中，一棵高度平衡二叉树定义为：
 * 一个二叉树每个节点 的左右两个子树的高度差的绝对值不超过1。
 *
 * 示例：
 * 给定二叉树 [3,9,20,null,null,15,7]   返回 true
 * 给定二叉树 [1,2,2,3,3,null,null,4,4]  返回 false
 */
public class Solution110 {
    public boolean isBalanced(TreeNode root) {
        return depth(root)!=-1;
    }

    // 只有当当前节点是平衡二叉树的时候，才会返回深度，否则直接返回-1
    private int depth(TreeNode node) {
        if (node==null) return 0;
        int left = depth(node.left);
        // 剪枝
        if (left==-1) return -1;
        int right = depth(node.right);
        // 剪枝
        if (right==-1) return -1;
        return Math.abs(left-right)<2 ? Math.max(left,right)+1 : -1;
    }
}

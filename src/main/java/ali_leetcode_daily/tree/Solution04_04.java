package ali_leetcode_daily.tree;

/**
 * @ClassName Solution04_04
 * @Description 面试题 04.04. 检查平衡性
 * @Author shishi
 * @Date 2020/6/27 9:21
 **/

/**
 * 平衡树的定义如下：任意一个节点，其两棵子树的高度差不超过 1。
 */
public class Solution04_04 {
    // 递归判断根节点和左右子树结点是否都平衡
    public boolean isBalanced(TreeNode root) {
        if (root == null || (root.left == null && root.right == null))
            return true;

        int leftHeight = helper(root.left);
        int rightHeight = helper(root.right);
        return Math.abs(leftHeight - rightHeight) <= 1 && isBalanced(root.left) && isBalanced(root.right);
    }

    // 计算树的高度
    private int helper(TreeNode node) {
        if (node == null)
            return 0;
        return Math.max(helper(node.left), helper(node.right)) + 1;
    }
}

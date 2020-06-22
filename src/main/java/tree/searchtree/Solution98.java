package tree.searchtree;

/**
 * @ClassName Solution98
 * @Description 98.验证二叉搜索树
 * @Author shishi
 * @Date 2019/7/9 22:47
 **/

/**
 * 给定一个二叉树，判断其是否是一个有效的二叉搜索树。
 * 假设一个二叉搜索树具有如下特征：
 * 节点的左子树只包含小于当前节点的数。
 * 节点的右子树只包含大于当前节点的数。
 * 所有左子树和右子树自身必须也是二叉搜索树
 */
public class Solution98 {
    // 利用最大值、最小值(注意，这里的测试用例会超出Integer的范围，所以需要用Long)
    // 还有的方法是利用“中序遍历”，因为二叉搜索树的中序遍历一定是有序的
    public boolean isValidBST(TreeNode root) {
        return isBST(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    private boolean isBST(TreeNode root, long minValue, long maxValue) {
        if (root == null) return true;
        return root.val > minValue && root.val < maxValue
                && isBST(root.left, minValue, root.val)
                && isBST(root.right, root.val, maxValue);
    }

}

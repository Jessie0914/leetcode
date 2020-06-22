package day_practice.may;

import day_practice.TreeNode;

/**
 * @ClassName Solution98
 * @Description 98. 验证二叉搜索树
 * @Author shishi
 * @Date 2020/5/5 9:59
 **/
public class Solution98 {
    public boolean isValidBST(TreeNode root) {
        if (root == null || (root.left == null && root.right == null))
            return true;
        return isValid(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    private boolean isValid(TreeNode root, long minValue, long maxValue) {
        if (root == null)
            return true;
        return root.val > minValue && root.val < maxValue
                && isValid(root.left, minValue, root.val)
                && isValid(root.right, root.val, maxValue);
    }
}

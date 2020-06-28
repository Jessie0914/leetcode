package ali_leetcode_daily.tree;

/**
 * @author chiyue
 * @Description ��ָ Offer 55 - II. ƽ�������
 * @date 2020/6/28 2:22 ����
 */
public class Solution_jianzhi_51_2 {
    public boolean isBalanced(TreeNode root) {
        if (root == null) {
            return true;
        }

        if (root.left == null && root.right == null) {
            return true;
        }

        return Math.abs(depth(root.left) - depth(root.right)) <= 1 && isBalanced(root.left) && isBalanced(root.right);
    }

    private int depth(TreeNode root) {
        if (root == null) {
            return 0;
        }

        if (root.left == null && root.right == null) {
            return 1;
        }

        return Math.max(depth(root.left), depth(root.right)) + 1;
    }
}

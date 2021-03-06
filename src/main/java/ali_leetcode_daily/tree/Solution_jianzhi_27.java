package ali_leetcode_daily.tree;

/**
 * @author chiyue
 * @Description 剑指 Offer 27. 二叉树的镜像
 * @date 2020/6/28 11:58 上午
 */

/**
 * 请完成一个函数，输入一个二叉树，该函数输出它的镜像。
 */
public class Solution_jianzhi_27 {
    public TreeNode mirrorTree(TreeNode root) {
        if (root == null) {
            return null;
        }

        if (root.left==null && root.right==null){
            return root;
        }

        TreeNode tmp = root.left;
        root.left = root.right;
        root.right = tmp;

        mirrorTree(root.left);
        mirrorTree(root.right);

        return root;
    }
}

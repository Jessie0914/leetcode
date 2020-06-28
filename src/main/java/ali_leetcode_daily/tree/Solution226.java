package ali_leetcode_daily.tree;

/**
 * @ClassName Solution226
 * @Description 226. 翻转二叉树
 * @Author shishi
 * @Date 2020/6/27 9:33
 **/
public class Solution226 {
    public TreeNode invertTree(TreeNode root) {
        if (root == null || (root.left == null && root.right == null))
            return root;

        TreeNode left = root.left;
        root.left = root.right;
        root.right = left;
        invertTree(root.left);
        invertTree(root.right);

        return root;
    }
}

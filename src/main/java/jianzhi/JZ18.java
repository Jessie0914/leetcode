package jianzhi;

/**
 * @ClassName JZ18
 * @Description 操作给定的二叉树，将其变换为源二叉树的镜像。
 * @Author shishi
 * @Date 2020/7/13 23:18
 **/
public class JZ18 {
    public void Mirror(TreeNode root) {
        if (root == null)
            return;

        helper(root);
    }

    private void helper(TreeNode root) {
        if (root == null)
            return;

        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;

        helper(root.left);
        helper(root.right);
    }
}

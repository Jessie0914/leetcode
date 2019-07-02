package tree;

/**
 * @ClassName Solution101
 * @Description 101.对称二叉树
 * @Author shishi
 * @Date 2019/6/27 16:48
 **/

/**
 * 给定一个二叉树，检查它是否是镜像对称的
 */
public class Solution101 {
    // 这棵树本身对称的话，那么它与本身对称
    public boolean isSymmetric(TreeNode root) {
        return isMirror(root,root);
    }

    // 比较两颗树是否对称
    public boolean isMirror(TreeNode root1, TreeNode root2){
        // 如果都为空，当然对称
        if (root1 == null && root2 == null) return true;
        // 如果一个为空，一个非空，那么一定不对称
        if ((root1 == null && root2 != null) || (root1 != null && root2 == null)) return false;
        // 如果节点本身的值不同，那么一定不对称
        if (root1.val != root2.val) return false;

        // 接下来就是划分成子问题去解决
        // 两棵树对称的条件是：第一棵树的左子树和第二棵树的右子树是对称的并且第一棵树的右子树和第二棵树的左子树是对称的
        boolean mirror = isMirror(root1.right, root2.left) && isMirror(root1.left, root2.right);
        return mirror;
    }
}

package tree.recursion;

/**
 * @ClassName Solution112
 * @Description 112.路径总和
 * @Author shishi
 * @Date 2019/7/11 18:03
 **/

/**
 * 给定一个二叉树和一个目标和，判断该树中是否存在根节点到叶子节点的路径，这条路径上所有节点值相加等于目标和。
 */
public class Solution112 {
    // 递归解法
    public boolean hasPathSum(TreeNode root, int sum) {
        // 注意root为null的情况，否则通不过所有的case
        if (root==null) return false;
        if (root.left!=null && root.right!=null){
            return hasPathSum(root.left, sum - root.val) || hasPathSum(root.right,sum-root.val);
        }
        else if (root.left==null && root.right!=null){
            return hasPathSum(root.right,sum-root.val);
        }
        else if (root.left!=null && root.right==null){
            return hasPathSum(root.left,sum-root.val);
        }
        else {
            return root.val==sum;
        }
    }
}

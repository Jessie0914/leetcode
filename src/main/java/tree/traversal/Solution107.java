package tree.traversal;

/**
 * @ClassName Solution107
 * @Description 107.二叉树的层序遍历2
 * @Author shishi
 * @Date 2019/7/4 13:08
 **/

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 给定一个二叉树，返回其节点值自底向上的层次遍历。 （即按从叶子节点所在层到根节点所在的层，逐层从左向右遍历）
 * 例如：
 * 给定二叉树 [3,9,20,null,null,15,7],
 * 返回其自底向上的层次遍历为：
 * [
 *   [15,7],
 *   [9,20],
 *   [3]
 * ]
 */
public class Solution107 {
    List<List<Integer>> levels = new ArrayList<>();

    // 跟102题基本上一模一样，就是最后翻转一下list即可
    // Collections.reverse(List);
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        if (root == null) return levels;
        helper(root,1);
        Collections.reverse(levels);
        return levels;
    }

    // 递归函数
    private void helper(TreeNode root, int level) {
        if (levels.size()<level){
            levels.add(new ArrayList<>());
        }
        levels.get(level-1).add(root.val);

        if (root.left!=null){
            helper(root.left,level+1);
        }
        if (root.right!=null){
            helper(root.right,level+1);
        }
    }
}

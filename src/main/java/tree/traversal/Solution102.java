package tree.traversal;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName Solution102
 * @Description 102.二叉树的层序遍历
 * @Author shishi
 * @Date 2019/7/4 13:08
 **/

/**
 * 给定一个二叉树，返回其按层次遍历的节点值。 （即逐层地，从左到右访问所有节点）。
 * 给定二叉树: [3,9,20,null,null,15,7]
 * 返回其层次遍历结果：
 * [
 *   [3],
 *   [9,20],
 *   [15,7]
 * ]
 */
public class Solution102 {
    // 定义一个list
    List<List<Integer>> levels = new ArrayList<>();

    // 递归函数（重要）
    public void helper(TreeNode node, int level){
        // 如果list的容量小于层数，就需要增加list的容量
        if (levels.size() < level){
            levels.add(new ArrayList<>());
        }
        // 将当前节点的值加入到当前层该在的那个list
        levels.get(level-1).add(node.val);

        // 再递归左子树和右子树
        if (node.left!=null){
            helper(node.left,level+1);
        }
        if (node.right!=null){
            helper(node.right,level+1);
        }
    }

    public List<List<Integer>> levelOrder(TreeNode root) {
        if (root==null) return levels;
        // 交给递归函数，根节点层定义为第一层
        helper(root,1);
        return levels;
    }
}

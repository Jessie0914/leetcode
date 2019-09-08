package tree.traversal;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @ClassName Solution144
 * @Description 144.二叉树的前序遍历
 * @Author shishi
 * @Date 2019/7/4 12:15
 **/

/**
 * 题目要求：
 * 给定一个二叉树，返回它的 前序 遍历。
 *
 * 示例：
 * 输入: [1,null,2,3]
 * 输出: [1,2,3]
 */
public class Solution144 {
    // 先把头结点压进去，然后出栈，如果右节点不为空就压入栈，如果左结点不为空也压入栈（先右后左，因为是栈）
    // 我不需要用到栈，我用的是递归
    // 而且List竟然可以直接往后面增加一个list1，list.addAll(list1)
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        if (root==null) return list;
        else list.add(root.val);

        List<Integer> listLeft = preorderTraversal(root.left);
        list.addAll(listLeft);
        List<Integer> listRight = preorderTraversal(root.right);
        list.addAll(listRight);
        return list;
    }

    // 用迭代的方法实现（栈）
    // 提交过后，发现占的内存以及消耗的时间也并没有比递归优秀多少。。（why？）
    public List<Integer> preorderTraversal2(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();

        if (root==null) return list;
        stack.push(root);
        while (!stack.isEmpty()){
            TreeNode popNode = stack.pop();
            list.add(popNode.val);
            if (popNode.right!=null) stack.push(popNode.right);
            if (popNode.left!=null) stack.push(popNode.left);
        }
        return list;
    }
}

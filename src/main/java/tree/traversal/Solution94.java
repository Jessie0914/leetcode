package tree.traversal;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @ClassName Solution94
 * @Description 94.二叉树的中序遍历
 * @Author shishi
 * @Date 2019/7/4 12:56
 **/
public class Solution94 {
    // 递归还是很简单
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        if (root == null) return list;

        List<Integer> listLeft = inorderTraversal(root.left);
        list.addAll(listLeft);
        list.add(root.val);
        List<Integer> listRight = inorderTraversal(root.right);
        list.addAll(listRight);

        return list;
    }

    // 用迭代的方式
    // 这个提交之后，效率甚至比递归还要差啊。。
    public List<Integer> inorderTraversal2(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();

        TreeNode cur = root;
        while (cur!=null || !stack.isEmpty()){
            // 如果当前结点的不为空，就一直把此结点压入栈，并往左结点走
            while (cur!=null){
                stack.push(cur);
                cur = cur.left;
            }
            // 如果cur结点为空的话，就该弹出栈了,并且把数据加入list
            // 并把cur的右节点当做cur
            cur = stack.pop();
            list.add(cur.val);
            cur = cur.right;
        }
        return list;
    }
}

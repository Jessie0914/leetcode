package tree.traversal;

/**
 * @ClassName Solution145
 * @Description 145.二叉树的后续遍历
 * @Author shishi
 * @Date 2019/7/4 12:46
 **/

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 给定一个二叉树，返回它的 后序 遍历
 * 输入: [1,null,2,3]
 * 输出: [3,2,1]
 */
public class Solution145 {
    // 递归方法很简单，可以尝试一下迭代的方式
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        if (root==null) return list;
        List<Integer> listLeft = postorderTraversal(root.left);
        list.addAll(listLeft);
        List<Integer> listRight = postorderTraversal(root.right);
        list.addAll(listRight);

        list.add(root.val);

        return list;
    }

    // 迭代的方式，用栈（这个比较难）
    // 提交过后，效率稍微高了那么一点点
    public List<Integer> postorderTraversal2(TreeNode root) {
        ArrayList<Integer> result = new ArrayList<>();
        Stack<TreeNode> s = new Stack<>();

        //p是正在访问的结点，q是刚刚访问过的结点
        TreeNode p = root;
        TreeNode q = null;

        do {
            /* 往左下走*/
            while (p != null) {
                s.push(p);
                p = p.left;
            }
            q = null;
            while (!s.empty()) {
                p = s.pop();
                /* 右孩子不存在或已被访问，访问之*/
                if (p.right == q) {
                    result.add(p.val);
                    q = p; /* 保存刚访问过的结点*/
                }
                /* 当前结点不能访问，需第二次进栈*/
                else {
                    s.push(p);
                    /* 先处理右子树*/
                    p = p.right;
                    break;
                }
            }
        } while (!s.empty());
        return result;
    }
}

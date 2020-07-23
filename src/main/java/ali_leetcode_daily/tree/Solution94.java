package ali_leetcode_daily.tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @ClassName Solution94
 * @Description 非递归方式实现二叉树的中序遍历
 * @Author shishi
 * @Date 2020/7/23 23:04
 **/
public class Solution94 {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        if (root == null)
            return list;

        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur = root;
        while (cur != null || !stack.isEmpty()) {
            // 只要还有左子树，就一直压栈，直到左子树为空
            while (cur != null) {
                stack.push(cur);
                cur = cur.left;
            }

            // 直到遍历到最最左边了，先pop出一个元素
            TreeNode pop = stack.pop();
            // 先加入到list中
            list.add(pop.val);
            // 然后将cur更新为pop出的元素的右子树（继续上述的过程）
            if (pop.right!=null)
                cur = pop.right;
        }
        return list;
    }
}

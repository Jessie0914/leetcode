package tree.traversal;

/**
 * @ClassName Solution173_2
 * @Description 173.二叉树的中序遍历的另一种解法（栈）
 * @Author shishi
 * @Date 2019/7/4 20:15
 **/

import java.util.Stack;

// 这里用了栈的方式，效率也是没有提高太多
public class Solution173_2 {
    Stack<TreeNode> stack;
    public Solution173_2(TreeNode root) {
        this.stack = new Stack<>();
        while (root!=null){
            stack.push(root);
            root = root.left;
        }
    }

    /** @return the next smallest number */
    public int next() {
        TreeNode popNode = stack.pop();
        if (popNode.right!=null){
            TreeNode node = popNode.right;
            while (node!=null){
                stack.push(node);
                node = node.left;
            }
        }
        return popNode.val;
    }

    /** @return whether we have a next smallest number */
    public boolean hasNext() {
        return !stack.isEmpty();
    }
}

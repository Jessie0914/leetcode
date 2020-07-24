package ali_leetcode_daily.tree;

import java.util.List;
import java.util.Stack;

/**
 * @Classname Non_Recursion_Tranversal
 * @Description 非递归遍历二叉树
 * @Date 2020/7/24 11:17 上午
 * @Created by chiyue
 */
public class Non_Recursion_Traversal {
    // 先序遍历
    // 是非递归中最简单的。只需要按照[根节点->右子树->左子树]
    public void preOrderTraversal(TreeNode root, List<Integer> list) {
        if (root == null)
            return;

        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);

        while (!stack.isEmpty()) {
            TreeNode pop = stack.pop();
            list.add(pop.val);
            if (pop.right != null)
                stack.push(pop.right);
            if (pop.left != null)
                stack.push(pop.left);
        }
    }

    // 中序遍历
    // 用一个额外的变量表示当前遍历的节点
    // 如果cur的left不为空的话，就不停的入栈，直到到达最左下角
    // 然后出栈放到list，然后开始遍历right
    public void inOrderTraversal(TreeNode root, List<Integer> list) {
        if (root == null)
            return;

        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur = root;
        while (cur != null || !stack.isEmpty()) {
            while (cur != null) {
                stack.push(cur);
                cur = cur.left;
            }
            TreeNode pop = stack.pop();
            list.add(pop.val);
            cur = pop.right;
        }
    }

    // 后序遍历
    // 简单一点的做法是用两个栈来实现
    // 第一个栈 s1顺序：[根节点->左子树->右子树]
    // 然后s1每次pop根结点，就会存放到s2
    // 所以第二个栈 s2顺序：[左子树->右子树->根节点]
    public void postOrderTraversal_1(TreeNode root, List<Integer> list) {
        if (root == null)
            return;

        Stack<TreeNode> s1 = new Stack<>();
        Stack<TreeNode> s2 = new Stack<>();

        s1.push(root);
        while (!s1.isEmpty()) {
            TreeNode pop = s1.pop();
            s2.push(pop);

            if (pop.left != null)
                s1.push(pop.left);
            if (pop.right != null)
                s1.push(pop.right);
        }

        // s2存放的顺序就是后序遍历的顺序
        while (!s2.isEmpty())
            list.add(s2.pop().val);
    }

    // 后序遍历
    // 只用1个栈+两个变量，有点难理解
    // https://www.cnblogs.com/wangkaipeng/p/9776778.html
    public void postOrderTraversal_2(TreeNode root, List<Integer> list) {
        if (root == null)
            return;

        Stack<TreeNode> s = new Stack<>();
        s.push(root);
        // 上次遍历完左右子树并打印出来的节点
        TreeNode lastNode = root;
        // 栈顶元素
        TreeNode peek = null;

        while (!s.isEmpty()) {
            peek = s.peek();

            // 说明栈顶元素的左子树还未处理过，就先把左子树入栈
            if (peek.left != null && (lastNode != peek.left && lastNode != peek.right))
                s.push(peek.left);
            // 说明左子树已经处理过，但右子树还未处理，将右子树入栈
            else if (peek.right != null && lastNode != peek.right)
                s.push(peek.right);
            // 说明左右子树都已经遍历过了，就该出栈了，并更新lastNode
            else {
                list.add(s.pop().val);
                lastNode = peek;
            }
        }
    }

}

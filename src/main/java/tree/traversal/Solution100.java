package tree.traversal;

/**
 * @ClassName Solution100
 * @Description 100.相同的树
 * @Author shishi
 * @Date 2019/6/27 15:35
 **/

/**
 * 题目要求：
 * 给定两个二叉树，编写一个函数来检验它们是否相同。
 * 如果两个树在结构上相同，并且节点具有相同的值，则认为它们是相同的。
 */
public class Solution100 {
    /**
     * 递归判断，首先判断本身结点的值是否相同，如果相同，那么就分别再递归判断左子树和右子树
     * 从leetcode题解中学到一个技巧（我觉得很有用，要记住）
     * 即解决树算法的算法框架，都是分成两块：
     * ①想想当前节点需要做的事情
     * ②拆分成子问题
     */
    public boolean isSameTree(TreeNode p, TreeNode q) {
        // 考虑当前节点要做的事情

        // 如果p、q都为null的话，是相同的
        if (p==null && q==null) return true;
        // 如果一个为空一个为非空，就是不同的
        if ((p==null&&q!=null) || (p!=null&&q==null)) return false;
        // 如果节点的值本身不一样，那么也是不同的
        if (p.val != q.val) return false;

        // 然后考虑递归的内容
        boolean isSame = isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
        return isSame;
    }
}

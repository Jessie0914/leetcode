package tree.traversal;

/**
 * @ClassName Solution173
 * @Description 173.二叉搜索树迭代器
 * @Author shishi
 * @Date 2019/7/4 16:58
 **/

import java.util.LinkedList;
import java.util.Queue;

/**
 * 实现一个二叉搜索树迭代器。你将使用二叉搜索树的根节点初始化迭代器。
 * 调用 next() 将返回二叉搜索树中的下一个最小的数。
 */
public class Solution173 {
    // 思想就是利用二叉树的中序遍历，但是我还是用的递归，所以效率就比较差，最好使用迭代
    Queue<Integer> queue;
    public Solution173(TreeNode root) {
        this.queue = inOrder(root);
    }

    // 中序遍历
    public Queue inOrder(TreeNode root){
        Queue<Integer> queue = new LinkedList<>();
        if (root==null) return queue;
        Queue<Integer> queueLeft = inOrder(root.left);
        queue.addAll(queueLeft);

        queue.offer(root.val);

        Queue<Integer> queueRight = inOrder(root.right);
        queue.addAll(queueRight);

        return queue;
    }

    /** @return the next smallest number */
    public int next() {
        return queue.poll();
    }

    /** @return whether we have a next smallest number */
    public boolean hasNext() {
        return !queue.isEmpty();
    }
}

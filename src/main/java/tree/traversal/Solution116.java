package tree.traversal;

/**
 * @ClassName Solution116
 * @Description 116.填充每个节点的下一个右侧节点指针
 * @Author shishi
 * @Date 2019/7/9 17:43
 **/

import java.util.LinkedList;
import java.util.Queue;

/**
 * 题目要求：
 * 给定一个完美二叉树，其所有叶子节点都在同一层，每个父节点都有两个子节点。
 * 填充它的每个 next 指针，让这个指针指向其下一个右侧节点。如果找不到下一个右侧节点，则将 next 指针设置为 NULL。
 */

/**
 * 看到的题解中别人的好的解法：拉链法
 * 她是用递归的方法的，但是代码十分的简洁
 * 它就是分为左子树和右子树，然后当左子树不为零的时候，就做如下的操作
 * （将左子树的结点指向右子树的结点，然后将左子树的右节点当做新的左子树，右子树的左结点当做新的右子树）
 * 然后再递归遍历这个结点的左结点，和右节点，就可以将左右的结点都涵盖到
 */
public class Solution116 {
    // 我用的是队列，把当前节点先放入队列中，每次弹出之前，把它的左右子树节点放入另外一个队列
    // 相当于每个队列其实放的都是一层的结点（类似于层次遍历）
    // 然后每个结点弹出之前都连接一下下一个结点就可以了
    public Node connect(Node root) {
        if (root==null) return null;
        Queue<Node> queue = new LinkedList<>();
        Queue<Node> tmp = new LinkedList<>();
        if (root!=null) queue.offer(root);
        while (!queue.isEmpty()){
            while (queue.size()!=1){
                Node pollNode = queue.poll();
                if (pollNode.left!=null) tmp.offer(pollNode.left);
                if (pollNode.right!=null) tmp.offer(pollNode.right);
                pollNode.next = queue.peek();
            }
            Node lastPollNode = queue.poll();
            if (lastPollNode.left!=null) tmp.offer(lastPollNode.left);
            if (lastPollNode.right!=null) tmp.offer(lastPollNode.right);
            lastPollNode.next = null;
            Queue<Node> swap = tmp;
            tmp = queue;
            queue = swap;
        }
        return root;
    }
}

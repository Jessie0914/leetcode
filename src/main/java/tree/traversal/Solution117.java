package tree.traversal;

/**
 * @ClassName Solution117
 * @Description 117.填充每个节点的下一个右侧节点指针2
 * @Author shishi
 * @Date 2019/7/9 19:25
 **/

import java.util.LinkedList;
import java.util.Queue;

/**
 * 给定一个二叉树
 * 填充它的每个 next 指针，让这个指针指向其下一个右侧节点。如果找不到下一个右侧节点，则将 next 指针设置为 NULL。
 * 2和1的区别，就是1是“完美二叉树”，2是无论哪种二叉树
 */
public class Solution117 {
    // 这里和我116的方法是一样的，因为我116的方法也并不是只适用于“完美二叉树”
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

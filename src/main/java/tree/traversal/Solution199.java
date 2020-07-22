package tree.traversal;

/**
 * @ClassName Solution199
 * @Description 199.二叉树的右视图
 * @Author shishi
 * @Date 2019/7/4 15:20
 **/

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 给定一棵二叉树，想象自己站在它的右侧，按照从顶部到底部的顺序，返回从右侧所能看到的节点值。
 * 输入: [1,2,3,null,5,null,4]
 * 输出: [1, 3, 4]
 */
public class Solution199 {
    // 一开始的想法是错的，我直接一直递归遍历右子树的右节点，但是当右子树为null时，右视图也是能看到左子树的结点的，所以这思路是错的
    public List<Integer> rightSideView(TreeNode root) {
        // 用到的是层序遍历的思想
        // 每次层序遍历之后，只添加层序遍历的最后一个元素
        List<Integer> resultList = new ArrayList<>();

        // 定义两个栈，是用来存放当前节点，以及当前节点的左子树和右子树的
        Queue<TreeNode> current = new LinkedList<>();
        Queue<TreeNode> next = new LinkedList<>();

        if (root == null) return resultList;
        else {
            // 先把根节点压入队列
            current.offer(root);
        }

        // 当current不为空时，就一直遍历
        while (!current.isEmpty()){
            List<Integer> levelList = new ArrayList<>();

            while (!current.isEmpty()){
                // 弹出当前元素
                TreeNode pollNode = current.poll();
                // 当前元素加入当前层的List
                levelList.add(pollNode.val);
                // 将左右结点压入next队列
                if (pollNode.left!=null){
                    next.offer(pollNode.left);
                }
                if (pollNode.right!=null){
                    next.offer(pollNode.right);
                }
            }
            // 每次清空current栈之后，都加入当前levelList中最后一个元素
            resultList.add(levelList.get(levelList.size()-1));

            // 交换current和next队列，所以只有当next队列也完全空的时候，才能彻底结束循环
            Queue tmp = current;
            current = next;
            next = tmp;
        }
        return resultList;
    }
}


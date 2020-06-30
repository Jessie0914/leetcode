package ali_leetcode_daily.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @ClassName Solution_jianzhi_32_2
 * @Description 剑指 Offer 32 - II. 从上到下打印二叉树 II
 * @Author shishi
 * @Date 2020/6/29 21:49
 **/

/**
 * 从上到下按层打印二叉树，同一层的节点按从左到右的顺序打印，每一层打印到一行。
 */
public class Solution_jianzhi_32_2 {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null)
            return res;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            List<Integer> list = new ArrayList<>();

            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode poll = queue.poll();
                list.add(poll.val);

                if (poll.left != null)
                    queue.offer(poll.left);
                if (poll.right != null)
                    queue.offer(poll.right);
            }

            res.add(list);
        }

        return res;
    }
}

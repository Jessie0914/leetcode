package ali_leetcode_daily.bytedance;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @Classname Solution102
 * @Description 二叉树的层序遍历
 * @Date 2020/8/4 5:37 下午
 * @Created by chiyue
 */
public class Solution102 {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> lists = new ArrayList<>();
        if (root == null)
            return lists;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            ArrayList<Integer> list = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                TreeNode poll = queue.poll();
                list.add(poll.val);
                if (poll.left != null)
                    queue.offer(poll.left);
                if (poll.right != null)
                    queue.offer(poll.right);
            }
            lists.add(list);
        }

        return lists;
    }
}

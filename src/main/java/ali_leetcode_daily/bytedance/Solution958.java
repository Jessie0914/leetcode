package ali_leetcode_daily.bytedance;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @ClassName Solution958
 * @Description 958. 二叉树的完全性检验
 * @Author shishi
 * @Date 2020/8/4 22:55
 **/
public class Solution958 {
    public boolean isCompleteTree(TreeNode root) {
        if (root == null)
            return true;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        TreeNode pre = root;

        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode poll = queue.poll();

                if (pre == null && poll != null)
                    return false;
                pre = poll;

                if (poll != null) {
                    queue.offer(poll.left);
                    queue.offer(poll.right);
                }
            }
        }
        return true;
    }
}

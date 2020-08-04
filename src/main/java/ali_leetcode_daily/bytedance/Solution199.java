package ali_leetcode_daily.bytedance;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @ClassName Solution199
 * @Description 199. 二叉树的右视图
 * @Author shishi
 * @Date 2020/8/4 21:15
 **/
public class Solution199 {
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> list = new ArrayList<>();

        if (root == null)
            return list;

        Queue<TreeNode> cur = new LinkedList<>();
        cur.offer(root);

        while (!cur.isEmpty()) {
            int size = cur.size();
            for (int i = 0; i < size; i++) {
                TreeNode poll = cur.poll();
                if (i == size - 1) {
                    list.add(poll.val);
                }

                if (poll.left != null)
                    cur.offer(poll.left);
                if (poll.right != null)
                    cur.offer(poll.right);
            }
        }

        return list;
    }
}

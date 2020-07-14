package jianzhi;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @ClassName JZ22
 * @Description 从上往下打印出二叉树的每个节点，同层节点从左至右打印。
 * @Author shishi
 * @Date 2020/7/14 23:44
 **/
public class JZ22 {
    public ArrayList<Integer> PrintFromTopToBottom(TreeNode root) {
        ArrayList<Integer> list = new ArrayList<>();
        if (root == null)
            return list;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            TreeNode poll = queue.poll();
            list.add(poll.val);

            if (poll.left != null)
                queue.offer(poll.left);

            if (poll.right != null)
                queue.offer(poll.right);
        }
        return list;
    }
}

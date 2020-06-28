package ali_leetcode_daily.tree;

/**
 * @author chiyue
 * @Description ��ָ Offer 28. �ԳƵĶ�����
 * @date 2020/6/28 1:59 ����
 */

/**
 * ��ʵ��һ�������������ж�һ�ö������ǲ��ǶԳƵġ����һ�ö����������ľ���һ������ô���ǶԳƵġ�
 */
public class Solution_jianzhi_28 {
    public boolean isSymmetric(TreeNode root) {
        if (root == null) {
            return true;
        }

        if (root.left == null && root.right == null) {
            return true;
        }

        if ((root.left != null && root.right == null) || (root.left == null && root.right != null)) {
            return false;
        }

        if (root.left.val != root.right.val) {
            return false;
        } else {
            return judge(root.left, root.right);
        }
    }

    private boolean judge(TreeNode node1, TreeNode node2) {
        if (node1==null && node2==null){
            return true;
        }

        if (node1 == null && node2 != null) {
            return false;
        }

        if (node2 == null && node1 != null) {
            return false;
        }

        if (node1.val != node2.val) {
            return false;
        } else {
            return judge(node1.left, node2.right) && judge(node1.right, node2.left);
        }
    }
}

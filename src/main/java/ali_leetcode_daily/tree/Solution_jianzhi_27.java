package ali_leetcode_daily.tree;

/**
 * @author chiyue
 * @Description ��ָ Offer 27. �������ľ���
 * @date 2020/6/28 11:58 ����
 */

/**
 * �����һ������������һ�����������ú���������ľ���
 */
public class Solution_jianzhi_27 {
    public TreeNode mirrorTree(TreeNode root) {
        if (root == null) {
            return null;
        }

        if (root.left==null && root.right==null){
            return root;
        }

        TreeNode tmp = root.left;
        root.left = root.right;
        root.right = tmp;

        mirrorTree(root.left);
        mirrorTree(root.right);

        return root;
    }
}

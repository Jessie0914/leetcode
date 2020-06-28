package ali_leetcode_daily.tree;

/**
 * @author chiyue
 * @Description ������ 04.02. ��С�߶���
 * @date 2020/6/28 2:31 ����
 */

/**
 * ����һ�������������飬Ԫ�ظ�����ͬ�Ұ��������У���дһ���㷨������һ�ø߶���С�Ķ�����������
 * ������������: [-10,-3,0,5,9],
 * һ�����ܵĴ��ǣ�[0,-3,9,-10,null,5]
 */
public class Solution04_02 {
    public TreeNode sortedArrayToBST(int[] nums) {
        if (nums == null || nums.length == 0) {
            return null;
        }
        return construct(nums, 0, nums.length - 1);
    }

    private TreeNode construct(int[] nums, int i, int j) {
        if (i > j) {
            return null;
        }

        int mid = (i + j) / 2;
        TreeNode root = new TreeNode(nums[mid]);
        root.left = construct(nums, i, mid - 1);
        root.right = construct(nums, mid + 1, j);

        return root;
    }
}

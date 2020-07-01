package ali_leetcode_daily.dynamic_programming.house_robber;

import ali_leetcode_daily.tree.TreeNode;

import java.util.HashMap;

/**
 * @ClassName Solution337
 * @Description 337. 打家劫舍 III
 * @Author shishi
 * @Date 2020/7/1 21:22
 **/
public class Solution337 {
    HashMap<TreeNode, Integer> map = new HashMap<>();

    public int rob(TreeNode root) {
        if (root == null)
            return 0;

        if (root.left == null && root.right == null)
            return root.val;

        return helper(root);
    }

    private int helper(TreeNode root) {
        if (root == null)
            return 0;

        // 如果备忘录已经有了，那么就直接返回
        if (map.containsKey(root))
            return map.get(root);

        // 抢(只能选择下下个节点的左右子树继续选择)
        int res_robber = root.val
                + (root.left == null ? 0 : helper(root.left.left) + helper(root.left.right))
                + (root.right == null ? 0 : helper(root.right.left) + helper(root.right.right));

        // 不抢
        int res_not_robber = helper(root.left) + helper(root.right);

        // 最终取较大值
        int res = Math.max(res_robber, res_not_robber);

        // 放入备忘录
        map.put(root, res);

        return res;
    }


    // 另一种好的解法
    public int rob2(TreeNode root) {
        // res[0]是抢的结果，res[1]是不抢的结果
        int[] res = dp(root);

        return Math.max(res[0], res[1]);
    }

    private int[] dp(TreeNode root) {
        if (root == null)
            return new int[]{0, 0};

        int[] left = dp(root.left);
        int[] right = dp(root.right);

        int[] res = new int[2];
        // 抢
        res[0] = root.val + left[1] + right[1];

        // 不抢
        res[1] = Math.max(left[0], left[1]) + Math.max(right[0], right[1]);

        return res;
    }
}

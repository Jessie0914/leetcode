package ali_leetcode_daily.dynamic_programming.house_robber;

/**
 * @ClassName Solution198
 * @Description 198. 打家劫舍
 * @Author shishi
 * @Date 2020/7/1 20:57
 **/

/**
 * 输入：[1,2,3,1]
 * 输出：4
 * 解释：偷窃 1 号房屋 (金额 = 1) ，然后偷窃 3 号房屋 (金额 = 3)。
 *      偷窃到的最高金额 = 1 + 3 = 4 。
 */
public class Solution198 {
    public int rob(int[] nums) {
        if (nums == null || nums.length == 0)
            return 0;

        int len = nums.length;

        if (len == 1)
            return nums[0];

        // dp[i]代表前i个元素中的最大结果
        int[] dp = new int[len + 1];

        // base case
        dp[0] = 0;
        dp[1] = nums[0];

        // dp
        for (int i = 2; i < len + 1; i++) {
            dp[i] = Math.max(dp[i - 2] + nums[i - 1], dp[i - 1]);
        }

        return dp[len];
    }
}

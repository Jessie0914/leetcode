package ali_leetcode_daily.dynamic_programming.house_robber;

/**
 * @ClassName Solution213
 * @Description 213. 打家劫舍 II
 * @Author shishi
 * @Date 2020/7/1 21:10
 **/

import java.util.Arrays;

/**
 * 所有的房屋都围成一圈，这意味着第一个房屋和最后一个房屋是紧挨着的。
 * 也就是说第一间和最后一间其实也是相连的
 * 那么也就只有三种情况，选最大的那种情况即可
 * 1、第一间和最后一间都不抢（这种情况不可能是最大的）
 * 2、抢第一间
 * 3、抢最后一间
 */
public class Solution213 {
    public int rob(int[] nums) {
        if (nums == null || nums.length == 0)
            return 0;

        int len = nums.length;

        if (len == 1)
            return nums[0];

        return Math.max(
                helper(Arrays.copyOfRange(nums, 0, len - 1)),
                helper(Arrays.copyOfRange(nums, 1, len)));
    }

    public int helper(int[] nums) {
        int len = nums.length;

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

package cyc.algorithm.dynamic_programming;

/**
 * @program: leetcode
 * @description: 198. 打家劫舍
 * @author: shishi
 * @create: 2019-11-27 15:46
 **/

/**
 * 输入: [1,2,3,1]
 * 输出: 4
 * <p>
 * 输入: [2,7,9,3,1]
 * 输出: 12
 */

public class Number198 {
    public int rob(int[] nums) {
        int len = nums.length;
        // 特判
        if (len==0) return 0;
        if (len==1) return nums[0];

        // dp[i]代表着以第i个下标为结束的数组，能够抢劫到最高金额
        int[] dp = new int[len];
        dp[0] = nums[0];
        dp[1] = Math.max(nums[0],nums[1]);
        for (int i = 2; i < len; i++) {
            // 如果抢当前下标的元素，即nums[i]+dp[i-2]
            // 如果不抢当前下标的元素，即dp[i-1]
            dp[i] = Math.max(nums[i]+dp[i-2],dp[i-1]);
        }

        return dp[len-1];
    }
}

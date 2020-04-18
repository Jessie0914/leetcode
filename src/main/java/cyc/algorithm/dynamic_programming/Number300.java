package cyc.algorithm.dynamic_programming;

/**
 * @program: leetcode
 * @description: 300. 最长上升子序列
 * @author: shishi
 * @create: 2019-12-05 15:58
 **/

/**
 * 给定一个无序的整数数组，找到其中最长上升子序列的长度。
 * 输入: [10,9,2,5,3,7,101,18]
 * 输出: 4
 * 解释: 最长的上升子序列是 [2,3,7,101]，它的长度是 4。
 */
public class Number300 {
    // 动态规划
    // https://leetcode-cn.com/problems/longest-increasing-subsequence/solution/zui-chang-shang-sheng-zi-xu-lie-dong-tai-gui-hua-e/
    public int lengthOfLIS(int[] nums) {
        int length = nums.length;
        if (length == 0) return 0;

        int[] dp = new int[length];
        dp[0] = 1;
        int max = 0;
        for (int i = 1; i < length; i++) {
            dp[i] = 1;
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            max = Math.max(max, dp[i]);
        }

        return max;
    }
}

package ali_leetcode_daily.dynamic_programming.string;

/**
 * @ClassName Solution300
 * @Description 300. 最长上升子序列
 * @Author shishi
 * @Date 2020/6/29 21:02
 **/

import java.util.Arrays;

/**
 * 给定一个无序的整数数组，找到其中最长上升子序列的长度。
 * 输入: [10,9,2,5,3,7,101,18]
 * 输出: 4
 * 解释: 最长的上升子序列是 [2,3,7,101]，它的长度是 4。
 */
public class Solution300 {
    public int lengthOfLIS(int[] nums) {
        if (nums == null || nums.length == 0)
            return 0;

        int len = nums.length;
        if (len == 1)
            return 1;

        int[] dp = new int[len];
        int res = Integer.MIN_VALUE;
        Arrays.fill(dp, 1);

        for (int i = 1; i < len; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            res = Math.max(res, dp[i]);
        }

        return res;
    }
}

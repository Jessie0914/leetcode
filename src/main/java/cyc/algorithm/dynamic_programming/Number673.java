package cyc.algorithm.dynamic_programming;

/**
 * @program: leetcode
 * @description: 673. 最长递增子序列的个数
 * @author: shishi
 * @create: 2019-12-05 17:01
 **/

import java.util.Arrays;

/**
 * 给定一个未排序的整数数组，找到最长递增子序列的个数。
 * 输入: [1,3,5,4,7]
 * 输出: 2
 * 解释: 有两个最长递增子序列，分别是 [1, 3, 4, 7] 和[1, 3, 5, 7]。
 * <p>
 * 输入: [2,2,2,2,2]
 * 输出: 5
 * 解释: 最长递增子序列的长度是1，并且存在5个子序列的长度为1，因此输出5。
 */
public class Number673 {
    public int findNumberOfLIS(int[] nums) {
        int length = nums.length;
        if (length == 0)
            return 0;

        int[] dp = new int[length];
        int[] count = new int[length];
        Arrays.fill(dp, 1);
        Arrays.fill(count, 1);

        int maxLen = dp[0];
        for (int i = 1; i < length; i++) {
            dp[i] = 1;
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    // 第一次遇到要更新dp[i]的情况
                    // 就去把count[i]设置为count[j]一样
                    if (dp[j] + 1 > dp[i]) {
                        dp[i] = dp[j] + 1;
                        count[i] = count[j];
                    }
                    // 如果之后再遇到一样的情况，那么最起码也是第二次遇到了
                    // count[i]要加上count[j]的数量
                    else if (dp[j] + 1 == dp[i]) {
                        count[i] += count[j];
                    }
                }
            }
            maxLen = Math.max(dp[i], maxLen);
        }

        int res = 0;
        for (int i = 0; i < length; i++) {
            if (dp[i] == maxLen) {
                res += count[i];
            }
        }
        return res;
    }
}

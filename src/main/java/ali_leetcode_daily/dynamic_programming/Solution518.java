package ali_leetcode_daily.dynamic_programming;

/**
 * @ClassName Solution518
 * @Description 518. 零钱兑换 II
 * @Author shishi
 * @Date 2020/6/30 20:52
 **/

/**
 * 给定不同面额的硬币和一个总金额。写出函数来计算可以凑成总金额的硬币组合数。
 * 输入: amount = 5, coins = [1, 2, 5]
 * 输出: 4
 * 解释: 有四种方式可以凑成总金额:
 * 5=5
 * 5=2+2+1
 * 5=2+1+1+1
 * 5=1+1+1+1+1
 */
public class Solution518 {
    // 二维的
    public int change(int amount, int[] coins) {
        if (amount < 0 || coins == null)
            return 0;

        // 当len==0&&amount==0的时候，结果是1，所以也走下面的逻辑
        int len = coins.length;
        int[][] dp = new int[len + 1][amount + 1];

        // base case
        for (int j = 1; j < amount + 1; j++) {
            dp[0][j] = 0;
        }
        for (int i = 0; i < len + 1; i++) {
            dp[i][0] = 1;
        }

        // dp
        for (int i = 1; i < len + 1; i++) {
            for (int j = 1; j < amount + 1; j++) {
                if (j >= coins[i - 1]) {
                    dp[i][j] = dp[i - 1][j] + dp[i][j - coins[i - 1]];
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }

        return dp[len][amount];
    }

    // 压缩到一维
    public int change2(int amount, int[] coins) {
        if (amount < 0 || coins == null)
            return 0;

        int[] dp = new int[amount + 1];
        dp[0] = 1;
        for (int i = 0; i < coins.length; i++) {
            // 这需要j从前往后遍历
            // 因为dp[j]的状态与[i-1]和[i]都有关，所以需要从前往后
            for (int j = 1; j < amount + 1; j++) {
                if (j - coins[i] >= 0)
                    dp[j] += dp[j - coins[i]];
                else
                    dp[j] = dp[j];
            }
        }

        return dp[amount];
    }
}

package ali_leetcode_daily.dynamic_programming.stock;

/**
 * @ClassName Solution123
 * @Description 123. 买卖股票的最佳时机 III
 * @Author shishi
 * @Date 2020/7/4 22:08
 **/

/**
 * 最多可以完成 两笔 交易。
 */
public class Solution123 {
    public int maxProfit(int[] prices) {
        if (prices == null || prices.length < 2)
            return 0;

        int len = prices.length;
        int maxK = 2;
        int[][][] dp = new int[len][maxK + 1][2];

        // base case
        // 1、dp[0][k][0] = 0
        for (int k = 0; k <= maxK; k++)
            dp[0][k][0] = 0;

        // 2、dp[i][0][0] = 0
        for (int i = 0; i < len; i++)
            dp[i][0][0] = 0;

        // 3、dp[0][k][1] = -infinity
        for (int k = 0; k <= maxK; k++)
            dp[0][k][1] = -prices[0];

        // 4、dp[i][0][1] = -infinity
        for (int i = 0; i < len; i++)
            dp[i][0][1] = -prices[0];

        // dp
        for (int i = 1; i < len; i++) {
            for (int k = maxK; k > 0; k--) {
                dp[i][k][0] = Math.max(dp[i - 1][k][0], dp[i - 1][k][1] + prices[i]);

                dp[i][k][1] = Math.max(dp[i - 1][k][1], dp[i - 1][k - 1][0] - prices[i]);
            }
        }

        return dp[len - 1][maxK][0];
    }
}

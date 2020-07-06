package ali_leetcode_daily.dynamic_programming.stock;

/**
 * @ClassName Solution309
 * @Description 309. 最佳买卖股票时机含冷冻期
 * @Author shishi
 * @Date 2020/7/4 21:36
 **/
public class Solution309 {
    public int maxProfit(int[] prices) {
        if (prices == null || prices.length == 0)
            return 0;

        int len = prices.length;
        if (len < 2)
            return 0;

        int[][] dp = new int[len][2];

        // base case
        // 因为状态转移方程中有[i-2]的状态，所以base case更新到dp[1]
        // 这样dp从i=2开始，防止越界
        dp[0][0] = 0;
        dp[0][1] = -prices[0];
        dp[1][0] = Math.max(dp[0][0], dp[0][1] + prices[1]);
        dp[1][1] = Math.max(dp[0][1], 0 - prices[1]);

        // dp
        for (int i = 2; i < len; i++) {
            // no stock
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] + prices[i]);

            // have stock
            // 有冷冻期
            dp[i][1] = Math.max(dp[i - 1][1], dp[i - 2][0] - prices[i]);
        }

        return dp[len - 1][0];
    }
}

package ali_leetcode_daily.dynamic_programming.stock;

/**
 * 122. 买卖股票的最佳时机 II
 */
public class Solution122 {
    // 可以完成无数笔交易
    public int maxProfit(int[] prices) {
        if (prices == null || prices.length == 0)
            return 0;

        int len = prices.length;
        int[][] dp = new int[len][2];

        // base case
        dp[0][0] = 0;
        dp[0][1] = -prices[0];

        for (int i = 1; i < len; i++) {
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] + prices[i]);

            dp[i][1] = Math.max(dp[i - 1][1], dp[i - 1][0] - prices[i]);
        }

        return dp[len - 1][0];
    }
}

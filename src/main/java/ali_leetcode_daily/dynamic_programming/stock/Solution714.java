package ali_leetcode_daily.dynamic_programming.stock;

/**
 * @ClassName Solution714
 * @Description 714. 买卖股票的最佳时机含手续费
 * @Author shishi
 * @Date 2020/7/4 21:57
 **/
public class Solution714 {
    public int maxProfit(int[] prices, int fee) {
        if (prices == null || prices.length < 2)
            return 0;

        int len = prices.length;

        int[][] dp = new int[len][2];

        // base case
        dp[0][0] = 0;
        dp[0][1] = -prices[0] - fee;

        // dp
        for (int i = 1; i < len; i++) {
            // 现在没有股票
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] + prices[i]);

            // 现在有股票
            dp[i][1] = Math.max(dp[i - 1][1], dp[i - 1][0] - prices[i] - fee);
        }

        return dp[len - 1][0];
    }
}

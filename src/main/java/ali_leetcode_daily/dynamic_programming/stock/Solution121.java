package ali_leetcode_daily.dynamic_programming.stock;

/**
 * 121. 买卖股票的最佳时机
 */
public class Solution121 {
    // 只完成一笔交易
    // dp框架
    public int maxProfit(int[] prices) {
        if (prices == null || prices.length == 0)
            return 0;

        int len = prices.length;
        int[][] dp = new int[len][2];

        // base case
        dp[0][0] = 0; // 第一天没有持有股票（没有操作），收益为0
        dp[0][1] = -prices[0]; // 第一天持有股票(买了股票)，收益为﹣prices[0]

        // dp
        for (int i = 1; i < len; i++) {
            // 没有股票
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] + prices[i]);

            // 有股票
            dp[i][1] = Math.max(dp[i - 1][1], -prices[i]);
        }

        return dp[len - 1][0];
    }

    // 粗暴形式
    // [7,1,5,3,6,4]
    public int maxProfit2(int[] prices) {
        if (prices == null || prices.length == 0)
            return 0;

        int len = prices.length;

        int min = prices[0];
        int res = 0;

        for (int i = 1; i < len; i++) {
            if (prices[i] <= prices[i - 1]) {
                min = Math.min(min, prices[i]);
            } else {
                if (prices[i] - min > res)
                    res = prices[i] - min;
            }
        }

        return res;
    }
}

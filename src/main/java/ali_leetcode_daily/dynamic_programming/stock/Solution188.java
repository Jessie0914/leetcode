package ali_leetcode_daily.dynamic_programming.stock;

/**
 * @ClassName Solution188
 * @Description 188. 买卖股票的最佳时机 IV
 * @Author shishi
 * @Date 2020/7/4 23:30
 **/
public class Solution188 {
    public int maxProfit(int k, int[] prices) {
        if (prices == null || prices.length < 2)
            return 0;

        int len = prices.length;
        // 如果k>len/2，就说明k的约束没有用了，相当于k无穷的情况
        if (k > len / 2)
            return maxProfit(prices);

        int[][][] dp = new int[len][k + 1][2];

        // base case
        // 1、dp[0][k][0] = 0
        for (int index = 0; index <= k; index++)
            dp[0][index][0] = 0;
        // 2、dp[i][0][0] = 0
        for (int i = 0; i < len; i++)
            dp[i][0][0] = 0;
        // 3、dp[0][k][1] = -infinity
        for (int index = 0; index <= k; index++)
            dp[0][index][1] = -prices[0];
        // 4、dp[i][0][1] = -infinity
        for (int i = 0; i < len; i++)
            dp[i][0][1] = -prices[0];

        // dp
        for (int i = 1; i < len; i++) {
            for (int index = k; index > 0; index--) {
                dp[i][index][0] = Math.max(dp[i - 1][index][0], dp[i - 1][index][1] + prices[i]);

                dp[i][index][1] = Math.max(dp[i - 1][index][1], dp[i - 1][index - 1][0] - prices[i]);
            }
        }

        return dp[len - 1][k][0];
    }

    // 不受次数k限制的情况,k=+infinity
    private int maxProfit(int[] prices) {
        if (prices == null || prices.length < 2)
            return 0;

        int len = prices.length;
        int[][] dp = new int[len][2];

        // base case
        dp[0][0] = 0;
        dp[0][1] = -prices[0];

        // dp
        for (int i = 1; i < len; i++) {
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] + prices[i]);

            dp[i][1] = Math.max(dp[i - 1][1], dp[i - 1][0] - prices[i]);
        }

        return dp[len - 1][0];
    }
}

package ali_leetcode_daily.bytedance;

/**
 * @Classname Solution121
 * @Description 121. 买卖股票的最佳时机
 * @Date 2020/8/4 5:42 下午
 * @Created by chiyue
 */

/**
 * 输入: [7,1,5,3,6,4]
 * 输出: 5
 */
public class Solution121 {
    public int maxProfit(int[] prices) {
        if (prices == null || prices.length == 0)
            return 0;

        int len = prices.length;

        int[][] dp = new int[len][2];

        // base case
        dp[0][0] = 0;
        dp[0][1] = -prices[0];

        // dp process
        for (int i = 1; i < len; i++) {
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] + prices[i]);

            dp[i][1] = Math.max(dp[i - 1][1], 0 - prices[i]);
        }

        return dp[len - 1][0];

    }

    public int maxProfit2(int[] prices) {
        if (prices == null || prices.length == 0)
            return 0;

        int min = prices[0];
        int result = 0;

        int i = 1;
        while (i < prices.length) {
            // 往下降的情况
            if (prices[i] < prices[i - 1]) {
                min = Math.min(min, prices[i]);
            } else {
                result = Math.max(result, prices[i] - min);
            }
            i++;
        }

        return result;

    }
}

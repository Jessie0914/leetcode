package DayPractice.March;

/**
 * @ClassName Solution121
 * @Description 121. 买卖股票的最佳时机
 * @Author shishi
 * @Date 2020/4/2 14:19
 **/
public class Solution121 {
    public int maxProfit(int[] prices) {
        int profit = 0;
        int min = prices[0];
        int i = 1;
        while (i < prices.length) {
            // 如果是下降的，去更新min值
            if (prices[i] < min) {
                min = prices[i];
            }
            // 否则，尝试去更新profit
            else {
                if (prices[i] - min > profit) {
                    profit = prices[i] - min;
                }
            }
            i++;
        }

        return profit;
    }
}

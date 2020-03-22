package greedy;

/**
 * @ClassName greedy.Solution121
 * @Description 121.买票股票的最佳时机
 * @Author shishi
 * @Date 2019/6/26 20:06
 **/

/**
 * 题目要求：
 * 给定一个数组，它的第 i 个元素是一支给定股票第 i 天的价格。
 * 如果你最多只允许完成一笔交易（即买入和卖出一支股票），设计一个算法来计算你所能获取的最大利润。
 * <p>
 * 示例：
 * 输入: [7,1,5,3,6,4]
 * 输出: 5
 * <p>
 * 输入: [7,6,4,3,1]
 * 输出: 0
 */
public class Solution121 {
    // 类似于121道，但是只找一个最低的低谷
    // 然后利用不断的比较profit，看profit有没有变大
    public int maxProfit(int[] prices) {
        if (prices.length == 0) {
            return 0;
        }

        int profit = 0;
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < prices.length; i++) {
            if (prices[i] < min) {
                min = prices[i];
            } else if (prices[i] - min > profit) {
                profit = prices[i] - min;
            }
        }
        return profit;
    }
}

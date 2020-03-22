package greedy;

/**
 * @ClassName Solution122
 * @Description 122.买票股票的最佳时机2
 * @Author shishi
 * @Date 2019/6/26 15:48
 **/

/**
 * 题目要求：
 * 给定一个数组，它的第 i 个元素是一支给定股票第 i 天的价格。
 * 设计一个算法来计算你所能获取的最大利润。你可以尽可能地完成更多的交易（多次买卖一支股票）。
 * <p>
 * 示例：
 * 输入: [7,1,5,3,6,4]
 * 输出: 7
 * <p>
 * 输入: [1,2,3,4,5]
 * 输出: 4
 */
public class Solution122 {

    /**
     * 这里的思想就是定义一个峰值、一个谷值
     * 遍历数组，当后面的数字一直比前面的小，就i++，停止的位置就是谷值对应的数字
     * 同样，当后面的数字一直比前面的大，就一直i++，停止的位置就是峰值对应的数字
     * 然后(峰值-谷值)就是一次的利润
     * 所以这道题的方案就是不断的找相邻的峰值和谷值
     * 我一开始的想法是用动态规划，dp[i]=max{dp[i-1],dp[i-2]-(dp[length-2]-dp[length-1])},但感觉好像不大行
     */
    public int maxProfit(int[] prices) {
        if (prices.length == 0) {
            return 0;
        }

        int profit = 0;
        int valley = prices[0];
        int peak = prices[0];

        int i = 0;
        while (i < prices.length - 1) {
            while (i < prices.length - 1 && prices[i] >= prices[i + 1]) {
                i++;
            }
            valley = prices[i];

            while (i < prices.length - 1 && prices[i] <= prices[i + 1]) {
                i++;
            }
            peak = prices[i];

            profit += peak - valley;
        }

        return profit;
    }
}

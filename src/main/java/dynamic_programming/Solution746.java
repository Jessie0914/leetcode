package dynamic_programming;

/**
 * @ClassName Solution746
 * @Description 746.使用最小花费爬楼梯
 * @Author shishi
 * @Date 2019/7/3 14:34
 **/

/**
 * 题目要求：
 * 数组的每个索引做为一个阶梯，第 i个阶梯对应着一个非负数的体力花费值 cost[i](索引从0开始)。
 * 每当你爬上一个阶梯你都要花费对应的体力花费值，然后你可以选择继续爬一个阶梯或者爬两个阶梯。
 * 您需要找到达到楼层顶部的最低花费。在开始时，你可以选择从索引为 0 或 1 的元素作为初始阶梯。
 *
 * 示例：
 * 输入: cost = [10, 15, 20]
 * 输出: 15
 *
 * 输入: cost = [1, 100, 1, 1, 1, 100, 1, 1, 100, 1]
 * 输出: 6
 */
public class Solution746 {
    // 动态规划的公式为d[i] = min{d[i-1],d[i-2]}+cost[i]
    public int minCostClimbingStairs(int[] cost) {
        if (cost.length == 0) return 0;
        if (cost.length == 1) return cost[0];

        int[] d = new int[cost.length];
        d[0] = cost[0];
        d[1] = cost[1];
        for (int i=2; i<cost.length;i++){
            d[i] = Math.min(d[i-1],d[i-2]) + cost[i];
        }
        return Math.min(d[cost.length-1],d[cost.length-2]);
    }
}

package dynamic_programming;

/**
 * @ClassName Solution198
 * @Description 198.打家劫舍
 * @Author shishi
 * @Date 2019/7/3 13:20
 **/

/**
 * 题目要求：
 * 你是一个专业的小偷，计划偷窃沿街的房屋。每间房内都藏有一定的现金，
 * 影响你偷窃的唯一制约因素就是相邻的房屋装有相互连通的防盗系统，如果两间相邻的房屋在同一晚上被小偷闯入，系统会自动报警。
 * 给定一个代表每个房屋存放金额的非负整数数组，计算你在不触动警报装置的情况下，能够偷窃到的最高金额。
 * <p>
 * 示例：
 * 输入: [1,2,3,1]
 * 输出: 4
 * <p>
 * 输入: [2,7,9,3,1]
 * 输出: 12
 */
public class Solution198 {
    // 一开始看示例，我还直接计算奇数和偶数项的和做比较，太傻了。。。
    // 其实还是需要用动态规划
    // d[i] = max { (d[i-2]+nums[i]) , d[i-1] }
    public int rob(int[] nums) {
        int length = nums.length;
        if (length == 0) return 0;
        // dp数组的长度要+1
        int[] dp = new int[length + 1];
        // 定义dp数组的前两个数值，方便后面的迭代
        dp[0] = 0;
        dp[1] = nums[0];
        // 遍历dp数组的长度，为dp数组添加新的值
        for (int i = 2; i <= length; i++) {
            // 动态规划的公式
            dp[i] = Math.max(dp[i - 2] + nums[i - 1], dp[i - 1]);
        }
        // 最终的dp最后一个值即为结果
        return dp[length];
    }
}

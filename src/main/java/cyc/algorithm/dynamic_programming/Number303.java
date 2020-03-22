package cyc.algorithm.dynamic_programming;

/**
 * @program: leetcode
 * @description: 303. 区域和检索 - 数组不可变
 * @author: shishi
 * @create: 2019-12-04 11:12
 **/

/**
 * 给定 nums = [-2, 0, 3, -5, 2, -1]，求和函数为 sumRange()
 *
 * sumRange(0, 2) -> 1
 * sumRange(2, 5) -> -1
 * sumRange(0, 5) -> -3
 */
public class Number303 {
    private int[] dp;
    private int[] number;

    public Number303(int[] nums) {
        dp = new int[nums.length];
        number = nums;
        for (int i = 0; i < nums.length; i++) {
            if (i == 0) dp[i] = nums[0];
            else dp[i] = dp[i - 1] + nums[i];
        }
    }

    public int sumRange(int i, int j) {
        return dp[j] - dp[i] + number[i];
    }
}

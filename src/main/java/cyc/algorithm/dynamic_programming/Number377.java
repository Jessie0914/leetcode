package cyc.algorithm.dynamic_programming;

/**
 * @program: leetcode
 * @description: 377. 组合总和 Ⅳ
 * @author: shishi
 * @create: 2019-12-20 19:30
 **/

public class Number377 {
    public int combinationSum4(int[] nums, int target) {
        int[] dp = new int[target + 1];
        dp[0] = 1;

        for (int i = 1; i < target + 1; i++) {
            for (int j = 0; j < nums.length; j++) {
                if (i >= nums[j]) {
                    dp[i] += dp[i-nums[j]];
                }
            }
        }

        return dp[target];
    }
}

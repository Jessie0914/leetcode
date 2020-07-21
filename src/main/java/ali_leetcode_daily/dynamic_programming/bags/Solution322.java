package ali_leetcode_daily.dynamic_programming.bags;

/**
 * @ClassName Solution322
 * @Description 322. 零钱兑换
 * @Author shishi
 * @Date 2020/6/30 20:41
 **/

import java.util.Arrays;

/**
 * 输入: coins = [1, 2, 5], amount = 11
 * 输出: 3
 * 解释: 11 = 5 + 5 + 1
 */
public class Solution322 {
    public int coinChange(int[] coins, int amount) {
        if (amount < 0 || coins == null || coins.length == 0)
            return 0;

        int[] dp = new int[amount + 1];
        Arrays.fill(dp, amount + 1);

        // base case
        dp[0] = 0;

        for (int i = 1; i < amount + 1; i++) {
            for (int coin : coins) {
                if (i - coin < 0)
                    continue;
                dp[i] = Math.min(dp[i], dp[i - coin] + 1);
            }
        }
        return dp[amount] == amount + 1 ? -1 : dp[amount];
    }
}

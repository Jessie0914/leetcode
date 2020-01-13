package cyc.algorithm.dynamic_programming;

/**
 * @program: leetcode
 * @description: 322. 零钱兑换
 * @author: shishi
 * @create: 2019-12-17 16:16
 **/

import java.util.Arrays;

/**
 * 完全背包问题
 * 输入: coins = [1, 2, 5], amount = 11
 * 输出: 3
 * 解释: 11 = 5 + 5 + 1
 * <p>
 * 输入: coins = [2], amount = 3
 * 输出: -1
 */
public class Number322 {
    // https://blog.csdn.net/qq_39445165/article/details/84334970
    public int coinChange(int[] coins, int amount) {
        if (amount == 0) return 0;

        int length = coins.length;
        int[][] dp = new int[length][amount + 1];
        for (int i = 0; i < length; i++) {
            for (int j = 0; j < amount + 1; j++) {
                dp[i][j] = -1;
            }
        }

        // 初始化第一行，即coins[0]正好被j整除
        for (int j = 0; j < amount + 1; j++) {
            if (j % coins[0] == 0) {
                int k = j / coins[0];
                dp[0][j] = k;
            }
        }

        // 初始化第一列，都为0(默认也是0，所以也可以不做)
        for (int i = 0; i < length; i++) {
            dp[i][0] = 0;
        }

        // 二重循环
        for (int i = 1; i < length; i++) {
            for (int j = 1; j < amount + 1; j++) {
                // 完全背包和0-1背包的区别在此体现
                // 完全背包因为每一种物品都是不限量的，所以可以一直取，不像0-1背包最多取一次
                // 所以完全背包问题中的物品都可以取0,1,2,3,4……k次，直到超过amount
                for (int k = 0; k * coins[i] <= j; k++) {
                    if (dp[i - 1][j - k * coins[i]] != -1 && dp[i - 1][j] != -1) {
                        if (dp[i][j] != -1) {
                            dp[i][j] = Math.min(dp[i][j], dp[i - 1][j - k * coins[i]] + k);
                            dp[i][j] = Math.min(dp[i][j], dp[i - 1][j]);
                        } else {
                            dp[i][j] = Math.min(dp[i - 1][j - k * coins[i]] + k, dp[i - 1][j]);
                        }
                    } else if (dp[i - 1][j - k * coins[i]] != -1)
                        dp[i][j] = dp[i - 1][j - k * coins[i]] + k;
                    else
                        dp[i][j] = dp[i - 1][j];
                }
            }
        }

        return dp[length - 1][amount] == 0 ? -1 : dp[length - 1][amount];

    }

    // 用一维数组实现
    public int coinChange2(int[] coins, int amount) {
        if (amount == 0)
            return 0;

        // dp[i]代表总数为i的时候，最少的硬币数量
        int[] dp = new int[amount + 1];
        Arrays.fill(dp,amount+1);
        dp[0] = 0;

        // 对于外循环，枚举每一个amount
        for (int i=1;i<amount+1;i++){
            // 对于内循环，枚举每一个物品，因为每一个物品都有选多次和不选的权利。
            // 是从前往后枚举的，因为需要保证求dp[j]的时候，dp[j-1]是最优选择，而dp[j-1]有权利选择第i个物品
            for (int coin:coins){
                if (i>=coin){
                    dp[i] = Math.min(dp[i],dp[i-coin]+1);
                }
            }
        }

        return dp[amount] == amount+1 ? -1 : dp[amount];
    }
}

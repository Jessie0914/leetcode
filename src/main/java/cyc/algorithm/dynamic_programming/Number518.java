package cyc.algorithm.dynamic_programming;

/**
 * @program: leetcode
 * @description: 518. 零钱兑换 II
 * @author: shishi
 * @create: 2019-12-20 16:58
 **/

/**
 * 输入: amount = 5, coins = [1, 2, 5]
 * 输出: 4
 * 解释: 有四种方式可以凑成总金额:
 * 5=5
 * 5=2+2+1
 * 5=2+1+1+1
 * 5=1+1+1+1+1
 */
public class Number518 {
    public int change(int amount, int[] coins) {
        int[] dp = new int[amount + 1];
        dp[0] = 1;

        // {1+2=3}和{2+1=3}是重复的
        // 如果说外循环枚举的是硬币数组，那么就会防止重复
        // 因为枚举的是硬币的话，枚举到当前为1,就会产生1+dp[2];
        // 此时的dp[2]因为还没有枚举到后面，只会和1前面的硬币有关,即dp[2]只有{1+1},而没有{2+0};最终结果就是{1+1+1}，不会存在{1+2+0}
        // 不会和后面枚举到2时产生的2+dp[1]产生冲突，会存在{2+1+0}
        for (int i = 0; i < coins.length; i++) {
            for (int j = 0; j < amount + 1; j++)
                if (j >= coins[i]) {
                    dp[j] += dp[j - coins[i]];
                }
        }
        return dp[amount];
    }
}

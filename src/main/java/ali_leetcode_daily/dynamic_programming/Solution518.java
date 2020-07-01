package ali_leetcode_daily.dynamic_programming;

/**
 * @ClassName Solution518
 * @Description 518. 零钱兑换 II
 * @Author shishi
 * @Date 2020/6/30 20:52
 **/

import java.util.Arrays;

/**
 * 给定不同面额的硬币和一个总金额。写出函数来计算可以凑成总金额的硬币组合数。
 * 输入: amount = 5, coins = [1, 2, 5]
 * 输出: 4
 * 解释: 有四种方式可以凑成总金额:
 * 5=5
 * 5=2+2+1
 * 5=2+1+1+1
 * 5=1+1+1+1+1
 */
public class Solution518 {
    public int change(int amount, int[] coins) {
        if (amount < 0)
            return 0;

        Arrays.sort(coins);

    }
}

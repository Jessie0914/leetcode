package cyc.algorithm.dynamic_programming;

/**
 * @program: leetcode
 * @description: 279. 完全平方数
 * @author: shishi
 * @create: 2019-12-04 15:11
 **/

import java.util.Arrays;

/**
 * 输入: n = 12
 * 输出: 3
 * 解释: 12 = 4 + 4 + 4.
 *
 * 输入: n = 13
 * 输出: 2
 * 解释: 13 = 4 + 9.
 */
public class Number279 {
    public int numSquares(int n) {
        int[] dp = new int[n + 1];
        Arrays.fill(dp,Integer.MAX_VALUE);
        dp[0] = 0;
        dp[1] = 1;
        for (int i=2;i<=n;i++){
            for (int j=1;j*j<=i;j++){
                dp[i] = Math.min(dp[i],1+dp[i-j*j]);
            }
        }
        return dp[n];
    }
}

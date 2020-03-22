package cyc.algorithm.dynamic_programming;

/**
 * @program: leetcode
 * @description: 343. 整数拆分
 * @author: shishi
 * @create: 2019-12-04 13:53
 **/

/**
 * 输入: 10
 * 输出: 36
 * 解释: 10 = 3 + 3 + 4, 3 × 3 × 4 = 36。
 */
public class Number343 {
    // 暴力方法
    public int integerBreak(int n) {
        if (n == 1) return 1;
        int max = Integer.MIN_VALUE;

        for (int i = 1; i < n; i++) {
            max = Math.max(max, Math.max(i * integerBreak(n - i), i * (n - i)));
        }
        return max;
    }

    // 动规
    public int integerBreak1(int n) {
        int[] dp = new int[n + 1];
        dp[0] = dp[1] = dp[2] = 1;
        for (int i=3;i<=n;i++){
            for (int j=1;j<i;j++)
                dp[i] = Math.max(dp[i],Math.max(j*dp[i-j],j*(i-j)));
        }
        return dp[n];
    }

}

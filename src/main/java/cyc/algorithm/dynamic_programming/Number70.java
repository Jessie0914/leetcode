package cyc.algorithm.dynamic_programming;

/**
 * @program: leetcode
 * @description: 70. 爬楼梯
 * @author: shishi
 * @create: 2019-11-27 15:10
 **/

public class Number70 {
    // 递归，超时
    public int climbStairs(int n) {
        if (n == 1) return 1;
        else if (n == 2) return 2;
        return climbStairs(n - 1) + climbStairs(n - 2);
    }

    // 实际上是斐波那契数列
    // 用两个int变量pre cur以及一个sum，交替赋值就可以解决
    public int climbStairs2(int n) {
        if (n == 1) return 1;
        else if (n == 2) return 2;
        int pre = 1;
        int cur = 2;
        int sum = 0;
        for (int i = 3; i <= n; i++) {
            sum = pre + cur;
            pre = cur;
            cur = sum;
        }
        return sum;
    }

    // 动态规划
    // dp[i]表示到第i个阶梯有多少中方法
    public int climbStairs3(int n) {
        int[] dp = new int[n + 1];
        dp[0] = 1;
        dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n];
    }
}

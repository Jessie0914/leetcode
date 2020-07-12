package jianzhi;

/**
 * @ClassName JZ7
 * @Description 斐波那契数列
 * @Author shishi
 * @Date 2020/7/12 18:59
 **/
public class JZ7 {
    // f(0) = 0, f(1) = 1
    public int Fibonacci(int n) {
        if (n == 0)
            return 0;
        else if (n == 1)
            return 1;

        int[] dp = new int[n + 1];
        dp[0] = 0;
        dp[1] = 1;

        for (int i = 2; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }

        return dp[n];
    }
}

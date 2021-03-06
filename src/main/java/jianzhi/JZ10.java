package jianzhi;

/**
 * @ClassName JZ10
 * @Description
 * @Author shishi
 * @Date 2020/7/12 19:23
 **/
public class JZ10 {
    public int RectCover(int target) {
        if (target == 0)
            return 0;
        else if (target == 1)
            return 1;
        else if (target == 2)
            return 2;

        int[] dp = new int[target + 1];
        dp[0] = 0;
        dp[1] = 1;
        dp[2] = 2;

        for (int i = 3; i <= target; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }

        return dp[target];
    }
}

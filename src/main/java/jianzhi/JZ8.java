package jianzhi;

/**
 * @ClassName JZ8
 * @Description 一只青蛙一次可以跳上1级台阶，也可以跳上2级。
 * @Author shishi
 * @Date 2020/7/12 19:10
 **/
public class JZ8 {
    public int JumpFloor(int target) {
        if (target == 0)
            return 1;
        else if (target == 1)
            return 1;
        else if (target == 2)
            return 2;

        int[] dp = new int[target + 1];
        dp[0] = 1;
        dp[1] = 1;
        dp[2] = 2;

        for (int i = 3; i < target + 1; i++)
            dp[i] = dp[i - 1] + dp[i - 2];

        return dp[target];
    }
}

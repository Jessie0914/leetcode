package jianzhi;

/**
 * @ClassName JZ9
 * @Description 一只青蛙一次可以跳上1级台阶，也可以跳上2级……它也可以跳上n级
 * @Author shishi
 * @Date 2020/7/12 19:14
 **/
public class JZ9 {
    public int JumpFloorII(int target) {
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

        for (int i = 3; i <= target; i++) {
            for (int j = 0; j < i; j++) {
                dp[i] += dp[j];
            }
        }

        return dp[target];
    }
}

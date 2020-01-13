package cyc.algorithm.dynamic_programming;

import java.util.Arrays;

/**
 * @program: leetcode
 * @description: 494. 目标和
 * @author: shishi
 * @create: 2019-12-17 11:20
 **/

public class Number494 {
    // 和416很像，改编一下即可，但是坑也会有很多
    public int findTargetSumWays(int[] nums, int S) {
        // nums存在0的时候，情况就会有变化，0既可以+，也可以-，所以需要单独计数
        Arrays.sort(nums);
        int count_zero = 0;
        int index = 0;
        while (index < nums.length && nums[index++] == 0) {
            count_zero++;
        }

        // 不加下面那一段[0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0] S=0的用例通不过
        if (count_zero == nums.length)
            return (int) Math.pow(2, count_zero);

        // 把数组nums变成没有0的数组
        nums = Arrays.copyOfRange(nums, count_zero, nums.length);
        int length = nums.length;
        int sum = 0;
        for (int i = 0; i < length; i++) {
            sum += nums[i];
        }

        // 特判情况讨论
        if (S > sum || S < -sum) {
            return 0;
        }

        // 即去找一个和为minus_target的序列
        // 这些数前面都是加的负号，就可以找到一个方案
        // 现在问题就转变为"存在多少种方案，使得一些数字的和为minus_target"，可以借鉴416题
        int minus_target = 0;
        if ((sum - S) % 2 == 0)
            minus_target = (sum - S) / 2;
        else
            return 0;

        // dp[i][j]代表是前i个元素中和为j的方案数量
        int[][] dp = new int[length][minus_target + 1];

        // 初始化，填充第一行
        for (int j = 0; j < minus_target + 1; j++) {
            if (nums[0] == j) {
                dp[0][j] = 1;
            }
        }

        // 第一列应该全为1
        // 因为dp[i][0]代表前i个元素之和为0的个数，都为1，即一个元素也不选
        // 为什么416题目中没有初始化第一列，是因为416题目中是'||'，所以只要有一种情况满足，就会置为true，而这里每一种情况都需要加上
        for (int i = 0; i < length; i++) {
            dp[i][0] = 1;
        }

        for (int i = 1; i < length; i++) {
            for (int j = 0; j < minus_target + 1; j++) {
                if (j >= nums[i]) {
                    dp[i][j] = dp[i - 1][j - nums[i]] + dp[i - 1][j];
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }

        return dp[length - 1][minus_target] * (int) Math.pow(2, count_zero);
    }

    // 尝试着用一维数组去做
    public int findTargetSumWays2(int[] nums, int S) {
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
        }

        // 特判
        if (S > sum || S < -sum)
            return 0;


        if ((sum - S) % 2 != 0) {
            return 0;
        }

        // 取负号的数字之和
        int minus_target = (sum - S) / 2;

        // 接下来就是求和为minus_target的子序列的个数
        int[] dp = new int[minus_target + 1];

        // 首先先初始化
        dp[0] = 1;

        for (int i = 0; i < nums.length; i++) {
            for (int j = minus_target; j >= 0; j--) {
                if (j >= nums[i]) {
                    dp[j] += dp[j - nums[i]];
                }
            }
        }

        return dp[minus_target];
    }
}

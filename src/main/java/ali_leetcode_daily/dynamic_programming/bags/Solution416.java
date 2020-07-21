package ali_leetcode_daily.dynamic_programming.bags;

/**
 * 416. 分割等和子集
 */
public class Solution416 {
    // 二维
    public boolean canPartition(int[] nums) {
        if (nums == null || nums.length == 0) {
            return false;
        }

        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        if (sum % 2 != 0)
            return false;
        sum /= 2;

        int len = nums.length;
        boolean[][] dp = new boolean[len + 1][sum + 1];

        // base case
        dp[0][0] = true;
        for (int i = 1; i < len + 1; i++) {
            dp[i][0] = true; // 代表前i个元素，都不选，就能凑出0
        }
        for (int j = 1; j < sum + 1; j++) {
            dp[0][j] = false;
        }

        // dp
        for (int i = 1; i < len + 1; i++) {
            for (int j = 1; j < sum + 1; j++) {
                // 如果装的下第i-1个元素
                // 可以选择装或者不装
                if (j - nums[i - 1] >= 0)
                    dp[i][j] = dp[i - 1][j] || dp[i - 1][j - nums[i - 1]];
                    // 如果装不下，那么只能选择不装
                else
                    dp[i][j] = dp[i - 1][j];
            }
        }

        return dp[len][sum];
    }

    // 可以压缩到一维的
    public boolean canPartition2(int[] nums) {
        if (nums == null || nums.length == 0) {
            return false;
        }

        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        if (sum % 2 != 0)
            return false;
        sum /= 2;

        boolean[] dp = new boolean[sum + 1];
        dp[0] = true;
        for (int i = 0; i < nums.length; i++) {
            // 内层循环，j逆序！！！
            // 这里的dp[i]只和dp[i-1]的状态有关
            // 否则，如果正序的话，前面的数据先改变，而后面的数据会用到前面的（这就可能遇上已经改变过的前面的数据），不正确了
            for (int j = sum; j > 0; j--) {
                if (j>=nums[i])
                    dp[j] = dp[j] || dp[j-nums[i]];
                else
                    dp[j] = dp[j];
            }
        }
        return dp[sum];
    }
}

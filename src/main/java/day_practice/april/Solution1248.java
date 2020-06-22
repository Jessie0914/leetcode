package day_practice.april;

/**
 * @ClassName Solution1248
 * @Description 1248. 统计「优美子数组」
 * @Author shishi
 * @Date 2020/4/21 16:44
 **/

/**
 * 给你一个整数数组 nums 和一个整数 k。
 * 如果某个 连续 子数组中恰好有 k 个奇数数字，我们就认为这个子数组是「优美子数组」。
 * 请返回这个数组中「优美子数组」的数目
 * <p>
 * 输入：nums = [1,1,2,1,1], k = 3
 * 输出：2
 * 解释：包含 3 个奇数的子数组是 [1,1,2,1] 和 [1,2,1,1] 。
 */
public class Solution1248 {
    public int numberOfSubarrays(int[] nums, int k) {
        if (nums == null || nums.length == 0)
            return 0;

        int len = nums.length;
        int[] dp = new int[len];

        for (int i = 0; i < len; i++) {
            if (i == 0) {
                dp[0] = (nums[0] % 2 == 1) ? 1 : 0;
            } else {
                if (nums[i] % 2 == 1)
                    dp[i] = dp[i - 1] + 1;
                else
                    dp[i] = dp[i - 1];
            }
        }

        int ans = 0;
        // 去遍历数组
        for (int i = 0; i < len; i++) {
            if (dp[i] == k)
                ans++;
            for (int j = 0; j < i; j++) {
                if (dp[i] - dp[j] == k)
                    ans++;
            }
        }
        return ans;
    }
}

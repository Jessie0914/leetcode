package cyc.algorithm.dynamic_programming;

/**
 * @program: leetcode
 * @description: 213. 打家劫舍 II
 * @author: shishi
 * @create: 2019-11-27 16:24
 **/

/**
 * 屋子是环形的
 * 输入: [2,3,2]
 * 输出: 3
 * 解释: 你不能先偷窃 1 号房屋（金额 = 2），然后偷窃 3 号房屋（金额 = 2）, 因为他们是相邻的。
 */
public class Number213 {
    public int rob(int[] nums) {
        int len = nums.length;
        if (len==0) return 0;
        if (len==1) return nums[0];
        if (len==2) return Math.max(nums[0],nums[1]);

        return Math.max(rob(nums,0,len-2),rob(nums,1,len-1));
    }

    private int rob(int[] nums, int start, int end) {
        int[] dp = new int[end+1];
        dp[start] = nums[start];
        dp[start+1] = Math.max(nums[start],nums[start+1]);
        for (int i=start+2;i<=end;i++){
            dp[i] = Math.max(dp[i-2]+nums[i],dp[i-1]);
        }
        return dp[end];
    }
}

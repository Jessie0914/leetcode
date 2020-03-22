package cyc.algorithm.dynamic_programming;

/**
 * @program: leetcode
 * @description: 376. 摆动序列
 * @author: shishi
 * @create: 2019-12-06 13:30
 **/

import java.util.Arrays;

/**
 * 如果连续数字之间的差严格地在正数和负数之间交替，则数字序列称为摆动序列。
 * 输入: [1,7,4,9,2,5]
 * 输出: 6
 * 解释: 整个序列均为摆动序列。
 * <p>
 * 输入: [1,17,5,10,13,15,10,5,16,8]
 * 输出: 7
 * 解释: 这个序列包含几个长度为 7 摆动序列，其中一个可为[1,17,10,13,10,16,8]。
 */
public class Number376 {
    public int wiggleMaxLength(int[] nums) {
        int len = nums.length;
        if (len < 2) return len;
        int[] dp = new int[len];
        boolean[] flag = new boolean[len];
        Arrays.fill(dp, 1);
        Arrays.fill(flag, false);

        int max = 1;
        for (int i = 1; i < len; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[i]>nums[j]){
                    // 判断是不是第一个
                    if (j==0){
                        flag[i] = true;
                        dp[i] = Math.max(dp[i],dp[j]+1);
                    }else {
                        if (!flag[j]){
                            flag[i] = true;
                            dp[i] = Math.max(dp[i],dp[j]+1);
                        }
                    }
                }else if (nums[i]<nums[j]){
                    if (j==0){
                        flag[i] = false;
                        dp[i] = Math.max(dp[i],dp[j]+1);
                    }else if (flag[j]){
                        flag[i] = false;
                        dp[i] = Math.max(dp[i],dp[j]+1);
                    }
                }
            }
            max = Math.max(max,dp[i]);
        }

        return max;

    }
}

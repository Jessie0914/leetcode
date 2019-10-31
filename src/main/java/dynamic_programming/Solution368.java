package dynamic_programming;

import java.util.Arrays;
import java.util.List;

/**
 * @ClassName Solution368
 * @Description TODO
 * @Author shishi
 * @Date 2019/10/31 14:23
 **/

/**
 * 两个数组，一个dp[i]代表以nums下标为i结束的最大集合的长度
 * last[i]代表以dp[i]对应的下标为i的最大集合的前一位下标j
 */
public class Solution368 {
    public List<Integer> largestDivisibleSubset(int[] nums) {
        int len = nums.length;
        int[] dp = new int[len];
        Arrays.fill(dp,1);
        int[] last = new int[len];
        Arrays.fill(last,-1);

        for (int i=0;i<len;i++){
            for (int j=0;j<i;j++){

            }
        }
    }
}

package dynamic_programming;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @ClassName Solution357
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
        List<Integer> list = new ArrayList<>();
        if (nums.length==0)
            return list;

        Arrays.sort(nums);
        int len = nums.length;
        int maxLen = 1;
        int maxSet_EndIndex = 0;
        int[] dp = new int[len];
        Arrays.fill(dp,1);
        int[] last = new int[len];
        Arrays.fill(last,-1);

        for (int i=0;i<len;i++){
            for (int j=0;j<i;j++){
                if (nums[i]%nums[j]==0 && dp[i]<=dp[j]){
                    // 更新dp和last
                    dp[i] = dp[j]+1;
                    last[i] = j;
                }
                if (dp[i]>maxLen){
                    maxLen = dp[i];
                    maxSet_EndIndex = i;
                }
            }
        }

        // 最后输出即可
        for (int i=maxSet_EndIndex;i!=-1;i=last[i]){
            list.add(nums[i]);
        }
        return list;
    }
}

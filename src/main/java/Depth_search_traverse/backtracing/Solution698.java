package Depth_search_traverse.backtracing;

/**
 * @ClassName Solution698
 * @Description 698. 划分为k个相等的子集
 * @Author shishi
 * @Date 2019/11/5 12:25
 **/

import java.util.Arrays;

/**
 * 给定一个整数数组  nums 和一个正整数 k，找出是否有可能把这个数组分成 k 个非空子集，其总和都相等。
 * <p>
 * 输入： nums = [4, 3, 2, 3, 5, 2, 1], k = 4
 * 输出： True
 * 说明： 有可能将其分成 4 个子集（5），（1,4），（2,3），（2,3）等于总和。
 */
public class Solution698 {
    public boolean canPartitionKSubsets(int[] nums, int k) {
        int len = nums.length;

        // 数组里面的最大值
        int maxNum = Integer.MIN_VALUE;
        // 数组的总和
        int sum = 0;
        for (int i = 0; i < len; i++) {
            sum += nums[i];
            if (nums[i] > maxNum)
                maxNum = nums[i];
        }

        // 每一个子集的总和
        int subArraySum = sum / k;
        // 如果sum%k!=0说明不能整除，就不可能正好划分k个子集
        // 如果maxSum>subArraySum包含最大值的那个子集的和就不可能等于subArraySum，那么也不可能成功划分
        if (sum % k != 0 || maxNum > subArraySum)
            return false;
        else {
            boolean[] used = new boolean[len];
            Arrays.fill(used, false);

            return help(nums, used, k, subArraySum, 0, 0);
        }
    }

    // 回溯算法
    private boolean help(int[] nums, boolean[] used, int k, int subArraySum, int curSum, int startIndex) {
        // 当k减少到0，就说明可行，返回true
        if (k == 0)
            return true;

        if (curSum == subArraySum) {
            return help(nums, used, k - 1, subArraySum, 0, 0);
        } else {
            // 从给定的下标开始遍历
            for (int i = startIndex; i < nums.length; i++) {
                // 当前下标没有被使用过，并且curSum+当前值还没达到子集和的时候，就可以继续递归
                if (!used[i] && nums[i] + curSum <= subArraySum) {
                    used[i] = true;
                    // 如果返回值为true，就直接return即可
                    if (help(nums, used, k, subArraySum, curSum + nums[i], i + 1))
                        return true;
                    // 回退一步
                    else
                        used[i] = false;
                }
            }
        }
        return false;
    }
}

package dynamic_programming;

/**
 * @ClassName Solution53
 * @Description 53.最大子序和
 * @Author shishi
 * @Date 2019/7/3 11:51
 **/

/**
 * 题目要求：
 * 给定一个整数数组 nums ，找到一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和
 * <p>
 * 示例：
 * 输入: [-2,1,-3,4,-1,2,1,-5,4],
 * 输出: 6
 */
public class Solution53 {
    // 动态规划的初级题目
    public int maxSubArray(int[] nums) {
        if (nums.length == 0) return 0;

        // 维护两个变量
        // maxLocal是指当前位置的最大值，要么加上前面的序列（如果前面的和＞0），否则，就自己独立成局部最大值
        int maxLocal = nums[0];
        // maxGlobal是指全局最大值，要么就是不变，仍然是自己，要么就是局部最大值maxLocal
        int maxGlobal = nums[0];

        // 遍历数组，不断更新maxLocal和maxGlobal
        for (int i = 1; i < nums.length; i++) {
            maxLocal = Math.max(nums[i], nums[i] + maxLocal);
            maxGlobal = Math.max(maxLocal, maxGlobal);
        }
        return maxGlobal;
    }
}

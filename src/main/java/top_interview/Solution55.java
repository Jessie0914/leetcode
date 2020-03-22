package top_interview;

/**
 * @ClassName Solution55
 * @Description 跳跃游戏
 * @Author shishi
 * @Date 2020/3/7 21:21
 **/

/**
 * 给定一个非负整数数组，你最初位于数组的第一个位置。
 * 数组中的每个元素代表你在该位置可以跳跃的最大长度。
 * 判断你是否能够到达最后一个位置。
 * 输入: [2,3,1,1,4]
 * 输出: true
 * 解释: 我们可以先跳 1 步，从位置 0 到达 位置 1, 然后再从位置 1 跳 3 步到达最后一个位置。
 */
public class Solution55 {
    public boolean canJump(int[] nums) {
        int len = nums.length;
        int maxLen = 1;
        // 当i>=maxLen的时候，就说明出现了断点，无法继续了
        for (int i = 0; i < len && i < maxLen; i++) {
            maxLen = Math.max(maxLen, nums[i] + i + 1);
        }

        // 最终，如果maxLen大于数组长度，就说明有可行方案，否则，就是false
        if (maxLen >= len)
            return true;
        else
            return false;
    }
}

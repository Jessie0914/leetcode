package day_practice.april;

/**
 * @ClassName Solution55
 * @Description 55. 跳跃游戏
 * @Author shishi
 * @Date 2020/4/17 14:25
 **/

/**
 * 输入: [2,3,1,1,4]
 * 输出: true
 * 解释: 我们可以先跳 1 步，从位置 0 到达 位置 1, 然后再从位置 1 跳 3 步到达最后一个位置。
 * <p>
 * 输入: [3,2,1,0,4]
 * 输出: false
 * 解释: 无论怎样，你总会到达索引为 3 的位置。但该位置的最大跳跃长度是 0 ， 所以你永远不可能到达最后一个位置。
 */
public class Solution55 {
    public boolean canJump(int[] nums) {
        if (nums == null || nums.length == 0)
            return true;

        // [0]-->true
        if (nums.length == 1 && nums[0] >= 0)
            return true;

        int maxLen = 0;
        for (int i = 0; i < nums.length; i++) {
            int len = i + nums[i];
            maxLen = Math.max(len, maxLen);

            // 出现了断点
            if (i >= maxLen) {
                return false;
            }

            if (maxLen >= nums.length - 1) {
                return true;
            }
        }
        return true;
    }

    public boolean canJump2(int[] nums) {
        int maxLen = 0;
        for (int i = 0; i < nums.length; i++) {
            if (i > maxLen) return false;
            maxLen = Math.max(maxLen, i + nums[i]);
        }
        return true;
    }
}

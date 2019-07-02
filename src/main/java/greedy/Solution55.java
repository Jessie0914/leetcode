package greedy;

/**
 * @ClassName Solution55
 * @Description 55.跳跃游戏
 * @Author shishi
 * @Date 2019/7/1 19:38
 **/

import java.lang.management.ManagementFactory;

/**
 * 题目要求：
 * 给定一个非负整数数组，你最初位于数组的第一个位置。
 * 数组中的每个元素代表你在该位置可以跳跃的最大长度。
 * 判断你是否能够到达最后一个位置。
 *
 * 示例：
 * 输入: [2,3,1,1,4]
 * 输出: true
 * 解释: 从位置 0 到 1 跳 1 步, 然后跳 3 步到达最后一个位置。
 *
 * 输入: [3,2,1,0,4]
 * 输出: false
 * 解释: 无论怎样，你总会到达索引为 3 的位置。但该位置的最大跳跃长度是 0 ， 所以你永远不可能到达最后一个位置。
 */
public class Solution55 {
    // 贪心的算法，还是有点难理解的
    // maxReach代表的就是最远能够达到的位置，如果最远能够达到数组最边界甚至之外，就说明可达
    // maxReach的计算方法如下，它就是在每一个位置上计算它能跳到的最远的位置，如果还没有之前的maxReach远，那么maxReach还是和之前一样
    // 要注意的一个是：i<maxReach这个条件，当maxReach已经在i的左侧的时候，就说明它只能达到maxReach的地方了，这时候i再往前走也没有意义了，中间断掉了
    public boolean canJump(int[] nums) {
        int maxReach = 1;
        for (int i=0;i<maxReach&&maxReach<nums.length;i++){
            maxReach = Math.max(maxReach,nums[i]+i+1);
        }
        if (maxReach>=nums.length)
            return true;
        else
            return false;
    }
}

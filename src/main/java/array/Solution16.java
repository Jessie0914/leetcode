package array;

/**
 * @ClassName Solution16
 * @Description 16.最接近的三数之和
 * @Author shishi
 * @Date 2019/6/30 13:29
 **/

import java.util.Arrays;

/**
 * 题目要求：
 * 给定一个包括 n 个整数的数组 nums 和 一个目标值 target。
 * 找出 nums 中的三个整数，使得它们的和与 target 最接近。返回这三个数的和。假定每组输入只存在唯一答案。
 *
 * 示例：
 * 给定数组 nums = [-1，2，1，-4], 和 target = 1.
 * 与 target 最接近的三个数的和为 2. (-1 + 2 + 1 = 2).
 */

public class Solution16 {
    // 我是根据15题.三数之和等题目，有的思路，这些题目很相似，我这里直接三重遍历，复杂度O(n^2)
    // 应该像15题中一样，先排序，再根据值来j++和k--，可以降低复杂度，可以参考15题和16题的题解
    public int threeSumClosest(int[] nums, int target) {
        // 题目中的要求是一定会有一个唯一解，所以nums数组的长度一定不会小于3
        if (nums.length==3) return nums[0]+nums[1]+nums[2];

        final int goal = target;
        int minGap = Integer.MAX_VALUE;
        // 定义三个变量，存储最后的结果
        int first = 0;
        int second = 0;
        int third = 0;

        // i从第一个开始数字开始到倒数第三个数字
        for (int i=0;i<nums.length-2;++i){
            int j=i+1;
            // j从第二个数字开始到倒数第二个数字
            while (j<nums.length-1){
                // k从最后一个数字开始往前到j前一个数字位置
                int k=nums.length-1;

                // 只要没有相遇就继续
                while (j<k){
                    int sum = nums[i]+ nums[j]+ nums[k];
                    // 如果知道了等于target的三个数字，就直接返回吧，这一定是唯一解
                    if (sum == goal){
                        return goal;
                    }
                    // 否则，找到与目标相差更小的数，就更新
                    else if (Math.abs(sum-goal)<minGap){
                        first = nums[i];
                        second = nums[j];
                        third = nums[k];
                        minGap = Math.abs(sum-goal);
                        --k;
                    }
                    else {
                        --k;
                    }
                }
                ++j;
            }
        }
        return first+second+third;
    }
}

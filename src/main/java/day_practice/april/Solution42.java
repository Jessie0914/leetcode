package day_practice.april;

import java.util.Stack;

/**
 * @ClassName Solution42
 * @Description 42. 接雨水
 * @Author shishi
 * @Date 2020/4/18 16:07
 **/

// Difficult
// 参考地址：https://zhuanlan.zhihu.com/p/125074613
public class Solution42 {
    // 暴力方法
    // 遍历所有的柱子，求出每根柱子左侧和右侧的最大高度，取较小值减去当前的高度，即为当前柱子能盛的雨水
    public int trap(int[] height) {
        int ans = 0;
        for (int i = 0; i < height.length; i++) {
            int left_maxHeight = 0;
            int right_maxHeight = 0;

            // 找寻左侧的最大高度
            if (i != 0) {
                for (int j = 0; j < i; j++) {
                    left_maxHeight = Math.max(left_maxHeight, height[j]);
                }
            }

            // 找寻右侧的最大高度
            if (i != height.length - 1) {
                for (int j = i; j < height.length; j++) {
                    right_maxHeight = Math.max(right_maxHeight, height[j]);
                }
            }

            // 取两侧最大高度的小值
            int maxHeight = Math.min(left_maxHeight, right_maxHeight);
            ans += (maxHeight - height[i] > 0) ? (maxHeight - height[i]) : 0;
        }
        return ans;
    }


    // DP
    // 暴力法中，对于每个柱子，我们都需要从两头重新遍历一遍求出左右两侧的最大高度，这里是有很多重复计算的
    // 很明显最大高度是可以记忆化的，具体在这里可以用数组边递推边存储
    public int trap2(int[] height) {
        int ans = 0;

        if (height == null || height.length == 0)
            return ans;

        int len = height.length;
        // 用二维数组来记忆化存储两遍的最大高度，dp[i][0]为左边，dp[i][1]为右边
        int[][] dp = new int[height.length][2];
        dp[0][0] = height[0];
        dp[len - 1][1] = height[len - 1];

        // 初始化dp[i][0]
        for (int i = 1; i < len; i++) {
            dp[i][0] = Math.max(dp[i - 1][0], height[i]);
        }

        // 初始化dp[i][1]
        for (int i = len - 2; i >= 0; i--) {
            dp[i][1] = Math.max(dp[i + 1][1], height[i]);
        }

        // 然后遍历一遍即可
        for (int i = 0; i < len; i++) {
            ans += Math.min(dp[i][0], dp[i][1]) - height[i];
        }

        return ans;
    }

    // 单调栈
    // https://zhuanlan.zhihu.com/p/125074613
    public int trap3(int[] height) {
        Stack<Integer> stack = new Stack<>();
        int res = 0;
        // 遍历每个柱体
        for (int i = 0; i < height.length; i++) {
            while (!stack.isEmpty() && height[stack.peek()] < height[i]) {
                int bottomIdx = stack.pop();
                // 如果栈顶元素一直相等，那么全都pop出去，只留第一个。
                while (!stack.isEmpty() && height[stack.peek()] == height[bottomIdx]) {
                    stack.pop();
                }
                if (!stack.isEmpty()) {
                    // stack.peek()是此次接住的雨水的左边界的位置，右边界是当前的柱体，即i。
                    // Math.min(height[stack.peek()], height[i]) 是左右柱子高度的min，减去height[bottomIdx]就是雨水的高度。
                    // i - stack.peek() - 1 是雨水的宽度。
                    res += (Math.min(height[stack.peek()], height[i]) - height[bottomIdx]) * (i - stack.peek() - 1);
                }
            }
            stack.push(i);
        }
        return res;
    }
}

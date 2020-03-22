package cyc.algorithm.dynamic_programming;

import java.util.List;

/**
 * @ClassName Number120
 * @Description 三角形最小路径和
 * @Author shishi
 * @Date 2020/3/22 15:17
 **/

/**
 * 给定一个三角形，找出自顶向下的最小路径和。每一步只能移动到下一行中相邻的结点上。
 * 例如，给定三角形：
 * <p>
 * [
 * [2],
 * [3,4],
 * [6,5,7],
 * [4,1,8,3]
 * ]
 * 自顶向下的最小路径和为 11（即，2 + 3 + 5 + 1 = 11）。
 */
public class Number120 {
    public int minimumTotal(List<List<Integer>> triangle) {
        int[][] nums = transfer(triangle);

        int len = nums.length;
        int[][] dp = new int[len][len];
        dp[0][0] = nums[0][0];
        for (int i = 1; i < len; i++) {
            for (int j = 0; j <= i; j++) {
                if (j == i) {
                    dp[i][j] = dp[i - 1][j - 1] + nums[i][j];
                } else {
                    if (j - 1 >= 0)
                        dp[i][j] = Math.min(dp[i - 1][j], dp[i - 1][j - 1]) + nums[i][j];
                    else
                        dp[i][j] = dp[i - 1][j] + nums[i][j];
                }

            }
        }

        // 遍历最后一行
        int ans = Integer.MAX_VALUE;
        for (int j = 0; j < len; j++) {
            if (dp[len - 1][j] < ans)
                ans = dp[len - 1][j];
        }
        return ans;
    }

    private int[][] transfer(List<List<Integer>> triangle) {
        int len = triangle.size();
        int[][] nums = new int[len][len];
        for (int i = 0; i < len; i++) {
            List<Integer> list = triangle.get(i);
            for (int j = 0; j < list.size(); j++) {
                nums[i][j] = list.get(j);
            }
        }

        return nums;
    }
}

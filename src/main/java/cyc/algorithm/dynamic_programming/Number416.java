package cyc.algorithm.dynamic_programming;

/**
 * @program: leetcode
 * @description: 416. 分割等和子集
 * @author: shishi
 * @create: 2019-12-12 16:49
 **/

/**
 * https://leetcode-cn.com/problems/partition-equal-subset-sum/solution/0-1-bei-bao-wen-ti-xiang-jie-zhen-dui-ben-ti-de-yo/
 * 输入: [1, 5, 11, 5]
 * 输出: true
 * 解释: 数组可以分割成 [1, 5, 5] 和 [11].
 * <p>
 * 输入: [1, 2, 3, 5]
 * 输出: false
 * 解释: 数组不能分割成两个元素和相等的子集.
 */
public class Number416 {
    public boolean canPartition(int[] nums) {
        int size = nums.length;

        int sum = 0;
        for (int i = 0; i < size; i++) {
            sum += nums[i];
        }

        if (sum % 2 == 1)
            return false;

        int target = sum / 2;

        boolean[][] dp = new boolean[size][target + 1];

        // 先填充第一行
        for (int i = 0; i < target + 1; i++) {
            if (nums[0] == i)
                dp[0][i] = true;
        }

        for (int i = 1; i < size; i++) {
            for (int j=0;j<target+1;j++){
                // 如果j>=nums[i]，就有两种选择
                if (j>=nums[i])
                    dp[i][j] = dp[i-1][j] || dp[i-1][j-nums[i]];
                // 否则，就只能“不选”
                else
                    dp[i][j] = dp[i-1][j];
            }
        }

        // 一共有size个数，并且存不存在和为target的序列的结果
        return dp[size-1][target];

    }

    // 对空间进行了优化
    // 后一行的值总是参考了它上面一行 “头顶上” 那个位置和“左上角”某个位置的值。
    public boolean canPartition2(int[] nums){
        int size = nums.length;

        int sum = 0;
        for (int i = 0; i < size; i++) {
            sum += nums[i];
        }

        if (sum % 2 == 1)
            return false;

        int target = sum / 2;

        // 从第 2 行以后，当前行的结果参考了上一行的结果，因此使用一维数组定义状态就可以了
        boolean[] dp = new boolean[target + 1];

        // 第一个元素
        for (int j=0;j<target+1;j++){
            if (nums[0]==j) {
                dp[j] = true;
                break;
            }
        }

        // 因为后面的参考了前面的，我们从后向前填写
        for (int i=1;i<size;i++){
            // 后面的容量越来越小，因此没有必要再判断了，退出当前循环
            for (int j=target;j>=0&&j>=nums[i];j--){
                dp[j] = dp[j-nums[i]] || dp[j];
            }
        }

        return dp[target];

    }
}

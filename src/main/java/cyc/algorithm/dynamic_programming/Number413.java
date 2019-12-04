package cyc.algorithm.dynamic_programming;

/**
 * @program: leetcode
 * @description: 413. 等差数列划分
 * @author: shishi
 * @create: 2019-12-04 13:15
 **/

/**
 * A = [1, 2, 3, 4]
 * 返回: 3, A 中有三个子等差数组: [1, 2, 3], [2, 3, 4] 以及自身 [1, 2, 3, 4]。
 */
public class Number413 {
    // 暴力法
    public int numberOfArithmeticSlices(int[] A) {
        int sum = 0;
        for (int i = 0; i < A.length - 2; i++) {
            int d = A[i + 1] - A[i];
            for (int j = i + 2; j < A.length; j++) {
                if (A[j] - A[j - 1] != d)
                    break;
                else
                    sum++;
            }
        }
        return sum;
    }

    // 动态规划
    public int numberOfArithmeticSlices1(int[] A) {
        if (A.length<3) return 0;

        int sum = 0;
        int[] dp = new int[A.length];
        dp[0] = 0;
        dp[1] = 0;
        for (int i=2;i<A.length;i++){
            if (A[i]-A[i-1]==A[i-1]-A[i-2])
                dp[i] = dp[i-1] +1;
            sum+=dp[i];
        }
        return sum;
    }
}

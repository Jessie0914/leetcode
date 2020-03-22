package top_interview;

/**
 * @ClassName Solution50
 * @Description Pow(x, n)
 * @Author shishi
 * @Date 2020/3/7 16:11
 **/

/**
 * 实现 pow(x, n) ，即计算 x 的 n 次幂函数。
 * 输入: 2.00000, 10
 * 输出: 1024.00000
 * 输入: 2.10000, 3
 * 输出: 9.26100
 * 输入: 2.00000, -2
 * 输出: 0.25000
 * 解释: 2-2 = 1/22 = 1/4 = 0.25
 */
public class Solution50 {
    public double myPow(double x, int n) {
        if (n == 0)
            return 1.0;
        if (n < 0)
            return 1 / helper(x, -n);
        return helper(x, n);
    }

    private double helper(double x, int n) {
        if (n == 0)
            return 1.0;
        else {
            double temp = helper(x, n / 2);
            if (n % 2 == 0) {
                return temp * temp;
            } else {
                return temp * temp * x;
            }
        }
    }
}

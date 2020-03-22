package math;

/**
 * @ClassName Solution50
 * @Description TODO
 * @Author shishi
 * @Date 2020/2/12 20:32
 **/

/**
 * 实现 pow(x, n) ，即计算 x 的 n 次幂函数。
 */
public class Solution50 {
    // 超时
    public double myPow(double x, int n) {
        if (n == 0)
            return 1.0;

        boolean flag = n > 0;

        double res = 1.0;
        if (!flag) n = -n;
        for (int i = 0; i < n; i++) {
            res *= x;
        }

        return flag ? res : 1 / res;
    }

    // 分治法
    public double myPow2(double x, int n) {
        if (n == 0)
            return 1.0;
        else if (n > 0)
            return pow(x, n);
        else
            return 1 / pow(x, -n);
    }

    private double pow(double x, int n) {
        if (n == 0)
            return 1.0;
        double v = pow(x, n / 2);
        if (n % 2 == 0)
            return v * v;
        else
            return v * v * x;
    }
}

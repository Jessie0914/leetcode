package divide_and_conquer;

/**
 * @ClassName Solution50
 * @Description 50.Pow(x, y)
 * @Author shishi
 * @Date 2019/7/1 18:38
 **/

/**
 * 题目要求：
 * 实现 pow(x, n) ，即计算 x 的 n 次幂函数
 * <p>
 * 示例：
 * 输入: 2.00000, 10
 * 输出: 1024.00000
 * <p>
 * 输入: 2.10000, 3
 * 输出: 9.26100
 * <p>
 * 输入: 2.00000, -2
 * 输出: 0.25000
 * 解释: 2-2 = 1/22 = 1/4 = 0.25
 */
public class Solution50 {
    // 有一个现成的函数，Math.pow(a,b)

    // 我一开始用的是遍历法，一个for()循环搞定，但算出来的数字小数点有点多（其实是对的，他们的后台会处理的）

    // 如果用分治法的话，原理如下
    // 如果n为奇数，x^n = x^(n/2) * x^(n/2) * x
    // 如果n为偶数，x^n = x^(n/2) * x^(n/2)
    // 即x^n = x^(n/2) * x^(n/2) * x^(n%2)
    public double myPow(double x, int n) {
        if (n > 0) return power(x, n);
        else return 1.0 / power(x, -n);
    }

    private double power(double x, int n) {
        if (n == 0) return 1;
        double v = power(x, n / 2);
        if (n % 2 == 0) return v * v;
        else return v * v * x;
    }
}

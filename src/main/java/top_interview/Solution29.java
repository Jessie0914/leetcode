package top_interview;

/**
 * @ClassName Solution29
 * @Description 两数相除
 * @Author shishi
 * @Date 2020/3/2 23:16
 **/

/**
 * 给定两个整数，被除数 dividend 和除数 divisor。将两数相除，要求不使用乘法、除法和 mod 运算符。
 * 返回被除数 dividend 除以除数 divisor 得到的商。
 * <p>
 * 输入: dividend = 10, divisor = 3
 * 输出: 3
 * <p>
 * 输入: dividend = 7, divisor = -3
 * 输出: -2
 */
public class Solution29 {
    public int divide(int dividend, int divisor) {
        int count = 0;

        // 用来判断最后的值是正/负
        boolean flag = true;
        if ((dividend < 0 && divisor > 0) || (dividend > 0 && divisor < 0))
            flag = false;

        if (dividend == 0)
            return 0;

        // 边界特例情况
        if (dividend == Integer.MIN_VALUE) {
            if (divisor == -1)
                return Integer.MAX_VALUE;
            else if (divisor == 1)
                return Integer.MIN_VALUE;
        }
        if (dividend == Integer.MAX_VALUE) {
            if (divisor == 1)
                return Integer.MAX_VALUE;
            else if (divisor == -1)
                return -Integer.MAX_VALUE;
        }

        // 用long来表示，否则会越界，因为一直会判断x2的情况
        // 先取绝对值的时候，要注意先转换成long再取绝对值
        long m = Math.abs((long) dividend);
        long n = Math.abs((long) divisor);
        if (n == 1)
            return (int) (flag ?  m : -m);

        while (m >= n) {
            long p = n;
            long temp = 1;
            while (m >= (p << 1)) {
                p = p << 1;
                temp = temp << 1;
            }
            count += temp;
            m -= p;
        }

        return flag ? count : -count;
    }
}

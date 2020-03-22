package top_interview;

/**
 * @ClassName Solution7
 * @Description 整数反转
 * @Author shishi
 * @Date 2020/2/28 15:57
 **/

/**
 * 给出一个 32 位的有符号整数，你需要将这个整数中每位上的数字进行反转。
 */
public class Solution7 {
    public int reverse(int x) {
        if (x == 0)
            return 0;

        boolean flag = x > 0;
        int temp = 0;
        while (x != 0) {
            int num = x % 10;
            // 判断溢出
            if (flag && (temp > Integer.MAX_VALUE / 10 || (temp == Integer.MAX_VALUE / 10 && num > Integer.MAX_VALUE % 10)))
                return 0;
            else if (!flag && (temp < Integer.MIN_VALUE / 10 || (temp == Integer.MIN_VALUE / 10 && num < Integer.MIN_VALUE % 10)))
                return 0;
            else
                temp = temp * 10 + num;

            x /= 10;
        }
        return temp;
    }
}

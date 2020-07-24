package jianzhi;

/**
 * @Classname JZ48
 * @Description 不用加减乘除做加法
 * @Date 2020/7/24 2:11 下午
 * @Created by chiyue
 */
// JZ_MARK 位运算不会
public class JZ48 {
    public int Add(int num1, int num2) {
        int sum = 0;
        while (num2 != 0) {
            sum = num1 ^ num2;
            int carry = (num1 & num2) << 1;
            num1 = sum;
            num2 = carry;
        }
        return sum;
    }
}

package day_practice.april;

/**
 * @ClassName Solution8
 * @Description 8. 字符串转换整数 (atoi)
 * @Author shishi
 * @Date 2020/4/18 15:17
 **/

/**
 * 1、丢弃无用的开头空格字符，直到寻找到第一个非空格的字符为止 √
 * 2、如果第一个非空字符为正或者负号时，则将该符号与之后面尽可能多的连续数字字符组合起来，形成一个有符号整数。
 * 3、假如第一个非空字符是数字，则直接将其与之后连续的数字字符组合起来，形成一个整数。
 * 4、该字符串在有效的整数部分之后也可能会存在多余的字符，那么这些字符可以被忽略，它们对函数不应该造成影响。
 * 5、假如该字符串中的第一个非空格字符不是一个有效整数字符、字符串为空或字符串仅包含空白字符时，则你的函数不需要进行转换，即无法进行有效转换。
 * 6、在任何情况下，若函数不能进行有效的转换时，请返回 0 。
 * 7、注意溢出等情况
 */
public class Solution8 {
    public int myAtoi(String str) {
        if (str == null || str.length() == 0)
            return 0;

        // 跳过前面的空格字符
        int i = 0;
        while (i < str.length() && str.charAt(i) == ' ')
            i++;
        if (i == str.length())
            return 0;

        // 判断第一个非空字符是否有效
        if (str.charAt(i) != '-' && str.charAt(i) != '+' && !Character.isDigit(str.charAt(i)))
            return 0;

        // 判断正负
        boolean isNegative = str.charAt(i) == '-';
        if (isNegative)
            i++;
        else if (str.charAt(i)=='+')
            i++;

        int ans = 0;
        while (i < str.length()) {
            // 如果不是数字了，就跳出循环
            if (!Character.isDigit(str.charAt(i)))
                break;

            int temp = str.charAt(i) - '0';
            // 记得处理溢出
            if (!isNegative) {
                // 正溢出
                if (ans > Integer.MAX_VALUE / 10 || (ans == Integer.MAX_VALUE / 10 && temp >= Integer.MAX_VALUE % 10))
                    return Integer.MAX_VALUE;
                else {
                    ans = ans * 10 + temp;
                }
            } else {
                // 负溢出
                if (-ans < Integer.MIN_VALUE / 10 || (-ans == Integer.MIN_VALUE / 10 && -temp <= Integer.MIN_VALUE % 10))
                    return Integer.MIN_VALUE;
                else {
                    ans = ans * 10 + temp;
                }
            }
            i++;
        }

        return isNegative ? -ans : ans;
    }
}

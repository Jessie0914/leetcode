package String;

/**
 * @ClassName Solution8
 * @Description 8.字符串转换整数(atoi)
 * @Author shishi
 * @Date 2019/7/2 13:08
 **/

public class Solution8 {
    public int myAtoi(String str) {
        int num = 0;
        int sign = 1;
        final int n = str.length();
        if (n == 0) return 0;
        int i = 0;
        // 如果一直是空格的话，就一直i++
        while (i < n && str.charAt(i) == ' ') i++;
        if (i==n) return 0;

        // 第一个非空格字符是什么，如果是+或者-，记录下-的情况，并且都i++
        if (str.charAt(i) == '+') {
            i++;
        } else if (str.charAt(i) == '-') {
            sign = -1;
            i++;
        }

        for (; i < n; i++) {
            // 如果说当前的字符不是数字，直接break
            if (str.charAt(i) < '0' || str.charAt(i) > '9')
                break;

            // 如果num已经溢出了，就输出Integer.MIN_VALUE或者Integer.MAX_VALUE
            // 溢出的判断方法
            if (num > Integer.MAX_VALUE / 10 ||
                    (num == Integer.MAX_VALUE / 10 && (str.charAt(i) - '0') > Integer.MAX_VALUE % 10)) {
                return sign == -1 ? Integer.MIN_VALUE : Integer.MAX_VALUE;
            }
            // 数字字符转换成的方法是-'0'
            num = num * 10 + (str.charAt(i) - '0');
        }
        return num * sign;
    }
}

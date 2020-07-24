package jianzhi;

/**
 * @Classname JZ49
 * @Description 输入一个字符串, 包括数字字母符号, 可以为空.如果是合法的数值表达则返回该数字，否则返回0
 * +2147483647  ->      2147483647
 * 1a33         ->      0
 * @Date 2020/7/24 2:11 下午
 * @Created by chiyue
 */
public class JZ49 {
    public int StrToInt(String str) {
        if (str == null || str.length() == 0)
            return 0;

        str = str.replace(" ", "");
        if (str.length() == 0)
            return 0;

        int i = 0;
        int len = str.length();
        int res = 0;
        boolean flag = true;
        char c = str.charAt(0);
        if (c == '+') {
            i++;
        } else if (c == '-') {
            i++;
            flag = false;
        }
        while (i < len) {
            c = str.charAt(i);

            // 如果不是数字，则非法字符串，直接返回0
            if (!Character.isDigit(c)) {
                return 0;
            } else {
                // 要做溢出判断
                if (flag) {
                    if (res > Integer.MAX_VALUE / 10 || (res == Integer.MAX_VALUE / 10 && (c - '0') > Integer.MAX_VALUE % 10))
                        return 0;
                    else
                        res = res * 10 + (c - '0');
                } else {
                    if (-res < Integer.MIN_VALUE / 10 || (-res == Integer.MIN_VALUE / 10 && (-(c - '0')) < Integer.MIN_VALUE % 10))
                        return 0;
                    else
                        res = res * 10 + (c - '0');
                }
                i++;
            }
        }
        return flag ? res : -res;
    }
}

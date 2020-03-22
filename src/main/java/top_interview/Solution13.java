package top_interview;

/**
 * @ClassName Solution13
 * @Description 罗马数字转整数
 * @Author shishi
 * @Date 2020/2/28 20:37
 **/

import java.util.HashMap;

/**
 * I 可以放在 V (5) 和 X (10) 的左边，来表示 4 和 9。
 * X 可以放在 L (50) 和 C (100) 的左边，来表示 40 和 90。 
 * C 可以放在 D (500) 和 M (1000) 的左边，来表示 400 和 900。
 * 字符          数值
 * I             1
 * V             5
 * X             10
 * L             50
 * C             100
 * D             500
 * M             1000
 * <p>
 * 输入: "MCMXCIV"
 * 输出: 1994
 * 解释: M = 1000, CM = 900, XC = 90, IV = 4.
 */
public class Solution13 {
    public int romanToInt(String s) {
        if (s == null || s.length() == 0)
            return 0;

        HashMap<Character, Integer> map = new HashMap<>();
        map.put('I', 1);
        map.put('V', 5);
        map.put('X', 10);
        map.put('L', 50);
        map.put('C', 100);
        map.put('D', 500);
        map.put('M', 1000);

        int res = 0;

        int i = 0;
        while (i < s.length()) {
            char c = s.charAt(i);
            if (c != 'I' && c != 'X' && c != 'C') {
                res += map.get(c);
                i++;
            } else if (c == 'I') {
                if ((i + 1) < s.length()) {
                    if (s.charAt(i + 1) == 'V') {
                        res += 4;
                        i += 2;
                    } else if (s.charAt(i + 1) == 'X') {
                        res += 9;
                        i += 2;
                    } else {
                        res += 1;
                        i++;
                    }
                } else {
                    res += map.get(c);
                    i++;
                }
            } else if (c == 'X') {
                if ((i + 1) < s.length()) {
                    if (s.charAt(i + 1) == 'L') {
                        res += 40;
                        i += 2;
                    } else if (s.charAt(i + 1) == 'C') {
                        res += 90;
                        i += 2;
                    } else {
                        res += 10;
                        i++;
                    }
                } else {
                    res += map.get(c);
                    i++;
                }
            } else {
                if ((i + 1) < s.length()) {
                    if (s.charAt(i + 1) == 'D') {
                        res += 400;
                        i += 2;
                    } else if (s.charAt(i + 1) == 'M') {
                        res += 900;
                        i += 2;
                    } else {
                        res += 100;
                        i++;
                    }
                } else {
                    res += map.get(c);
                    i++;
                }
            }
        }

        return res;

    }
}

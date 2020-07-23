package jianzhi;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @Classname JZ32
 * @Description 输入一个正整数数组，把数组里所有数字拼接起来排成一个数，打印能拼接出的所有数字中最小的一个。
 * @Date 2020/7/23 3:37 下午
 * @Created by chiyue
 */
public class JZ32 {
    public String PrintMinNumber(int[] numbers) {
        String[] strings = new String[numbers.length];
        for (int i = 0; i < numbers.length; i++) {
            strings[i] = String.valueOf(numbers[i]);
        }

        Arrays.sort(strings, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                int i1 = Integer.parseInt(o1 + o2);
                int i2 = Integer.parseInt(o2 + o1);
                if (i1 <= i2)
                    return -1;
                else
                    return 1;
            }
        });

        StringBuilder s = new StringBuilder();
        for (String cur : strings)
            s.append(cur);
        return s.toString();
    }
}

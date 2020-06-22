package day_practice.april;

/**
 * @ClassName Solution202
 * @Description 202. 快乐数
 * @Author shishi
 * @Date 2020/4/30 9:39
 **/

import java.util.ArrayList;
import java.util.List;

/**
 * 编写一个算法来判断一个数 n 是不是快乐数。
 * <p>
 * 「快乐数」定义为：对于一个正整数，每一次将该数替换为它每个位置上的数字的平方和，
 * 然后重复这个过程直到这个数变为 1，也可能是 无限循环 但始终变不到 1。
 * 如果 可以变为  1，那么这个数就是快乐数。
 */
public class Solution202 {
    public boolean isHappy(int n) {
        List<Integer> list = new ArrayList<>();
        list.add(n);

        while (n != 1) {
            int calculate = calculate(n);
            if (list.contains(calculate))
                return false;
            list.add(calculate);
            n = calculate;
        }
        return true;
    }

    private int calculate(int n) {
        int res = 0;
        while (n != 0) {
            int temp = n % 10;
            res += temp * temp;
            n /= 10;
        }
        return res;
    }
}

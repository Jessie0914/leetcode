package top_interview;

/**
 * @ClassName Solution66
 * @Description 加一
 * @Author shishi
 * @Date 2020/3/9 12:56
 **/

import java.util.Arrays;

/**
 * 给定一个由整数组成的非空数组所表示的非负整数，在该数的基础上加一。
 * 最高位数字存放在数组的首位， 数组中每个元素只存储单个数字。
 * * 你可以假设除了整数 0 之外，这个整数不会以零开头。
 * <p>
 * 输入: [1,2,3]
 * 输出: [1,2,4]
 * 解释: 输入数组表示数字 123。
 * 输入: [4,3,2,1]
 * 输出: [4,3,2,2]
 * 解释: 输入数组表示数字 4321。
 */
public class Solution66 {
    // 土方法(参照我之前的解法，做了一些改进）
    // 更好的是一个题解的方法，非常非常的简洁
    public int[] plusOne(int[] digits) {
        // 从后往前找第一个非9的数字
        int i = digits.length - 1;
        while (i >= 0) {
            if (digits[i] != 9)
                break;
            i--;
        }

        // 如果这个非9的数字不是第一位
        if (i >= 0) {
            // 直接把它+1，并且后面的全部置为0
            digits[i]++;
            Arrays.fill(digits, i + 1, digits.length, 0);
            return digits;
        } else {
            digits = new int[digits.length + 1];
            digits[0] = 1;
            return digits;
        }
    }

    // 简洁明了的办法
    public int[] plusOne2(int[] digits) {
        for (int i = digits.length - 1; i >= 0; i--) {
            digits[i]++;
            digits[i] %= 10;
            if (digits[i] != 0)
                return digits;
        }
        digits = new int[digits.length + 1];
        digits[0] = 1;
        return digits;
    }

}

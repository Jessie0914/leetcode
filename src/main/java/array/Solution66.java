package array;

/**
 * @ClassName Solution66
 * @Description 66.加一
 * @Author shishi
 * @Date 2019/7/2 19:16
 **/

import com.sun.javafx.sg.prism.NGNode;

import javax.print.attribute.standard.Sides;
import java.util.Arrays;

/**
 * 题目要求：
 * 给定一个由整数组成的非空数组所表示的非负整数，在该数的基础上加一。
 *
 * 示例：
 * 输入: [1,2,3]
 * 输出: [1,2,4]
 */
public class Solution66 {
    // 我的解法就是从后往前找到第一个非9的数字，然后根据不同的情况进行不同的操作
    public static int[] plusOne(int[] digits) {
        int i = digits.length-1;
        // 从后往前找到第一个非9的数字位置
        while (i>0 && digits[i]==9) i--;
        int firstNotNight = i;
        // 如果这个非9位置在第一位往后的，比较好操作，把这一位++，后面全面置为0即可
        if (firstNotNight>0){
            digits[firstNotNight]++;
            Arrays.fill(digits,firstNotNight+1,digits.length,0);
            return digits;
        }
        // 如果这个非9位置是第一位，并且这一位的数字<9，那把这一位++，后面的置为0即可
        else if (digits[firstNotNight]<9){
            digits[firstNotNight]++;
            Arrays.fill(digits,firstNotNight+1,digits.length,0);
            return digits;
        }
        // 如果这个非9位置是第一位，并且这位也是9（其实说明所有的数字都为9）
        // 那么新增一个多一个容量的数组，第一位置为1，后面的全置为0即可
        else {
            int[] result = new int[digits.length + 1];
            result[0] = 1;
            Arrays.fill(result,1,result.length,0);
            return result;
        }
    }
}

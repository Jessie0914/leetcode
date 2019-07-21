package sort;

/**
 * @ClassName Solution179
 * @Description 179.最大数
 * @Author shishi
 * @Date 2019/7/13 19:08
 **/

import java.util.Arrays;

/**
 * 给定一组非负整数，重新排列它们的顺序使之组成一个最大的整数
 *
 * 示例：
 * 输入: [10,2]
 * 输出: 210
 *
 * 输入: [3,30,34,5,9]
 * 输出: 9534330
 */
public class Solution179 {
    public String largestNumber(int[] nums) {
        String[] strings = new String[nums.length];
        for (int i = 0; i < nums.length; ++i) {
            strings[i] = String.valueOf(nums[i]);
        }
        // 重点是这个自定义的比较器函数
        // s1+s2>s2+s1的话，s1排在s2前面
        Arrays.sort(strings, (String s1, String s2) -> {
            String leftRight = s1 + s2;
            String rightLeft = s2 + s1;
            return -leftRight.compareTo(rightLeft);
        });

        // 自定义一个拼接字符串
        StringBuilder sb = new StringBuilder();
        for (String s : strings) {
            sb.append(s);
        }
        // 消除首字母的0
        while(sb.charAt(0)=='0' && sb.length()>1){
            sb.deleteCharAt(0);
        }
        // StringBuilder转换成String
        return sb.toString();
    }
}

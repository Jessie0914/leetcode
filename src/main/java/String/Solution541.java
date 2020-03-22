package String;

/**
 * @ClassName Solution541
 * @Description 541.反转字符串2
 * @Author shishi
 * @Date 2019/7/3 20:12
 **/

/**
 * 题目要求：
 * 给定一个字符串和一个整数 k，你需要对从字符串开头算起的每个 2k 个字符的前k个字符进行反转。
 * 如果剩余少于 k 个字符，则将剩余的所有全部反转。
 * 如果有小于 2k 但大于或等于 k 个字符，则反转前 k 个字符，并将剩余的字符保持原样。
 * <p>
 * 示例：
 * 输入: s = "abcdefg", k = 2
 * 输出: "bacdfeg"
 */
public class Solution541 {
    // 这个函数用来控制何时反转，已经哪部分反转
    // 具体的反转操作，在下面的函数中定义
    public String reverseStr(String s, int k) {
        int length = s.length();

        // string字符串转换成char[]数组的函数
        // string.toCharArray
        char[] array = s.toCharArray();
        for (int i = 0; i < length; i += 2 * k) {
            if (i + 2 * k <= length || i + k <= length) {
                reverse(array, i, i + k - 1);
            } else {
                reverse(array, i, length - 1);
            }
        }
        // char[]数组转换成String字符串
        // String.valueOf(char[])
        return String.valueOf(array);

    }

    // 具体的翻转操作
    public void reverse(char[] s, int i, int j) {
        while (i < j) {
            char tmp = s[i];
            s[i] = s[j];
            s[j] = tmp;
            i++;
            j--;
        }
    }
}

package top_interview;

/**
 * @ClassName Solution38
 * @Description 外观数列
 * @Author shishi
 * @Date 2020/3/4 12:29
 **/

/**
 * 「外观数列」是一个整数序列，从数字 1 开始，序列中的每一项都是对前一项的描述。前五项如下：
 * 1.     1
 * 2.     11
 * 3.     21
 * 4.     1211
 * 5.     111221
 * <p>
 * 输入: 1
 * 输出: "1"
 * 输入: 4
 * 输出: "1211"
 */
public class Solution38 {
    public String countAndSay(int n) {
        int index = 1;
        String value = "1";
        while (index < n) {
            StringBuilder sb = new StringBuilder();
            int i = 0;
            char curNum;
            while (i < value.length()) {
                int count = 0;
                curNum = value.charAt(i);
                while (i < value.length() && value.charAt(i) == curNum) {
                    count++;
                    i++;
                }
                sb.append(count);
                sb.append(curNum);
            }
            value = sb.toString();
            index++;
        }
        return value;
    }
}

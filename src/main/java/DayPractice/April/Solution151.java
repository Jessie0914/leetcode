package DayPractice.April;

/**
 * @ClassName Solution151
 * @Description 151. 翻转字符串里的单词
 * @Author shishi
 * @Date 2020/4/19 15:31
 **/

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * 给定一个字符串，逐个翻转字符串中的每个单词。
 * 输入: "the sky is blue"
 * 输出: "blue is sky the"
 * <p>
 * 输入: "a good   example"
 * 输出: "example good a"
 * 解释: 如果两个单词间有多余的空格，将反转后单词间的空格减少到只含一个。
 * <p>
 * 输入: "  hello world!  "
 * 输出: "world! hello"
 * 解释: 输入字符串可以在前面或者后面包含多余的空格，但是反转后的字符不能包括。
 */
public class Solution151 {
    public String reverseWords(String s) {
        StringBuilder sb = new StringBuilder();
        int i = 0;
        while (i < s.length()) {
            if (s.charAt(i) != ' ') {
                while (i < s.length() && s.charAt(i) != ' ') {
                    sb.append(s.charAt(i));
                    i++;
                }
                sb.append(' ');
            } else {
                while (i < s.length() && s.charAt(i) == ' ')
                    i++;
            }
        }
        s = sb.toString();
        String[] split = s.split(" ");
        for (int j = 0; j < split.length / 2; j++) {
            String temp = split[j];
            split[j] = split[split.length - 1 - j];
            split[split.length - 1 - j] = temp;
        }

        StringBuilder stringBuilder = new StringBuilder();
        for (int j = 0; j < split.length; j++) {
            stringBuilder.append(split[j]);
            if (j != split.length - 1)
                stringBuilder.append(" ");
        }
        return stringBuilder.toString();
    }

    /**
     * 直接利用现有的API
     *
     * @param s
     * @return
     */
    public String reverseWords2(String s) {
        s = s.trim();
        // "\\"s代表:空格,回车,换行等空白符
        // "+"代表：一个或多个的意思
        // 所以这里其实也可以只用s.split(" +");
        String[] split = s.split("\\s+");
        List<String> list = Arrays.asList(split);
        Collections.reverse(list);
        return String.join(" ", list);
    }
}

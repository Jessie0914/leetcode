package top_interview;

/**
 * @ClassName Solution3
 * @Description 无重复字符的最长子串
 * @Author shishi
 * @Date 2020/2/27 23:17
 **/

import java.util.HashSet;

/**
 * 给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。
 * 输入: "abcabcbb"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
 */
public class Solution3 {
    // 维护一个滑动窗口
    public int lengthOfLongestSubstring(String s) {
        if (s.length() < 1)
            return 0;
        char[] chars = s.toCharArray();
        int i = 0;
        int j = i + 1;
        int maxLen = 1;
        HashSet<Character> set = new HashSet<>();
        set.add(chars[0]);
        while (j < s.length()) {
            char c = chars[j];
            if (set.contains(c)) {
                while (i < j) {
                    if (chars[i] == c) {
                        i++;
                        break;
                    } else {
                        set.remove(chars[i]);
                        i++;
                    }
                }
                j++;
            } else {
                set.add(c);
                if ((j - i + 1) > maxLen)
                    maxLen = j - i + 1;
                j++;
            }
        }
        return maxLen;
    }
}

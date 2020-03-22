package top_interview.string;

/**
 * @ClassName Solution3
 * @Description 无重复字符的最长子串
 * @Author shishi
 * @Date 2020/3/10 11:54
 **/

import java.util.HashSet;

/**
 * 给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。
 * 输入: "abcabcbb"
 * 输出: 3
 */
public class Solution3 {
    // 滑动窗口
    public int lengthOfLongestSubstring(String s) {
        int left = 0;
        int right = 0;
        int maxLen = 0;

        HashSet<Character> set = new HashSet<>();
        while (right < s.length()) {
            char c = s.charAt(right);

            if (!set.contains(c)) {
                set.add(c);
                if (right - left + 1 > maxLen)
                    maxLen = right - left + 1;
            } else {
                while (left <= right && s.charAt(left) != c) {
                    set.remove(s.charAt(left));
                    left++;
                }
                left++;
            }
            right++;
        }
        return maxLen;
    }
}

package day_practice.may;

/**
 * @ClassName Solution3
 * @Description 3. 无重复字符的最长子串
 * @Author shishi
 * @Date 2020/5/2 10:05
 **/

import java.util.HashSet;
import java.util.Set;

/**
 * 给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。
 * 输入: "abcabcbb"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
 * <p>
 * 输入: "pwwkew"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
 *      请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。
 */
public class Solution3 {
    public int lengthOfLongestSubstring(String s) {
        if (s == null || s.length() == 0)
            return 0;

        int len = s.length();
        int left = 0;
        int right = 0;

        Set<Character> set = new HashSet<>();

        int maxLen = Integer.MIN_VALUE;
        while (right < len) {
            char cur = s.charAt(right);

            if (!set.contains(cur)) {
                set.add(cur);
                right++;
            } else {
                while (left < right && s.charAt(left) != cur) {
                    set.remove(s.charAt(left));
                    left++;
                }
                set.remove(s.charAt(left));
                left++;
            }
            if ((right - left) > maxLen)
                maxLen = right - left;
        }
        return maxLen;
    }
}

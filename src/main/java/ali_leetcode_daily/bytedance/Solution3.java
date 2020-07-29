package ali_leetcode_daily.bytedance;

/**
 * @ClassName Solution3
 * @Description 给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。
 * @Author shishi
 * @Date 2020/7/26 16:26
 **/

import java.util.HashSet;

/**
 * 输入: "abcabcbb"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
 */
public class Solution3 {
    public int lengthOfLongestSubstring(String s) {
        if (s == null || s.length() == 0)
            return 0;

        HashSet<Character> set = new HashSet<>();
        int maxLen = 0;
        int left = 0;
        int right = 0;
        while (right < s.length()) {
            char c = s.charAt(right);

            if (!set.contains(c)) {
                set.add(c);

                if ((right - left + 1) > maxLen)
                    maxLen = right - left + 1;

            } else {
                char duplicated_c = s.charAt(right);
                while (left < right && s.charAt(left) != duplicated_c) {
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

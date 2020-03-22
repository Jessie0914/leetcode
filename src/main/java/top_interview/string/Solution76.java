package top_interview.string;

/**
 * @ClassName Solution76
 * @Description 最小覆盖子串
 * @Author shishi
 * @Date 2020/3/9 22:27
 **/

import java.util.HashMap;

/**
 * 给你一个字符串 S、一个字符串 T，请在字符串 S 里面找出：包含 T 所有字母的最小子串。
 * <p>
 * 输入: S = "ADOBECODEBANC", T = "ABC"
 * 输出: "BANC"
 */
public class Solution76 {
    // 滑动窗口
    public String minWindow(String s, String t) {
        if (s == null || s.length() == 0)
            return "";

        int start = 0;
        int end = 0;
        int maxLen = Integer.MAX_VALUE;

        int left = 0;
        int right = 0;

        // 创建一个t的字符字典填充
        HashMap<Character, Integer> dict_t = new HashMap<>();
        for (int i = 0; i < t.length(); i++)
            dict_t.put(t.charAt(i), dict_t.getOrDefault(t.charAt(i), 0) + 1);
        // 创建一个s的字符字典
        HashMap<Character, Integer> dict_s = new HashMap<>();

        // 应该有的种类个数和现符合的个数
        int required = dict_t.size();
        int curRequired = 0;

        while (right < s.length()) {
            char c = s.charAt(right);
            dict_s.put(c, dict_s.getOrDefault(c, 0) + 1);

            if (dict_t.containsKey(c) && (dict_t.get(c).intValue() == dict_s.get(c).intValue()))
                curRequired++;

            while (left <= right && curRequired == required) {
                // 先更新结果集
                if ((right - left + 1) < maxLen) {
                    maxLen = right - left + 1;
                    start = left;
                    end = right;
                }

                char removedC = s.charAt(left);
                dict_s.put(removedC, dict_s.get(removedC) - 1);
                if (dict_t.containsKey(removedC) && (dict_s.get(removedC).intValue() < dict_t.get(removedC).intValue()))
                    curRequired--;

                left++;
            }

            right++;
        }

        return maxLen == Integer.MAX_VALUE ? "" : s.substring(start, end + 1);

    }
}

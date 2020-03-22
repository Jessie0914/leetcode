package top_interview.string;

/**
 * @ClassName Solution438
 * @Description 找到字符串中所有字母异位词
 * @Author shishi
 * @Date 2020/3/10 12:06
 **/

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * 给定一个字符串 s 和一个非空字符串 p，找到 s 中所有是 p 的字母异位词的子串，返回这些子串的起始索引。
 * 字母异位词指字母相同，但排列不同的字符串
 * <p>
 * 输入:
 * s: "cbaebabacd" p: "abc"
 * 输出:
 * [0, 6]
 * 解释:
 * 起始索引等于 0 的子串是 "cba", 它是 "abc" 的字母异位词。
 * 起始索引等于 6 的子串是 "bac", 它是 "abc" 的字母异位词。
 * <p>
 * 输入:
 * s: "abab" p: "ab"
 * 输出:
 * [0, 1, 2]
 * 解释:
 * 起始索引等于 0 的子串是 "ab", 它是 "ab" 的字母异位词。
 * 起始索引等于 1 的子串是 "ba", 它是 "ab" 的字母异位词。
 * 起始索引等于 2 的子串是 "ab", 它是 "ab" 的字母异位词。
 */
public class Solution438 {
    public List<Integer> findAnagrams(String s, String p) {
        ArrayList<Integer> list = new ArrayList<>();

        // 记录p字符串的字典
        HashMap<Character, Integer> dict_P = new HashMap<>();
        for (int i = 0; i < p.length(); i++)
            dict_P.put(p.charAt(i), dict_P.getOrDefault(p.charAt(i), 0) + 1);
        int required = dict_P.size();
        int cur_required = 0;

        HashMap<Character, Integer> dict_S = new HashMap<>();

        int left = 0;
        int right = 0;

        while (right < s.length()) {
            char c = s.charAt(right);
            dict_S.put(c, dict_S.getOrDefault(c, 0) + 1);

            if (dict_P.containsKey(c) && dict_P.get(c).intValue() == dict_S.get(c).intValue())
                cur_required++;

            if (cur_required == required) {
                while (left <= right && cur_required == required) {
                    if (right - left + 1 == p.length()) {
                        list.add(left);
                    }

                    char c1 = s.charAt(left);
                    dict_S.put(c1, dict_S.get(c1) - 1);
                    if (dict_P.containsKey(c1) && dict_P.get(c1).intValue() > dict_S.get(c1).intValue())
                        cur_required--;
                    left++;

                }
            }

            right++;
        }
        return list;
    }
}

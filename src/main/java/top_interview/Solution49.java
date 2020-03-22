package top_interview;

/**
 * @ClassName Solution49
 * @Description 字母异位词分组
 * @Author shishi
 * @Date 2020/3/5 16:36
 **/

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/**
 * 给定一个字符串数组，将字母异位词组合在一起。
 * 字母异位词指字母相同，但排列不同的字符串。
 *
 * 输入: ["eat", "tea", "tan", "ate", "nat", "bat"],
 * 输出:
 * [
 *   ["ate","eat","tea"],
 *   ["nat","tan"],
 *   ["bat"]
 * ]
 */
public class Solution49 {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> list = new ArrayList<>();

        HashMap<String, List<String>> map = new HashMap<>();
        for (String s : strs) {
            char[] chars = s.toCharArray();
            Arrays.sort(chars);
            if (map.containsKey(String.valueOf(chars))){
                map.get(String.valueOf(chars)).add(s);
            }else {
                List<String> cur = new ArrayList<>();
                cur.add(s);
                list.add(cur);
                map.put(String.valueOf(chars),cur);
            }
        }

        return list;
    }
}

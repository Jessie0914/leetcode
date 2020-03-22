package other; /**
 * @ClassName Solution387
 * @Description 387.字符串中的第一个唯一字符
 * @Author shishi
 * @Date 2019/7/19 13:53
 **/

import java.util.HashMap;

/**
 * 题目要求：
 * 给定一个字符串，找到它的第一个不重复的字符，并返回它的索引。如果不存在，则返回 -1
 *
 * 示例：
 * s = "leetcode"
 * 返回 0.
 *
 * s = "loveleetcode",
 * 返回 2.
 */
public class Solution387 {
    // 最简单的方式，就是先遍历一遍，将出现的次数记录在hashmap
    // 然后再遍历一遍，就可以得出结论了
    public int firstUniqChar(String s) {
        HashMap<Character, Integer> hashMap = new HashMap<>();
        char[] chars = s.toCharArray();
        for (int i=0;i<chars.length;i++){
            if (hashMap.get(chars[i])==null){
                hashMap.put(chars[i],1);
            }else {
                hashMap.put(chars[i],hashMap.get(chars[i])+1);
            }
        }

        for (int i=0;i<chars.length;i++){
            if (hashMap.get(chars[i])==1) return i;
        }
        return -1;
    }
}

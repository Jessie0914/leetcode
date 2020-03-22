package top_interview.string;

/**
 * @ClassName Solution409
 * @Description 最长回文串
 * @Author shishi
 * @Date 2020/3/9 16:23
 **/

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * 给定一个包含大写字母和小写字母的字符串，找到通过这些字母构造成的最长的回文串。
 * 在构造过程中，请注意区分大小写。比如 "Aa" 不能当做一个回文字符串。
 * 假设字符串的长度不会超过 1010。
 * <p>
 * <p>
 * 输入:
 * "abccccdd"
 * 输出:
 * 7
 * 解释:
 * 我们可以构造的最长的回文串是"dccaccd", 它的长度是 7。
 */
public class Solution409 {
    // 通过，不过时空效率好像都一般
    public int longestPalindrome(String s) {
        HashMap<Character, Integer> hashMap = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            hashMap.put(s.charAt(i), hashMap.getOrDefault(s.charAt(i), 0) + 1);
        }

        int result = 0;
        boolean flag = false;
        Iterator<Map.Entry<Character, Integer>> iterator = hashMap.entrySet().iterator();
        while (iterator.hasNext()) {
            Map.Entry<Character, Integer> entry = iterator.next();
            if (entry.getValue() % 2 == 1) {
                flag = true;
                result += entry.getValue() - 1;
            } else
                result += entry.getValue();
        }

        return flag ? result + 1 : result;
    }

    // 类似的思路，试试看用数组存数量
    // 时间复杂度上好了很多，看来hashMap存取比数组费时多了
    public int longestPalindrome2(String s) {
        int[] counts = new int[128];
        for (int i = 0; i < s.length(); i++)
            counts[s.charAt(i)]++;

        boolean flag = false;
        int max = 0;
        for (int value : counts) {
            if (value % 2 == 1) {
                flag = true;
                max += value - 1;
            } else
                max += value;
        }

        return flag ? max + 1 : max;
    }
}

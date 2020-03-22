package cyc.algorithm.dynamic_programming;

import java.util.HashSet;
import java.util.List;

/**
 * @program: leetcode
 * @description: 139. 单词拆分
 * @author: shishi
 * @create: 2019-12-20 18:00
 **/

/**
 * 给定一个非空字符串 s 和一个包含非空单词列表的字典 wordDict，判定 s 是否可以被空格拆分为一个或多个在字典中出现的单词。
 * 输入: s = "leetcode", wordDict = ["leet", "code"]
 * 输出: true
 * 解释: 返回 true 因为 "leetcode" 可以被拆分成 "leet code"。
 * <p>
 * 输入: s = "catsandog", wordDict = ["cats", "dog", "sand", "and", "cat"]
 * 输出: false
 * <p>
 * 输入: s = "applepenapple", wordDict = ["apple", "pen"]
 * 输出: true
 * 解释: 返回 true 因为 "applepenapple" 可以被拆分成 "apple pen apple"。
 *      注意你可以重复使用字典中的单词。
 */
public class Number139 {
    public boolean wordBreak(String s, List<String> wordDict) {
        int length = s.length();
        boolean[] dp = new boolean[length + 1];
        HashSet<String> set = new HashSet<>(wordDict);

        // 代表空字符串永远为"true"
        dp[0] = true;

        // 需要两个指针
        for (int i = 1; i <= length; i++) {
            for (int j = 0; j < i; j++) {
                // 截取小于i的每一个子串，如果在字典中存在的话，那么再去看此时的dp[j]是否为true
                // 两个条件都为真的话，那么修改dp[i]为true
                String substring = s.substring(j, i);
                if (set.contains(substring) && dp[j])
                    dp[i] = true;
            }
        }

        // dp[length]就是代表:以length为结束的子串（其实就是整个字符串）是否满足要求
        return dp[length];
    }
}

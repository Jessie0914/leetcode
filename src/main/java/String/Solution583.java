package String;

/**
 * @ClassName Solution583
 * @Description 583. 两个字符串的删除操作
 * @Author shishi
 * @Date 2019/10/4 20:25
 **/

/**
 * 给定两个单词 word1 和 word2，找到使得 word1 和 word2 相同所需的最小步数，
 * 每步可以删除任意一个字符串中的一个字符。
 *
 * 输入: "sea", "eat"
 * 输出: 2
 * 解释: 第一步将"sea"变为"ea"，第二步将"eat"变为"ea"
 */
public class Solution583 {
    // 最小距离即为m+n-2*lcs，m为字符串1的长度，n为字符串2的长度，lcs为两个字符串的最长公共子序列
    // 假设word1和word2完全不相同，那么结果就为m+n，现在有lcs个字符是相同的话，结果就为m+n-2*lcs
    public int minDistance(String word1, String word2) {
        return word1.length()+word2.length()-2*lcs(word1,word2);
    }

    private int lcs(String word1, String word2) {
        int[][] dp = new int[word1.length()+1][word2.length()+1];
        for (int i=1;i<word1.length()+1;i++){
            for (int j=1;j<word2.length()+1;j++){
                if (word1.charAt(i-1)==word2.charAt(j-1))
                    dp[i][j] = dp[i-1][j-1] + 1;
                else
                    dp[i][j] = Math.max(dp[i-1][j],dp[i][j-1]);
            }
        }
        return dp[word1.length()][word2.length()];
    }
}
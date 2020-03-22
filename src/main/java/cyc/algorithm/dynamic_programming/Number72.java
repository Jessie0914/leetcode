package cyc.algorithm.dynamic_programming;

/**
 * @ClassName Number72
 * @Description 编辑距离
 * @Author shishi
 * @Date 2020/3/22 13:51
 **/

/**
 * 给定两个单词 word1 和 word2，计算出将 word1 转换成 word2 所使用的最少操作数 。
 * <p>
 * 你可以对一个单词进行如下三种操作：
 * <p>
 * 插入一个字符
 * 删除一个字符
 * 替换一个字符
 * <p>
 * 输出: 3
 * 解释:
 * horse -> rorse (将 'h' 替换为 'r')
 * rorse -> rose (删除 'r')
 * rose -> ros (删除 'e')
 */
public class Number72 {
    public int minDistance(String word1, String word2) {
        if (word1 == null || word2==null)
            return 0;

        int len1 = word1.length();
        int len2 = word2.length();
        int[][] dp = new int[len1 + 1][len2 + 1];


        dp[0][0] = 0;
        for (int i = 1; i < len1 + 1; i++)
            dp[i][0] = i;
        for (int j = 1; j < len2 + 1; j++)
            dp[0][j] = j;

        for (int i = 1; i < len1 + 1; i++) {
            for (int j = 1; j < len2 + 1; j++) {
                if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
                    dp[i][j] = Math.min(dp[i - 1][j - 1], dp[i - 1][j] + 1);
                    dp[i][j] = Math.min(dp[i][j], dp[i][j - 1] + 1);
                } else {
                    dp[i][j] = Math.min(dp[i - 1][j - 1] + 1, dp[i - 1][j] + 1);
                    dp[i][j] = Math.min(dp[i][j], dp[i][j - 1] + 1);
                }
            }
        }
        return dp[len1][len2];
    }
}
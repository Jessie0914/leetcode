package ali_leetcode_daily.dynamic_programming.string;

/**
 * @ClassName Solution72
 * @Description 72. 编辑距离
 * @Author shishi
 * @Date 2020/6/29 21:39
 **/
public class Solution72 {
    public int minDistance(String word1, String word2) {
        if (word1 == null || word1.length() == 0)
            return word2.length();

        if (word2 == null || word2.length() == 0)
            return word1.length();

        int len1 = word1.length();
        int len2 = word2.length();

        int[][] dp = new int[len1 + 1][len2 + 1];
        dp[0][0] = 0;

        // base case
        for (int i = 1; i < len1 + 1; i++) {
            dp[i][0] = i;
        }
        for (int j = 1; j < len2 + 1; j++) {
            dp[0][j] = j;
        }

        // dp
        for (int i = 1; i < len1 + 1; i++) {
            for (int j = 1; j < len2 + 1; j++) {
                // 这时候，可以不用比较[i-1][j]和[i][j-1]的值了，只可能是[i-1][j-1]的值最小
                if (word1.charAt(i - 1) == word2.charAt(j - 1))
                    dp[i][j] = dp[i - 1][j - 1];
                else {
                    dp[i][j] = Math.min(dp[i - 1][j], dp[i][j - 1]) + 1;
                    dp[i][j] = Math.min(dp[i][j], dp[i - 1][j - 1] + 1);
                }
            }
        }

        return dp[len1][len2];
    }
}

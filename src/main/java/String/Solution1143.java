package String;

/**
 * @ClassName Solution1143
 * @Description 1143. 最长公共子序列
 * @Author shishi
 * @Date 2019/10/4 20:37
 **/

/**
 * 给定两个字符串 text1 和 text2，返回这两个字符串的最长公共子序列。
 * 输入：text1 = "abcde", text2 = "ace"
 * 输出：3
 * 解释：最长公共子序列是 "ace"，它的长度为 3。
 * <p>
 * 输入：text1 = "abc", text2 = "abc"
 * 输出：3
 * 解释：最长公共子序列是 "abc"，它的长度为 3。
 * <p>
 * 输入：text1 = "abc", text2 = "def"
 * 输出：0
 * 解释：两个字符串没有公共子序列，返回 0。
 */
public class Solution1143 {
    // 方法1：递归
    // 优点：好理解，但是这种方法只能求解长度
    // 缺点：无法求解具体的子序列，并且效率没有动态规划高，最终会超时
    public int longestCommonSubsequence(String text1, String text2) {
        return lcs(text1, text2, text1.length(), text2.length());
    }

    private int lcs(String text1, String text2, int length1, int length2) {
        // 递归结束条件
        if (length1 == 0 || length2 == 0)
            return 0;

        // 如果最后一位相同
        if (text1.charAt(length1 - 1) == text2.charAt(length2 - 1)) {
            return 1 + lcs(text1, text2, length1 - 1, length2 - 1);
        }
        // 如果不相同，就有两种情况；取大的那种
        else {
            return Math.max(lcs(text1, text2, length1, length2 - 1), lcs(text1, text2, length1 - 1, length2));
        }
    }

    // 方法2：带记忆化的最长公共子序列
    // 核心思想：是用一个memo数组，存放所有已经遍历过得到结果的数组，避免重复计算，但是本身也会用到递归
    // 比递归效率高很多了，不会超时了
    public int longestCommonSubsequence2(String text1, String text2) {
        // 初始化一个int[text1.length()+1][text2.length()+1]的数组，默认全部是0
        // 注意数组的大小
        int[][] memo = new int[text1.length() + 1][text2.length() + 1];
        return lcs2(text1, text2, text1.length(), text2.length(), memo);
    }

    // 将这个记录所有值的数组也加入到参数中
    private int lcs2(String text1, String text2, int m, int n, int[][] memo) {
        if (m == 0 || n == 0)
            return 0;

        // 如果memo[m][n]≠0，也就是说>0，那么其实就是已经算出结果了，直接return
        if (memo[m][n] > 0)
            return memo[m][n];

        // 如果最后一位相等
        if (text1.charAt(m - 1) == text2.charAt(n - 1)) {
            memo[m][n] = lcs2(text1, text2, m - 1, n - 1, memo) + 1;
        }
        // 如果不相等
        else {
            memo[m][n] = Math.max(lcs2(text1, text2, m - 1, n, memo), lcs2(text1, text2, m, n - 1, memo));
        }

        // 最后memo[text1.length()][text2.length()]即为最后的结果
        return memo[m][n];
    }

    // 方法3：动态规划
    // 效率比较前面两个都高
    public int longestCommonSubsequence3(String text1, String text2) {
        // dp数组一开始默认初始化都为0，到最后dp[text1.length()][text2.length()]即为答案
        int[][] dp = new int[text1.length() + 1][text2.length() + 1];
        for (int i = 1; i < text1.length() + 1; i++) {
            for (int j = 1; j < text2.length() + 1; j++) {
                if (text1.charAt(i - 1) == text2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }
        return dp[text1.length()][text2.length()];
    }

}

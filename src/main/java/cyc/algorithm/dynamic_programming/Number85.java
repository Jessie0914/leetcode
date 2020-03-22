package cyc.algorithm.dynamic_programming;

/**
 * @ClassName Number85
 * @Description 最大矩形
 * @Author shishi
 * @Date 2020/3/22 14:15
 **/

/**
 * 给定一个仅包含 0 和 1 的二维二进制矩阵，找出只包含 1 的最大矩形，并返回其面积。
 * 输入:
 * [
 * ["1","0","1","0","0"],
 * ["1","0","1","1","1"],
 * ["1","1","1","1","1"],
 * ["1","0","0","1","0"]
 * ]
 * 输出: 6
 */
public class Number85 {
    public int maximalRectangle(char[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0)
            return 0;

        int len1 = matrix.length;
        int len2 = matrix[0].length;

        int[][] widthOne = new int[len1][len2];
        int[][] dp = new int[len1][len2];
        // 先遍历数组，求得每一个位置最长的全为1的宽度
        for (int i = 0; i < len1; i++) {
            for (int j = 0; j < len2; j++) {
                if (j == 0)
                    widthOne[i][j] = matrix[i][j] == '1' ? 1 : 0;
                else {
                    if (matrix[i][j] == '0')
                        widthOne[i][j] = 0;
                    else
                        widthOne[i][j] = widthOne[i][j - 1] + 1;
                }
            }
        }

        int ans = Integer.MIN_VALUE;
        // 然后计算
        for (int i = 0; i < len1; i++) {
            for (int j = 0; j < len2; j++) {
                if (i == 0 && j == 0)
                    dp[0][0] = widthOne[0][0] == 1 ? 1 : 0;
                else {
                    int height = i - 1;
                    int minWidth = widthOne[i][j];
                    dp[i][j] = minWidth;
                    while (height >= 0) {
                        int curwidth = widthOne[height][j];
                        minWidth = Math.min(curwidth, minWidth);
                        dp[i][j] = Math.max(minWidth * (i - height + 1), dp[i][j]);
                        height--;
                    }
                }

                if (dp[i][j] > ans)
                    ans = dp[i][j];
            }
        }
        return ans;
    }
}

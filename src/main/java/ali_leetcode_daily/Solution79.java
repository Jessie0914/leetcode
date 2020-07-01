package ali_leetcode_daily;

/**
 * @ClassName Solution79
 * @Description 单词搜索
 * @Author shishi
 * @Date 2020/6/22 22:10
 **/

/**
 * https://leetcode-cn.com/problems/word-search/
 * 给定一个二维网格和一个单词，找出该单词是否存在于网格中。
 * 单词必须按照字母顺序，通过相邻的单元格内的字母构成，其中“相邻”单元格是那些水平相邻或垂直相邻的单元格。同一个单元格内的字母不允许被重复使用。
 * <p>
 * board =
 * [
 * ['A','B','C','E'],
 * ['S','F','C','S'],
 * ['A','D','E','E']
 * ]
 * <p>
 * 给定 word = "ABCCED", 返回 true
 * 给定 word = "SEE", 返回 true
 * 给定 word = "ABCB", 返回 false
 */
public class Solution79 {
    // 定义4个方向的数组
    int[] dx = {0, 0, -1, 1};
    int[] dy = {-1, 1, 0, 0};
    int m;
    int n;

    public boolean exist(char[][] board, String word) {
        if (word == null || word.length() == 0 || board == null || board.length == 0 || board[0].length == 0) {
            return false;
        }

        m = board.length;
        n = board[0].length;

        boolean[][] used = new boolean[m][n];

        // 对于每一个位置，都深搜一遍
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (dfs(board, word, used, i, j, 0)) {
                    return true;
                }
            }
        }

        return false;
    }

    // 深搜
    private boolean dfs(char[][] board, String word, boolean[][] used, int i, int j, int index) {
        // 成功的标志
        if (index == word.length() - 1) {
            return board[i][j] == word.charAt(index);
        }

        if (board[i][j] == word.charAt(index)) {
            // 先标记
            used[i][j] = true;

            // 4个方向深搜
            for (int k = 0; k < 4; k++) {
                // 往前走一步
                int newX = i + dx[k];
                int newY = j + dy[k];
                if (inArea(newX, newY) && !used[newX][newY]) {
                    if (dfs(board, word, used, newX, newY, index + 1)) {
                        return true;
                    }
                }
            }

            // 退回
            used[i][j] = false;
        }

        return false;
    }

    private boolean inArea(int i, int j) {
        return i >= 0 && i < m && j >= 0 && j < n;
    }
}
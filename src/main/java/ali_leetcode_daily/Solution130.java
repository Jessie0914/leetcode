package ali_leetcode_daily;

/**
 * @ClassName Solution130
 * @Description 130. 被围绕的区域
 * @Author shishi
 * @Date 2020/6/25 15:07
 **/

/**
 * 给定一个二维的矩阵，包含 'X' 和 'O'（字母 O）。
 * 任何不在边界上，或不与边界上的 'O' 相连的 'O' 最终都会被填充为 'X'。
 */
public class Solution130 {
    int m;
    int n;
    int[] dx = {0, 0, -1, 1};
    int[] dy = {-1, 1, 0, 0};

    public void solve(char[][] board) {
        if (board == null || board.length == 0 || board[0].length == 0)
            return;

        m = board.length;
        n = board[0].length;

        boolean[][] flag = new boolean[m][n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (isBound(i, j) && board[i][j] == 'O') {
                    dfs(board, i, j, flag);
                }
            }
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (!flag[i][j])
                    board[i][j] = 'X';
                else
                    board[i][j] = 'O';
            }
        }

    }

    private void dfs(char[][] board, int i, int j, boolean[][] flag) {
        if (board[i][j] != 'O')
            return;

        for (int k = 0; k < 4; k++) {
            flag[i][j] = true;

            int newX = i + dx[k];
            int newY = j + dy[k];

            if (inArea(newX, newY) && !flag[newX][newY]) {
                dfs(board, newX, newY, flag);
            }
        }
    }

    private boolean inArea(int i, int j) {
        return i >= 0 && i < m && j >= 0 && j < n;
    }

    // 判断是不是边界上的值
    private boolean isBound(int i, int j) {
        return i == 0 || j == 0 || i == m - 1 || j == n - 1;
    }
}

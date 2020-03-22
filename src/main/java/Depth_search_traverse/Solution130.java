package Depth_search_traverse;

/**
 * @ClassName Solution130
 * @Description 被围绕的区域
 * @Author shishi
 * @Date 2020/3/22 22:28
 **/

/**
 * 给定一个二维的矩阵，包含 'X' 和 'O'（字母 O）。
 * 找到所有被 'X' 围绕的区域，并将这些区域里所有的 'O' 用 'X' 填充。
 */
public class Solution130 {
    public void solve(char[][] board) {
        if (board == null || board.length == 0 || board[0].length == 0)
            return;

        int n = board.length;
        int m = board[0].length;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                // 如果是边界且为0，则去dfs
                if ((i == 0 || i == n - 1 || j == 0 || j == m - 1) && board[i][j] == 'O')
                    dfs(board, i, j);
            }
        }

        // 将#替换成0，其他的都是X
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (board[i][j] != '#')
                    board[i][j] = 'X';
                else
                    board[i][j] = 'O';
            }
        }

    }

    private void dfs(char[][] board, int i, int j) {
        if (i < 0 || i >= board.length || j < 0 || j >= board[0].length || board[i][j] == '#' || board[i][j] == 'X')
            return;
        board[i][j] = '#';
        // 上下左右去递归
        dfs(board, i - 1, j);
        dfs(board, i + 1, j);
        dfs(board, i, j - 1);
        dfs(board, i, j + 1);
    }

}

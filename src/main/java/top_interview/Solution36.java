package top_interview;

/**
 * @ClassName Solution36
 * @Description 有效的数独
 * @Author shishi
 * @Date 2020/3/3 22:44
 **/

import java.util.HashSet;

/**
 * 数字 1-9 在每一行只能出现一次。
 * 数字 1-9 在每一列只能出现一次。
 * 数字 1-9 在每一个以粗实线分隔的 3x3 宫内只能出现一次
 */
public class Solution36 {
    public boolean isValidSudoku(char[][] board) {
        // 先一行一行判断
        for (int i = 0; i < 9; i++) {
            if (!judge(board, i, i, 0, 8)) {
                return false;
            }
        }
        // 然后一列一列判断
        for (int j = 0; j < 9; j++) {
            if (!judge(board, 0, 8, j, j)) {
                return false;
            }
        }

        // 最后3格3格的判断
        if (!judge(board, 0, 2, 0, 2))
            return false;
        if (!judge(board, 0, 2, 3, 5))
            return false;
        if (!judge(board, 0, 2, 6, 8))
            return false;

        if (!judge(board, 3, 5, 0, 2))
            return false;
        if (!judge(board, 3, 5, 3, 5))
            return false;
        if (!judge(board, 3, 5, 6, 8))
            return false;

        if (!judge(board, 6, 8, 0, 2))
            return false;
        if (!judge(board, 6, 8, 3, 5))
            return false;
        if (!judge(board, 6, 8, 6, 8))
            return false;

        return true;
    }

    // 判断函数
    private boolean judge(char[][] board, int up, int down, int left, int right) {
        HashSet<Character> set = new HashSet<>();
        for (int i = up; i <= down; i++) {
            for (int j = left; j <= right; j++) {
                if (set.contains(board[i][j]) && board[i][j]!='.')
                    return false;
                set.add(board[i][j]);
            }
        }
        return true;
    }
}

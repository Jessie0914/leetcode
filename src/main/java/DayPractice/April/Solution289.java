package DayPractice.April;

/**
 * @ClassName Solution289
 * @Description 289. 生命游戏
 * @Author shishi
 * @Date 2020/4/2 12:13
 **/

/**
 * 给定一个包含 m × n 个格子的面板，每一个格子都可以看成是一个细胞。每个细胞都具有一个初始状态：1 即为活细胞（live），或 0 即为死细胞（dead）。每个细胞与其八个相邻位置（水平，垂直，对角线）的细胞都遵循以下四条生存定律：
 * <p>
 * 如果活细胞周围八个位置的活细胞数少于两个，则该位置活细胞死亡；
 * 如果活细胞周围八个位置有两个或三个活细胞，则该位置活细胞仍然存活；
 * 如果活细胞周围八个位置有超过三个活细胞，则该位置活细胞死亡；
 * 如果死细胞周围正好有三个活细胞，则该位置死细胞复活；
 * <p>
 * 输入：
 * [
 *   [0,1,0],
 *   [0,0,1],
 *   [1,1,1],
 *   [0,0,0]
 * ]
 * 输出：
 * [
 *   [0,0,0],
 *   [1,0,1],
 *   [0,1,1],
 *   [0,1,0]
 * ]
 */
public class Solution289 {
    // 需要用到额外的数组，当数组比较大的时候，会比较耗费空间
    public void gameOfLife(int[][] board) {
        int n = board.length;
        int m = board[0].length;
        int[][] counts = new int[n][m];
        // 更新counts数组，去计算每个细胞周围的活细胞的数量
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                // 从8个方向计算
                // 上
                if (i - 1 >= 0 && board[i - 1][j] == 1)
                    counts[i][j]++;
                // 下
                if (i + 1 < n && board[i + 1][j] == 1)
                    counts[i][j]++;
                // 左
                if (j - 1 >= 0 && board[i][j - 1] == 1)
                    counts[i][j]++;
                // 右
                if (j + 1 < m && board[i][j + 1] == 1)
                    counts[i][j]++;

                // 对角线1
                if (i - 1 >= 0 && j - 1 >= 0 && board[i - 1][j - 1] == 1)
                    counts[i][j]++;
                if (i + 1 < n && j + 1 < m && board[i + 1][j + 1] == 1)
                    counts[i][j]++;

                // 对角线2
                if (i - 1 >= 0 && j + 1 < m && board[i - 1][j + 1] == 1)
                    counts[i][j]++;
                if (i + 1 < n && j - 1 >= 0 && board[i + 1][j - 1] == 1)
                    counts[i][j]++;
            }
        }

        // 根据counts数字去更新boards
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                // 如果是活细胞
                if (board[i][j] == 1) {
                    if (counts[i][j] < 2 || counts[i][j] > 3)
                        board[i][j] = 0;
                } else {
                    if (counts[i][j] == 3)
                        board[i][j] = 1;
                }
            }
        }
    }

    // 原地修改状态，不需要额外的状态
    // 关键就在于：定义额外的复合状态：-1：从活到死。2：从死到活
    public void gameOfLife2(int[][] board) {
        int n = board.length;
        int m = board[0].length;
        // 更新counts数组，去计算每个细胞周围的活细胞的数量
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                // 如果
                int count = 0;
                // 从8个方向计算
                // 上
                if (i - 1 >= 0 && (board[i - 1][j] == 1 || board[i - 1][j] == -1))
                    count++;
                // 下
                if (i + 1 < n && (board[i + 1][j] == 1 || board[i + 1][j] == -1))
                    count++;
                // 左
                if (j - 1 >= 0 && (board[i][j - 1] == 1 || board[i][j - 1] == -1))
                    count++;
                // 右
                if (j + 1 < m && (board[i][j + 1] == 1 || board[i][j + 1] == -1))
                    count++;

                // 对角线1
                if (i - 1 >= 0 && j - 1 >= 0 && (board[i - 1][j - 1] == 1 || board[i - 1][j - 1] == -1))
                    count++;
                if (i + 1 < n && j + 1 < m && (board[i + 1][j + 1] == 1 || board[i + 1][j + 1] == -1))
                    count++;
                // 对角线2
                if (i - 1 >= 0 && j + 1 < m && (board[i - 1][j + 1] == 1 || board[i - 1][j + 1] == -1))
                    count++;
                if (i + 1 < n && j - 1 >= 0 && (board[i + 1][j - 1] == 1 || board[i + 1][j - 1] == -1))
                    count++;

                if (board[i][j] == 1) {
                    if (count < 2 || count > 3)
                        board[i][j] = -1;
                } else {
                    if (count == 3)
                        board[i][j] = 2;
                }
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (board[i][j] >= 1) {
                    board[i][j] = 1;
                } else
                    board[i][j] = 0;
            }
        }
    }
}


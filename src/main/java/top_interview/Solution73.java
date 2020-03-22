package top_interview;

/**
 * @ClassName Solution73
 * @Description 矩阵置零
 * @Author shishi
 * @Date 2020/3/9 14:06
 **/

/**
 * 给定一个 m x n 的矩阵，如果一个元素为 0，则将其所在行和列的所有元素都设为 0。请使用原地算法。
 * 输入:
 * [
 *   [1,1,1],
 *   [1,0,1],
 *   [1,1,1]
 * ]
 * 输出:
 * [
 *   [1,0,1],
 *   [0,0,0],
 *   [1,0,1]
 * ]
 */
public class Solution73 {
    public void setZeroes(int[][] matrix) {
        int row = matrix.length;
        int column = matrix[0].length;
        // 记录哪一行需要变成0
        boolean[] row_status = new boolean[row];
        // 记录哪一列需要变成0
        boolean[] column_status = new boolean[column];

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {
                if (matrix[i][j] == 0) {
                    row_status[i] = true;
                    column_status[j] = true;
                }
            }
        }

        for (int i = 0; i < row; i++) {
            if (row_status[i]) {
                for (int index = 0; index < column; index++)
                    matrix[i][index] = 0;
            }
        }

        for (int j = 0; j < column; j++) {
            if (column_status[j]) {
                for (int index = 0; index < row; index++)
                    matrix[index][j] = 0;
            }
        }
    }
}

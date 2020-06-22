package day_practice.april;

/**
 * @ClassName Solution_01_07
 * @Description 旋转矩阵
 * @Author shishi
 * @Date 2020/4/7 14:11
 **/
public class Solution_01_07 {
    public void rotate(int[][] matrix) {
        if (matrix == null || matrix.length == 0)
            return;

        int n = matrix.length;
        // 先转置
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                int tmp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = tmp;
            }
        }

        // 再每行反转
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n / 2; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[i][n - 1 - j];
                matrix[i][n - 1 - j] = temp;
            }
        }
    }
}

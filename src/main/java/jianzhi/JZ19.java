package jianzhi;

import java.util.ArrayList;

/**
 * @ClassName JZ19
 * @Description 输入一个矩阵，按照从外向里以顺时针的顺序依次打印出每一个数字
 * @Author shishi
 * @Date 2020/7/13 23:20
 **/
// JZ_MARK
public class JZ19 {
    public ArrayList<Integer> printMatrix(int[][] matrix) {
        ArrayList<Integer> list = new ArrayList<>();

        if (matrix == null || matrix.length == 0)
            return list;

        int m = matrix.length;
        int n = matrix[0].length;

        int left = 0;
        int right = n - 1;
        int up = 0;
        int down = m - 1;

        while (left <= right && up <= down) {
            int i = left;
            int j = right;
            // 先打印最上面一行
            while (i <= j) {
                list.add(matrix[up][i]);
                i++;
            }
            up++;
            if (up > down)
                break;

            // 然后打印最右侧一列
            i = up;
            j = down;
            while (i <= j) {
                list.add(matrix[i][right]);
                i++;
            }
            right--;
            if (right < left)
                break;

            // 接着打印最下面一行
            i = right;
            j = left;
            while (i >= j) {
                list.add(matrix[down][i]);
                i--;
            }
            down--;
            if (down < up)
                break;

            // 最后打印最左侧一列
            i = down;
            j = up;
            while (i >= j) {
                list.add(matrix[i][left]);
                i--;
            }
            left++;
            if (left > right)
                break;
        }
        return list;
    }
}

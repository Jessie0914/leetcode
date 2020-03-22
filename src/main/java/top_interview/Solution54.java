package top_interview;

/**
 * @ClassName Solution54
 * @Description 螺旋矩阵
 * @Author shishi
 * @Date 2020/3/7 20:28
 **/

import java.util.ArrayList;
import java.util.List;

/**
 * 给定一个包含 m x n 个元素的矩阵（m 行, n 列），请按照顺时针螺旋顺序，返回矩阵中的所有元素。
 * 输入:
 * [
 * [ 1, 2, 3 ],
 * [ 4, 5, 6 ],
 * [ 7, 8, 9 ]
 * ]
 * 输出: [1,2,3,6,9,8,7,4,5]
 */
public class Solution54 {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> list = new ArrayList<>();

        if (matrix==null || matrix.length==0 || matrix[0].length==0)
            return list;
        int up = 0;
        int down = matrix.length - 1;
        int left = 0;
        int right = matrix[0].length - 1;

        int i;
        while (true) {

            if (left>right)
                break;
            i = left;
            while (i <= right) {
                list.add(matrix[up][i]);
                i++;
            }
            up++;

            /**
             * [ 1, 2, 3 ],
             * [ 4, 5, 6 ],
             * [ 7, 8, 9 ]
             */

            if (up>down)
                break;
            i = up;
            while (i <= down) {
                list.add(matrix[i][right]);
                i++;
            }
            right--;

            if (right<left)
                break;
            i = right;
            while (i >= left) {
                list.add(matrix[down][i]);
                i--;
            }
            down--;

            if (down<up)
                break;
            i = down;
            while (i >= up) {
                list.add(matrix[i][left]);
                i--;
            }
            left++;


        }

        return list;

    }
}

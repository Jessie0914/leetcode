package ali_leetcode_daily;

/**
 * @ClassName Solution498
 * @Description TODO
 * @Author shishi
 * @Date 2020/6/18 23:04
 **/
public class Solution498 {
    public int[] findDiagonalOrder(int[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return new int[0];
        }

        int m = matrix.length;
        int n = matrix[0].length;

        int i = 0, j = 0;
        int index = 0;
        int[] res = new int[m * n];

        // 一共要遍历m*n次
        while (index < m * n) {
            // 如果当前坐标和为偶数，那么就是从下到上的方向
            if ((i + j) % 2 == 0) {
                // 只要不越界就一直遍历
                while (i >= 0 && j < n) {
                    res[index++] = matrix[i][j];

                    // 因为是从下到上的方向，所以i在减少，j在增加
                    i--;
                    j++;
                }

                // 到了越界的时候，要分i越界还是j越界
                // 如果i越界了，但是j还没有越界，那么下一个位置就是i++即可（画图就清楚了）
                if (j < n) {
                    i++;
                } else {
                    // 下一个位置是i+2,j-1
                    i += 2;
                    j--;
                }
            }

            // 如果当前坐标和为奇数，那么就是从上到下的方向
            else {
                while (i < m && j >= 0) {
                    res[index++] = matrix[i][j];

                    // 从上到下，所以i++,j--
                    i++;
                    j--;
                }

                // 如果是j越界了,i没有越界
                if (j < 0 && i < m) {
                    j++;
                } else {
                    i--;
                    j += 2;
                }
            }
        }
        return res;
    }
}

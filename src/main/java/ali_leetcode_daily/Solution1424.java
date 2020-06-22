package ali_leetcode_daily;

import java.util.List;

/**
 * @ClassName Solution1424
 * @Description TODO
 * @Author shishi
 * @Date 2020/6/19 22:21
 **/
public class Solution1424 {
    public int[] findDiagonalOrder(List<List<Integer>> nums) {
        int[][] matrix = translate(nums);

        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return null;
        }

        int m = matrix.length;
        int n = matrix[0].length;

        int index = 0;
        int[] res = new int[m * n];

        // m行都遍历完
        for (int k = 0; k < m; k++) {
            int i = k;
            int j = 0;
            // 每一次只要不越界就可以
            // 都是从下往上的
            while (i >= 0 && j < n) {
                res[index++] = matrix[i][j];
                i--;
                j++;
            }
        }

        // 接下来遍历n列
        for (int k = 1; k < n; k++) {
            int i = m - 1;
            int j = k;
            while (i >= 0 && j < n) {
                res[index++] = matrix[i][j];
                i--;
                j++;
            }
        }

        return res;
    }

    private int[][] translate(List<List<Integer>> nums) {
        int m = nums.size();
        int n = nums.get(0).size();
        int[][] matrix = new int[m][n];
        int i = 0, j = 0;
        for (List<Integer> list : nums) {
            for (int num : list) {
                matrix[i][j++] = num;
            }
            i++;
            j = 0;
        }
        return matrix;
    }
}

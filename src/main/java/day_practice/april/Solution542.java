package day_practice.april;

/**
 * @ClassName Solution542
 * @Description 542. 01 矩阵
 * @Author shishi
 * @Date 2020/4/15 13:59
 **/

import java.util.LinkedList;
import java.util.Queue;

/**
 * 给定一个由 0 和 1 组成的矩阵，找出每个元素到最近的 0 的距离。
 * 两个相邻元素间的距离为 1 。
 * 和1162题目基本一致，可以参考
 */
public class Solution542 {
    // https://leetcode-cn.com/problems/01-matrix/solution/2chong-bfs-xiang-jie-dp-bi-xu-miao-dong-by-sweetie/
    public int[][] updateMatrix(int[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;

        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, -1, 1};

        int[][] ans = new int[n][m];
        boolean[][] flag = new boolean[n][m];
        Queue<int[]> queue = new LinkedList<>();


        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (matrix[i][j] == 0)
                    queue.offer(new int[]{i, j});
            }
        }

        // 要找的是，所以的1最近的0是多少
        // 先把所有的0都入队，然后最先找到的1就是对应的1最近的0
        while (!queue.isEmpty()) {
            int[] poll = queue.poll();
            int x = poll[0];
            int y = poll[1];

            for (int i = 0; i < 4; i++) {
                int newX = x + dx[i];
                int newY = y + dy[i];

                // 如果没有越界也没有被访问过，并且是1
                // 那么就更新为"访问过"，并且距离+1，最后入队
                if (newX >= 0 && newX < n && newY >= 0 && newY < m && !flag[newX][newY] && matrix[newX][newY] == 1) {
                    flag[newX][newY] = true;
                    ans[newX][newY] = ans[x][y] + 1;
                    queue.offer(new int[]{newX, newY});
                }
            }
        }
        return ans;
    }
}

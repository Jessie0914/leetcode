package day_practice.april;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @ClassName Solution_interview13
 * @Description 面试题13. 机器人的运动范围
 * @Author shishi
 * @Date 2020/4/19 14:44
 **/
public class Solution_interview13 {
    public int movingCount(int m, int n, int k) {
        if (m <= 0 || n <= 0)
            return 0;
        if (k <= 0)
            return 1;

        boolean[][] canArrive = new boolean[m][n];
        boolean[][] used = new boolean[m][n];
        canArrive[0][0] = true;
        used[0][0] = true;

        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{0, 0});
        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, -1, 1};

        while (!queue.isEmpty()) {
            int[] poll = queue.poll();
            int x = poll[0];
            int y = poll[1];

            for (int i = 0; i < 4; i++) {
                int newX = x + dx[i];
                int newY = y + dy[i];

                // 如果没有越界并且没有访问过并且没有超出k
                if (newX >= 0 && newX < m && newY >= 0 && newY < n && !used[newX][newY] && calculate(newX, newY) <= k) {
                    used[newX][newY] = true;
                    canArrive[newX][newY] = true;
                    queue.offer(new int[]{newX, newY});
                }
            }
        }

        int ans = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (canArrive[i][j])
                    ans++;
            }
        }
        return ans;
    }

    private int calculate(int newX, int newY) {
        int ans = 0;
        while (newX > 0) {
            ans += newX % 10;
            newX /= 10;
        }
        while (newY > 0) {
            ans += newY % 10;
            newY /= 10;
        }
        return ans;
    }
}

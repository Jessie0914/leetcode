package day_practice.march;
/**
 * @ClassName Solution1162
 * @Description 地图分析
 * @Author shishi
 * @Date 2020/3/29 15:16
 **/

import java.util.LinkedList;
import java.util.Queue;

/**
 * 输入：[[1,0,0],[0,0,0],[0,0,0]]
 * 输出：4
 * 解释：
 * 海洋区域 (2, 2) 和所有陆地区域之间的距离都达到最大，最大距离为 4。
 */

// 这里用到的是多源BFS
// 多源BFS的正确性证明：https://leetcode-cn.com/problems/as-far-from-land-as-possible/solution/zhen-liang-yan-sou-huan-neng-duo-yuan-kan-wan-miao/
// 参考网址：https://leetcode-cn.com/problems/as-far-from-land-as-possible/solution/jian-dan-java-miao-dong-tu-de-bfs-by-sweetiee/
public class Solution1162 {
    public int maxDistance(int[][] grid) {
        // 定义4个方向的数组
        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, -1, 1};

        // BFS需要用到queue，存放所有的陆地位置
        Queue<int[]> queue = new LinkedList<>();

        // 先遍历二维数组，将所有的陆地位置加入到队列中
        // queue用offer()
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1)
                    queue.offer(new int[]{i, j});
            }
        }

        int[] res = new int[]{-1, -1};

        // 开始多源BFS
        while (!queue.isEmpty()) {
            int[] poll = queue.poll();
            // 当前陆地的坐标
            int x = poll[0];
            int y = poll[1];

            // 从当前陆地开始往4个方向BFS
            for (int i = 0; i < 4; i++) {
                int newX = x + dx[i];
                int newY = y + dy[i];

                // 如果越界了或者碰到了非海洋的地方，就停止广搜
                if (newX < 0 || newX >= grid.length || newY < 0 || newY >= grid[0].length || grid[newX][newY] != 0) {
                    continue;
                }

                // 直接更新数组，就不用记录是否访问过了
                grid[newX][newY] = grid[x][y] + 1;
                // res用来保存最后一次到达的地方
                res[0] = newX;
                res[1] = newY;
                // 然后将新的海洋区域加入队列
                queue.offer(new int[]{newX, newY});
            }
        }

        // 最终res里面就记录着最后访问到的海洋位置（即最远的海洋位置）
        if (res[0] != -1 && res[1] != -1) {
            return grid[res[0]][res[1]] - 1;
        } else
            return -1;

    }
}

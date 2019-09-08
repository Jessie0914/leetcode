package breadth_search_traverse;
/**
 * @ClassName Solutoin994
 * @Description 994.腐烂的橘子
 * @Author shishi
 * @Date 2019/7/25 9:08
 **/

import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.Map;
import java.util.Queue;

/**
 * 题目过长，不复述了（这题不应该是“简单”啊）
 */
public class Solutoin994 {
    // dr和dc数组是代表着四个前进方向的
    // 比如说dr[0]、dc[0]，就代表着竖着的方向往上一格，横着的方向不动（其实就是原地往上一格）
    // dr数组代表着竖方向的动作，dc数组代表着横方向的动作
    int[] dr = new int[]{-1,0,1,0};
    int[] dc = new int[]{0,-1,0,1};
    public int orangesRotting(int[][] grid) {
        int R = grid.length;
        int C = grid[0].length;

        // 遍历二维数组，把初试就腐烂的橘子的编号存储在队列中（初试腐烂橘子的深度为0）
        Queue<Integer> queue = new ArrayDeque<>();
        // 这个map是存储，腐烂的橘子的编号以及它对应的深度
        Map<Integer, Integer> depthMap = new HashMap<>();

        // 遍历数组
        for (int r=0; r<R; r++){
            for (int c=0;c<C;c++){
                if (grid[r][c]==2){
                    int code = r*C+c;
                    queue.offer(code);
                    depthMap.put(code,0);
                }
            }
        }

        // 记录最终结果的深度
        int ansDepth = 0;
        while (!queue.isEmpty()){
            int code = queue.poll();
            int r = code/C;
            int c = code%C;

            // 遍历四个方向，找到新鲜橘子，就把它腐烂化
            for (int k=0;k<4;k++){
                // 移动之后的坐标
                int nr = r + dr[k];
                int nc = c + dc[k];
                if (nr>=0&&nr<R &&nc>=0&&nc<C &&grid[nr][nc]==1){
                    grid[nr][nc]=2;
                    int nCode = nr*C+nc;
                    queue.offer(nCode);
                    depthMap.put(nCode,depthMap.get(code)+1);
                    ansDepth = depthMap.get(nCode);
                }
            }
        }

        // 最后检查数组中是否还有新鲜的橘子
        for (int[] row : grid){
            for (int v : row){
                if (v==1){
                    return -1;
                }
            }
        }

        return ansDepth;
    }
}

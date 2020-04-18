package Depth_search_traverse;

import javafx.util.Pair;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @ClassName Solution733
 * @Description 733.图像渲染
 * @Author shishi
 * @Date 2019/7/27 11:10
 **/

// 可以借鉴一下994题"腐烂的橘子"
public class Solution733 {
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        // dr和dc数组代表着上左下右四个方向的值
        int[] dr = {-1, 0, 1, 0};
        int[] dc = {0, -1, 0, 1};

        // R、C代表二维数组的高（上下距离）和宽（左右距离）
        int R = image.length;
        int C = image[0].length;

        // 这个队列存放的是上下左右遍历时，满足条件的所有的元素位置
        Queue<Pair<Integer, Integer>> queue = new LinkedList<>();
        queue.offer(new Pair<>(sr, sc));

        // 还需要定义一个访问过的数组，防止重复遍历(一开始忘记设置visited数组，会导致重复遍历，从而死循环)
        HashMap visited = new HashMap<Pair<Integer, Integer>, Boolean>();
        visited.put(new Pair<>(sr, sc), true);

        int standColor = image[sr][sc];

        // 如果newColor和初始值的像素值是一样的，不用管下面的操作，直接返回原始数组就可以了
        if (newColor == standColor) {
            return image;
        }

        image[sr][sc] = newColor;
        while (!queue.isEmpty()) {
            Pair<Integer, Integer> poll = queue.poll();
            int pollR = poll.getKey();
            int pollC = poll.getValue();
            // 上下左右四个方向遍历
            for (int i = 0; i < dr.length; i++) {
                int nr = pollR + dr[i];
                int nc = pollC + dc[i];
                // 判断新的位置是否是二维数组里面合法的位置，并且判断是否已经遍历过
                if (0 <= nr && nr <= R - 1 && 0 <= nc && nc <= C - 1 && !visited.containsKey(new Pair<>(nr, nc))) {
                    if (image[nr][nc] == standColor) {
                        queue.offer(new Pair<>(nr, nc));
                        image[nr][nc] = newColor;
                        // 将这个元素位置，记录为“已经遍历过”
                        visited.put(new Pair<>(nr, nc), true);
                    } else continue;
                } else continue;
            }
        }

        return image;
    }

    // dfs方法(参考130题目)
    public int[][] floodFill2(int[][] image, int sr, int sc, int newColor) {
        if (image[sr][sc] == newColor)
            return image;

        int n = image.length;
        int m = image[0].length;
        int oldColor = image[sr][sc];

        dfs(image, sr, sc, oldColor, newColor);

        return image;
    }

    private void dfs(int[][] image, int i, int j, int oldColor, int newColor) {
        // image[i][j] == newColor代表已经遍历过了
        if (i < 0 || i >= image.length || j < 0 || j >= image[0].length || image[i][j] == newColor)
            return;

        if (image[i][j] == oldColor)
            image[i][j] = newColor;
        else
            return;

        // 上下左右四个方向
        dfs(image, i - 1, j, oldColor, newColor);
        dfs(image, i + 1, j, oldColor, newColor);
        dfs(image, i, j - 1, oldColor, newColor);
        dfs(image, i, j + 1, oldColor, newColor);

    }
}

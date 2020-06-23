package ali_leetcode_daily;

/**
 * @ClassName Solution79
 * @Description 单词搜索
 * @Author shishi
 * @Date 2020/6/22 22:10
 **/

import java.util.LinkedList;
import java.util.Queue;

/**
 * https://leetcode-cn.com/problems/word-search/
 * 给定一个二维网格和一个单词，找出该单词是否存在于网格中。
 * 单词必须按照字母顺序，通过相邻的单元格内的字母构成，其中“相邻”单元格是那些水平相邻或垂直相邻的单元格。同一个单元格内的字母不允许被重复使用。
 * <p>
 * board =
 * [
 * ['A','B','C','E'],
 * ['S','F','C','S'],
 * ['A','D','E','E']
 * ]
 * <p>
 * 给定 word = "ABCCED", 返回 true
 * 给定 word = "SEE", 返回 true
 * 给定 word = "ABCB", 返回 false
 */
public class Solution79 {
    public boolean exist(char[][] board, String word) {
        if (word == null || word.length() == 0 || board == null || board.length == 0 || board[0].length == 0)
            return false;

        char begin = word.charAt(0);
        Queue<int[]> queue = new LinkedList<>();
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == begin)
                    queue.offer(new int[]{i, j});
            }
        }

        if (word.length() == 1 && queue.size() > 0)
            return true;

        int index = 1;
        int m = board.length;
        int n = board[0].length;

        // 定义4个方向的数组
        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, -1, 1};

        while (!queue.isEmpty()) {
            int k = index;
            int[] poll = queue.poll();
            // 当前陆地的坐标
            int x = poll[0];
            int y = poll[1];

            for (int i = 0; i < 4; i++) {
                int newX = x + dx[i];
                int newY = y + dy[i];

                // 如果越界，退出广搜
                if (newX < 0 || newX >= m || newY < 0 || newY >= n)
                    continue;

                if (board[newX][newY] != word.charAt(index))
                    continue;

                if (index >= word.length())
                    return true;

                index++;
            }
        }


        return true;
    }
}

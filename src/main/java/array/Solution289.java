package array;

import java.awt.*;
import java.util.HashMap;
import java.util.Iterator;

/**
 * @program: leetcode
 * @description: 289. 生命游戏
 * @author: shishi
 * @create: 2019-11-13 11:54
 **/

public class Solution289 {
    public void gameOfLife(int[][] board) {
        HashMap<Point, Integer> hashMap = new HashMap<>();
        int m = board.length;
        int n = board[0].length;
        for (int i=0;i<m;i++){
            for (int j=0;j<n;j++){
                int count = 0;
                // 上
                if (i-1>=0&&board[i-1][j]==1) count++;
                // 下
                if (i+1<m&&board[i+1][j]==1) count++;
                // 左
                if (j-1>=0&&board[i][j-1]==1) count++;
                // 右
                if (j+1<n&&board[i][j+1]==1) count++;
                // 左上
                if (i-1>=0&&j-1>=0&&board[i-1][j-1]==1) count++;
                // 右上
                if (i-1>=0&&j+1<n&&board[i-1][j+1]==1) count++;
                // 左下
                if (i+1<m&&j-1>=0&&board[i+1][j-1]==1) count++;
                // 右下
                if (i+1<m&&j+1<n&&board[i+1][j+1]==1) count++;

                hashMap.put(new Point(i,j),count);
            }
        }

        // 遍历hashMap
        Iterator<Point> iterator = hashMap.keySet().iterator();
        while (iterator.hasNext()){
            Point p = iterator.next();
            int count = hashMap.get(p);
            // 如果原本是死细胞&&count==3
            if (board[p.x][p.y]==0){
                if (count==3)
                    board[p.x][p.y]=1;
            }
            else {
                // 如果少于2个，活细胞死亡
                if (count<2) board[p.x][p.y]=0;
                // 如果活细胞周围八个位置有超过三个活细胞，则该位置活细胞死亡；
                else if (count>3) board[p.x][p.y]=0;
                // 有两个或三个活细胞，则该位置活细胞仍然存活(下面这一段其实不用写了，为了代码清楚一点，加上去)
                else if (count==2||count==3) board[p.x][p.y]=1;
            }
        }
    }
}

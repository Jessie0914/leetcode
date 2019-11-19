package math;

/**
 * @program: leetcode
 * @description: 835. 图像重叠
 * @author: shishi
 * @create: 2019-11-13 10:54
 **/

import java.awt.*;
import java.util.ArrayList;
import java.util.HashSet;

/**
 * 输入：A = [[1,1,0],
 *           [0,1,0],
 *           [0,1,0]]
 *      B = [[0,0,0],
 *           [0,1,1],
 *           [0,0,1]]
 * 输出：3
 * 解释: 将 A 向右移动一个单位，然后向下移动一个单位。
 */

// 有点难以理解
public class Solution835 {
    public int largestOverlap(int[][] A, int[][] B) {
        ArrayList<Point> A1 = new ArrayList<>();
        ArrayList<Point> B1 = new ArrayList<>();
        int N = A.length;
        // 将A和B数组的所有为1的点，分别加入到A1和B1的List中
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (A[i][j] == 1) A1.add(new Point(i, j));
                if (B[i][j] == 1) B1.add(new Point(i, j));
            }
        }

        // 为B1专门建立一个HashSet，因为是移动A中的点之后和B做比较，所以B还需要一个专门用来比较的rongqi
        HashSet<Point> BPointsSet = new HashSet<>(B1);

        // 因为怕重复计算，所以对于每一个位移建立一个HashSet，已经在HashSet中的位移(x,y)就说明之前已经计算过了，不需要再计算一遍
        HashSet<Point> existDeltaSet = new HashSet<>();

        int largestOverlap = 0;
        // 对于A1的List中的每一个点，都需要去和B1中的点去比较，计算两者的位移
        for (Point a : A1){
            for (Point b : B1){
                // 计算两者的偏差位移
                Point delta = new Point(b.x - a.x, b.y - a.y);

                // 判断existDeltaSet中存不存在这个位移
                // 如果存在，就没必要计算了
                if (!existDeltaSet.contains(delta)){
                    // 如果存在，则先放入existDeltaSet
                    existDeltaSet.add(delta);

                    int curOverlap = 0;
                    // 对于A1中的每一个点，都加上这个位移之后，判断是不是和B重合了（即是不是BPointsSet中的点）
                    for (Point p : A1){
                        if (BPointsSet.contains(new Point(p.x+delta.x,p.y+delta.y)))
                            curOverlap++;
                    }
                    largestOverlap = Math.max(largestOverlap,curOverlap);
                }
            }
        }
        return largestOverlap;
    }
}

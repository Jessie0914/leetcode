package DayPractice.March;

/**
 * @ClassName Solution365
 * @Description 水壶问题
 * @Author shishi
 * @Date 2020/4/2 17:07
 **/

import javafx.scene.chart.XYChart;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

/**
 * 有两个容量分别为 x升 和 y升 的水壶以及无限多的水。请判断能否通过使用这两个水壶，从而可以得到恰好 z升 的水？
 * 如果可以，最后请用以上水壶中的一或两个来盛放取得的 z升水。
 * 你允许：
 * 装满任意一个水壶
 * 清空任意一个水壶
 * 从一个水壶向另外一个水壶倒水，直到装满或者倒空
 * <p>
 * 输入: x = 3, y = 5, z = 4
 * 输出: True
 * <p>
 * 输入: x = 2, y = 6, z = 5
 * 输出: False
 */


class Status {
    int x;
    int y;

    Status(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

public class Solution365 {
    // BFS版本(自己不会，参考别人的)
    // https://leetcode-cn.com/problems/water-and-jug-problem/solution/javade-bfsxie-fa-by-sweetiee/
    public boolean canMeasureWater(int x, int y, int z) {
        if (z == 0)
            return true;
        if (x + y < z)
            return false;
        if (x == z || y == z || x + y == z)
            return true;

        // BFS用到queue，DFS用到Stack
        Queue<Status> queue = new LinkedList<>();
        // 记录已经遍历过的状态
        HashSet<Status> visited = new HashSet<>();

        // 初始状态
        Status start = new Status(0, 0);
        queue.offer(start);
        visited.add(start);

        // BFS
        while (!queue.isEmpty()) {
            Status poll = queue.poll();
            int curX = poll.x;
            int curY = poll.y;

            if (curX == z || curY == z || curX + curY == z)
                return true;

            // 可以做如下的操作
            // 如果第一个桶为空，那么就把它填满
            if (curX == 0) {
                addIntoQueue(queue, visited, new Status(x, curY));
            }
            // 如果第二个桶为空，那么就把它填满
            if (curY == 0) {
                addIntoQueue(queue, visited, new Status(curX, y));
            }

            // 如果第一个桶半满，那么第二个桶必为空或者满
            // 可以将第二个桶倒空(不需要动第一个桶，没意义，动了肯定是遍历过的状态)
            if (curX < x) {
                addIntoQueue(queue, visited, new Status(curX, 0));
            }

            // 如果第二个桶是半满的
            if (curY < y) {
                // 将第一个桶倒空
                addIntoQueue(queue, visited, new Status(0, curY));
            }

            // 也可以从第一个桶中取水导入第二个桶中
            int moveSize2 = Math.min(curX, y - curY);
            addIntoQueue(queue, visited, new Status(curX - moveSize2, curY + moveSize2));

            // 也可以再往半满的第一个桶中加入水
            int moveSize1 = Math.min(curY, x - curX);
            addIntoQueue(queue, visited, new Status(curX + moveSize1, curY - moveSize1));
        }
        return false;
    }

    // 需要在放进队列的时候，同时更新visited的状态
    private void addIntoQueue(Queue<Status> queue, HashSet<Status> visited, Status status) {
        if (!visited.contains(status)) {
            queue.offer(status);
            visited.add(status);
        }

    }
}

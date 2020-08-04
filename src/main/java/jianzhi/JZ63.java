package jianzhi;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @Classname JZ63
 * @Description Insert()方法读取数据流，使用GetMedian()方法获取当前读取数据的中位数
 * @Date 2020/7/24 4:52 下午
 * @Created by chiyue
 */
// JZ_MARK
public class JZ63 {
    // 最小堆
    PriorityQueue<Integer> minHeap = new PriorityQueue<>();
    // 最大堆
    PriorityQueue<Integer> maxHeap = new PriorityQueue<>(new Comparator<Integer>() {
        @Override
        public int compare(Integer o1, Integer o2) {
            return o2 - o1;
        }
    });

    int count = 0;

    public void Insert(Integer num) {
        if (count % 2 == 0) {
            maxHeap.add(num);
            minHeap.add(maxHeap.poll());
        } else {
            minHeap.add(num);
            maxHeap.add(minHeap.poll());
        }
        count++;
    }

    public Double GetMedian() {
        if (count % 2 == 1) {
            return Double.valueOf(minHeap.peek());
        } else
            return Double.valueOf((minHeap.peek() + maxHeap.peek()))/2;
    }
}

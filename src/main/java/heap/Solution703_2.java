package heap;

/**
 * @ClassName Solution703_2
 * @Description Solution703的其他解法
 * @Author shishi
 * @Date 2019/6/26 11:15
 **/

import java.util.PriorityQueue;

/**
 * 可以直接用优先队列实现，效率高多了
 */
public class Solution703_2 {
    PriorityQueue<Integer> minpq;
    int size = 0;
    public Solution703_2(int k, int[] nums) {
        // 创建一个大小为k的优先队列
        this.minpq = new PriorityQueue<>(k);
        this.size = k;

        for (int i=0;i<nums.length;i++){
            add(nums[i]);
        }
    }

    public int add(int val) {
        // 如果容量还没满，不用比较，直接入优先队列即可
        if (minpq.size()<size){
            minpq.offer(val);
        }else {
            if (minpq.peek()<val){
                minpq.poll();
                minpq.offer(val);
            }
        }
        return minpq.peek();
    }
}

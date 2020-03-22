package top_interview;

/**
 * @ClassName Solution41
 * @Description 缺失的第一个正数
 * @Author shishi
 * @Date 2020/3/4 12:56
 **/

import java.util.PriorityQueue;

/**
 * 给定一个未排序的整数数组，找出其中没有出现的最小的正整数
 * 输入: [1,2,0]
 * 输出: 3
 * 输入: [3,4,-1,1]
 * 输出: 2
 * 输入: [7,8,9,11,12]
 * 输出: 1
 */
public class Solution41 {
    // 这里用到了最小堆，其实排序之后遍历也可以
    public int firstMissingPositive(int[] nums) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] <= 0)
                continue;
            else if (!minHeap.contains(nums[i]))
                minHeap.add(nums[i]);
        }

        int start = 1;
        while (!minHeap.isEmpty()) {
            if (minHeap.peek() != start)
                return start;
            else {
                minHeap.poll();
                start++;
            }
        }
        return start;
    }
}
